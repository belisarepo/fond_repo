package by.belisa.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import by.belisa.bean.KonkursyDTO;
import by.belisa.bean.ZayavkaFIDTO;
import by.belisa.entity.Konkursy;
import by.belisa.entity.OtraslNauka;
import by.belisa.entity.SectionFond;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;
import by.belisa.service.KonkursyService;
import by.belisa.service.OtraslNaukaService;
import by.belisa.service.SectionFondService;
import by.belisa.service.ZayavkaFIService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

@Controller(value="konkursyController")
@RequestMapping(value="VIEW")
public class KonkursyController {
	private static Logger log = Logger.getLogger(KonkursyController.class);
	@Autowired
	@Qualifier(value="konkursyService")
	private KonkursyService konkursyService;
	@Autowired
	@Qualifier(value="sectionFondService")
	private SectionFondService sectionFondService;
	@Autowired
	@Qualifier(value="zayavkaFIService")
	private ZayavkaFIService zayavkaFIService;
	@Autowired
	@Qualifier(value="otraslNaukaService")
	private OtraslNaukaService otraslNaukaService;
	
	@RenderMapping
	public String renderView(Model model, PortletRequest request) throws ServiceException, DaoException{
		List<KonkursyDTO> konkursyList = konkursyService.getActiveKonkursy();
		model.addAttribute("konkursyList", konkursyList);
		return "konkursy";
	}
	@RenderMapping(params="view=zayavka")
	public String renderZayavkaForm(Model model, PortletRequest request) throws ServiceException, NumberFormatException, PortalException, SystemException{
		String konkursId = ParamUtil.getString(request, "konkursId");
		Konkursy konkurs = konkursyService.get(Integer.parseInt(konkursId));
		ZayavkaFIDTO zayavkaFIDTO = zayavkaFIService.getZayavkaFIDTOByUserId(PortalUtil.getUser(request).getUserId(), Integer.parseInt(konkursId));
		List<SectionFond> sectionFondList = sectionFondService.getAll();
		List<OtraslNauka> otraslNaukaList = otraslNaukaService.getAll();
		model.addAttribute("otraslNaukaList", otraslNaukaList);
		model.addAttribute("konkurs", konkurs);
		model.addAttribute("zayavka", zayavkaFIDTO);
		model.addAttribute("sectionFondList", sectionFondList);
		return "zayavka";
	}
	@ResourceMapping()
	public void getUsloviy(ResourceRequest request, ResourceResponse response){
		
		String konkursId = ParamUtil.getString(request, "konkursId");
		byte[] usloviy = konkursyService.getUsloviy(Integer.parseInt(konkursId));
		response.setContentType("application/msword");
		response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");        
		response.setContentLength(usloviy.length);
		OutputStream outStream = null;
		try {
			outStream = response.getPortletOutputStream();
			outStream.write(usloviy);
			outStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(outStream!=null){
				try {
					outStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
