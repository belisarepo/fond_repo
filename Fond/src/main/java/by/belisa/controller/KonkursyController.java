package by.belisa.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import by.belisa.bean.AnketaDTO;
import by.belisa.bean.CheckUslResult;
import by.belisa.bean.KonkursyDTO;
import by.belisa.bean.ZayavkaFIDTO;
import by.belisa.entity.Organization;
import by.belisa.entity.OrganizationNR;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;
import by.belisa.util.Utils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

@Controller(value = "konkursyController")
@RequestMapping(value = "VIEW")
public class KonkursyController extends SaveZayavkaController{
	private static Logger log = Logger.getLogger(KonkursyController.class);
	
	@RenderMapping(params="view=userZayavki")
	public String renderUserZayavki(Model model, PortletRequest request) throws PortalException, SystemException{
		Long userId = PortalUtil.getUser(request).getUserId();
		model.addAttribute("zayavkiMap",zayavkaFIService.getUserZayavki(userId));
		return "userZayavki";
	}
	
	@RenderMapping
	public String renderView(Model model, PortletRequest request) throws ServiceException, DaoException {
		List<KonkursyDTO> konkursyList = konkursyService.getActiveKonkursy();
		model.addAttribute("konkursyList", konkursyList);
		return "konkursy";
	}

	
	@ResourceMapping()
	public void getUsloviy(ResourceRequest request, ResourceResponse response) {
		
		String konkursId = ParamUtil.getString(request, "konkursId");
		byte[] usloviy = konkursyService.getUsloviy(Integer.parseInt(konkursId));
		response.setContentType("application/msword");
		response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
		response.setContentLength(usloviy.length);
		response.setProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=uslovia.doc");
		OutputStream outStream = null;
		try {
			outStream = response.getPortletOutputStream();
			outStream.write(usloviy);
			outStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (outStream != null) {
				try {
					outStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	@RenderMapping(params = "view=zayavka")
	public String renderZayavkaForm(Model model, PortletRequest request) throws Exception {
		ZayavkaFIDTO zayavkaFIDTO = null;
		Integer konkursId = ParamUtil.getInteger(request, "konkursId");
		Integer zayavkaId = ParamUtil.getInteger(request, "zayavkaId");
		if (zayavkaId!=0){
			zayavkaFIDTO = zayavkaFIService.getZayavkaFIDTO(zayavkaId);
		}else{
			Long userId = PortalUtil.getUser(request).getUserId();
			anketaService.checkUser(PortalUtil.getUser(request));
			
			zayavkaFIDTO = zayavkaFIService.getZayavkaFIDTOByUserId(userId, konkursId);
			if (zayavkaFIDTO.getId()==null){

				AnketaDTO anketaDTO = anketaService.getDTO(userId);
				Integer fizInfoId = fizInfoService.addFizInfo(anketaDTO);
				zayavkaFIDTO.setFizInfoDTO(fizInfoService.getDTO(fizInfoId, konkursId));
				zayavkaFIDTO.setKonkursId(konkursId);
				CheckUslResult checkUslResult = konkursyService.checkUsloviyaRuk(konkursId, fizInfoId);
				if (1==2/*!checkUslResult.isAvailable()*/){
					String errorMsg = Utils.createErrorMsg(anketaDTO.getFio(), checkUslResult);
					model.addAttribute("errorMsg", errorMsg);
					return renderView(model,request);
				}
				
			}
		}
		model.addAttribute("zayavkaModel", zayavkaFIDTO);
		List<Organization> listOrg = orgService.getAll();
		model.addAttribute("listOrg", listOrg);
		
		List<OrganizationNR> orgNrList = orgNrService.getAllByKonkurs(zayavkaFIDTO.getKonkursId());
		model.addAttribute("orgNrList", orgNrList);
		return "zayavka";
	}
	
	/*@InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Set.class, "ispolniteli", new CustomCollectionEditor(Set.class)
          {
            @Override
            protected Object convertElement(Object element)
            {
                Integer id = null;

                if(element instanceof String && !((String)element).equals("")){
                    //From the JSP 'element' will be a String
                    try{
                        id = Integer.parseInt((String) element);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Element was " + ((String) element));
                        e.printStackTrace();
                    }
                }
                else if(element instanceof Integer) {
                    //From the database 'element' will be a Long
                    id = (Integer) element;
                }

                try {
					return id != null ? fizInfoService.get(id) : null;
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                return null;
            }
          });
    }*/

	
}
