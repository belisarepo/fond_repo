package by.belisa.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import by.belisa.bean.IspolnitelDTO;
import by.belisa.bean.KonkursyDTO;
import by.belisa.bean.OrgDTO;
import by.belisa.bean.ZayavkaFIDTO;
import by.belisa.entity.Ispolnitel;
import by.belisa.entity.Organization;
import by.belisa.entity.OrganizationNR;
import by.belisa.entity.OtraslNauka;
import by.belisa.entity.PrioritetNauka;
import by.belisa.entity.SectionFond;
import by.belisa.entity.UchStepeni;
import by.belisa.entity.UchZvaniy;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;
import by.belisa.service.FizInfoService;
import by.belisa.service.IspolnitelService;
import by.belisa.service.KonkursyService;
import by.belisa.service.OrgNrService;
import by.belisa.service.OrgService;
import by.belisa.service.OtraslNaukaService;
import by.belisa.service.PrioritetNaukaService;
import by.belisa.service.SectionFondService;
import by.belisa.service.UchStepeniService;
import by.belisa.service.UchZvaniyService;
import by.belisa.service.ZayavkaFIService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

@Controller(value = "konkursyController")
@RequestMapping(value = "VIEW")
public class KonkursyController {
	private static Logger log = Logger.getLogger(KonkursyController.class);
	@Autowired
	@Qualifier(value = "konkursyService")
	private KonkursyService konkursyService;
	@Autowired
	@Qualifier(value = "sectionFondService")
	private SectionFondService sectionFondService;
	@Autowired
	@Qualifier(value = "zayavkaFIService")
	private ZayavkaFIService zayavkaFIService;
	@Autowired
	@Qualifier(value = "otraslNaukaService")
	private OtraslNaukaService otraslNaukaService;
	@Autowired
	@Qualifier(value = "prioritetNaukaService")
	private PrioritetNaukaService prioritetNaukaService;
	@Autowired
	@Qualifier(value = "orgService")
	private OrgService orgService;
	@Autowired
	@Qualifier(value = "orgNrService")
	private OrgNrService orgNrService;
	@Autowired
	@Qualifier(value = "fizInfoService")
	private FizInfoService fizInfoService;
	@Autowired
	@Qualifier(value = "ispolnitelService")
	private IspolnitelService ispolnitelService;
	@Autowired
	@Qualifier("uchStepeniService")
	private UchStepeniService uchStepeniService;
	@Autowired
	@Qualifier("uchZvaniyService")
	private UchZvaniyService uchZvaniyService;

	private List<OtraslNauka> otraslNaukaList = null;
	private List<SectionFond> sectionFondList = null;
	private List<PrioritetNauka> prioritetNaukaList = null;
	private List<UchStepeni> uchStepeniList = null;
	private List<UchZvaniy> uchZvaniyList = null;

	@ModelAttribute(value = "otraslNaukaList")
	public List<OtraslNauka> initOtraslNaukaList() throws ServiceException {
		if (otraslNaukaList == null) {
			otraslNaukaList = otraslNaukaService.getAll();
		}
		return otraslNaukaList;
	}
	@ModelAttribute(value = "uchStepeniList")
	public List<UchStepeni> initUchStepeniList() throws ServiceException {
		if (uchStepeniList == null) {
			uchStepeniList = uchStepeniService.getAll();
		}
		return uchStepeniList;
	}
	@ModelAttribute(value = "uchZvaniyList")
	public List<UchZvaniy> initUchZvaniyList() throws ServiceException {
		if (uchZvaniyList == null) {
			uchZvaniyList = uchZvaniyService.getAll();
		}
		return uchZvaniyList;
	}


	@ModelAttribute(value = "sectionFondList")
	public List<SectionFond> initSectionFondList() throws ServiceException {
		if (sectionFondList == null) {
			sectionFondList = sectionFondService.getAll();
		}
		return sectionFondList;
	}

	@ModelAttribute(value = "prioritetNaukaList")
	public List<PrioritetNauka> initPrioritetNaukaList() throws ServiceException {
		if (prioritetNaukaList == null) {
			prioritetNaukaList = prioritetNaukaService.getAll();
		}
		return prioritetNaukaList;
	}

	@RenderMapping
	public String renderView(Model model, PortletRequest request) throws ServiceException, DaoException {
		List<KonkursyDTO> konkursyList = konkursyService.getActiveKonkursy();
		model.addAttribute("konkursyList", konkursyList);
		return "konkursy";
	}

	@RenderMapping(params = "view=zayavka")
	public String renderZayavkaForm(ModelMap model, PortletRequest request) throws ServiceException, NumberFormatException, PortalException,
			SystemException, DaoException {
		
		String konkursId = ParamUtil.getString(request, "konkursId");
		ZayavkaFIDTO zayavkaFIDTO = zayavkaFIService.getZayavkaFIDTOByUserId(PortalUtil.getUser(request).getUserId(), Integer.parseInt(konkursId));
		
		model.addAttribute("zayavkaModel", zayavkaFIDTO);
		List<Organization> listOrg = orgService.getAll();
		model.addAttribute("listOrg", listOrg);
		List<OrganizationNR> orgNrList = orgNrService.getAll();
		model.addAttribute("orgNrList", orgNrList);
		List<IspolnitelDTO> ispolniteliList = ispolnitelService.getAllDTOByZayavkaId(zayavkaFIDTO.getId());
		model.addAttribute("ispolniteliList", ispolniteliList);
		model.addAttribute("ispolnitelModel", new IspolnitelDTO());
		return "zayavka";
	}

	
	@ActionMapping
	public void saveZayavka(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveOrUpdate(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "ok");
	}
	
	@ActionMapping(params="form=form1")
	public void saveForm1(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm1(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "ok");
	}
	
	@ActionMapping(params="form=form2")
	public void saveForm2(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm2(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "ok");
	}
	
	@ActionMapping(params="form=form3")
	public void saveForm3(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm3(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "ok");
	}
	
	@ActionMapping(params="form=form4")
	public void saveForm4(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm4(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "ok");
	}
	
	@ActionMapping(params="form=form5")
	public void saveForm5(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm5(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "ok");
	}
	
	@ActionMapping(params="form=form8")
	public void saveForm8(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm8(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "ok");
	}
	
	@ActionMapping(params="form=form9")
	public void saveForm9(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm9(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "ok");
	}
	
	@ActionMapping(params="form=form10")
	public void saveForm10(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm10(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "ok");
	}
	
	@ActionMapping(params="form=form11")
	public void saveForm11(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm11(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "ok");
	}
	
	@ActionMapping(params = "action=addIspolnitel")
	public void addIspolnitel(@ModelAttribute IspolnitelDTO ispolnitelDTO, ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
	
			String konkursId = ParamUtil.getString(req, "konkursId");
			ZayavkaFIDTO zayavkaFIDTO = zayavkaFIService.getZayavkaFIDTOByUserId(PortalUtil.getUser(req).getUserId(), Integer.parseInt(konkursId));
			if (zayavkaFIDTO.getId()==null){
				zayavkaFIDTO.setUserId(PortalUtil.getUser(req).getUserId());
				zayavkaFIDTO.setKonkursId(Integer.parseInt(konkursId));
				Integer zayavkaFIId = zayavkaFIService.saveOrUpdate(zayavkaFIDTO);
				zayavkaFIDTO.setId(zayavkaFIId);
			}
			
			ispolnitelDTO.setZayavkaFIId(zayavkaFIDTO.getId());
			fizInfoService.addFizInfo(ispolnitelDTO);
			ispolnitelService.saveOrUpdate(ispolnitelDTO);
			resp.setRenderParameter("view", "zayavka");
			resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}
	
	@ActionMapping(params = "action=addSoOrg")
	public void addSoOrg(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
	
			String konkursId = ParamUtil.getString(req, "konkursId");
			String soOrgId = ParamUtil.getString(req, "soOrgId");;
			ZayavkaFIDTO zayavkaFIDTO = zayavkaFIService.getZayavkaFIDTOByUserId(PortalUtil.getUser(req).getUserId(), Integer.parseInt(konkursId));
			if (zayavkaFIDTO.getId()==null){
				zayavkaFIDTO.setUserId(PortalUtil.getUser(req).getUserId());
				zayavkaFIDTO.setKonkursId(Integer.parseInt(konkursId));
				Integer zayavkaFIId = zayavkaFIService.saveOrUpdate(zayavkaFIDTO);
				zayavkaFIDTO.setId(zayavkaFIId);
			}
			orgService.addSoOrg(Integer.parseInt(soOrgId), zayavkaFIDTO.getId());
			resp.setRenderParameter("view", "zayavka");
			resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}
	
	@ActionMapping(params = "action=deleteIspolnitel")
	public void deleteIspolnitel(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		
		Integer ispolnitelId = ParamUtil.getInteger(req, "ispolnitelId");
		Ispolnitel ispolnitel = ispolnitelService.get(ispolnitelId);
		if (ispolnitel!=null){
			fizInfoService.removeFizInfoFromZayavkaFI(PortalUtil.getUser(req).getUserId(), Integer.parseInt(ParamUtil.getString(req, "konkursId")), ispolnitel);
			ispolnitelService.delete(ispolnitel);
		}
		
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
		
		
	}
	
	@ActionMapping(params = "action=deleteSoOrg")
	public void deleteSoOrg(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		
		Integer soOrgId = ParamUtil.getInteger(req, "soOrgId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		orgService.deleteSoOrg(soOrgId, zayavkaId);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
		
		
	}

	@ResourceMapping()
	public void getUsloviy(ResourceRequest request, ResourceResponse response) {
		
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

	@RenderMapping(params = "action=popup")
	public String renderPopup(Model model, PortletRequest request) {
		String inputId = ParamUtil.getString(request, "input_id");
		model.addAttribute("input_id", inputId);
		return "popup";
	}
	
	@ResourceMapping(value="getOrgById")
	public void getOrgByid(ResourceRequest request, ResourceResponse response) throws IOException, NumberFormatException, DaoException{
		OutputStream outStream = response.getPortletOutputStream();
		String orgId = request.getParameter("orgId");
		OrgDTO orgDTO = orgService.getOrgDTOById(Integer.parseInt(orgId));
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(orgDTO);
	    outStream.write(jsonString.getBytes());
	}
	
	@ResourceMapping(value="getOrgNrById")
	public void getOrgNrByid(ResourceRequest request, ResourceResponse response) throws IOException, NumberFormatException, DaoException, ServiceException{
		OutputStream outStream = response.getPortletOutputStream();
		String orgId = request.getParameter("orgId");
		OrganizationNR orgNr = orgNrService.get(Integer.parseInt(orgId));
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(orgNr);
	    outStream.write(jsonString.getBytes());
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
