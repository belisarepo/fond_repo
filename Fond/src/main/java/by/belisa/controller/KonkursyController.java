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

import by.belisa.bean.AnketaDTO;
import by.belisa.bean.CalcMaterialsDTO;
import by.belisa.bean.CalcOtherCostsDTO;
import by.belisa.bean.CalcTripDTO;
import by.belisa.bean.CalcZpDTO;
import by.belisa.bean.CheckUslResult;
import by.belisa.bean.IspolnitelDTO;
import by.belisa.bean.KonkursyDTO;
import by.belisa.bean.OrgDTO;
import by.belisa.bean.PublicationDTO;
import by.belisa.bean.ZayavkaFIDTO;
import by.belisa.dao.StatusZayavkaFIDao;
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
import by.belisa.service.AnketaService;
import by.belisa.service.CalcMaterialsService;
import by.belisa.service.CalcOtherCostsService;
import by.belisa.service.CalcTripService;
import by.belisa.service.CalcZpService;
import by.belisa.service.FizInfoService;
import by.belisa.service.IspolnitelService;
import by.belisa.service.KonkursyService;
import by.belisa.service.OrgNrService;
import by.belisa.service.OrgService;
import by.belisa.service.OtraslNaukaService;
import by.belisa.service.PrioritetNaukaService;
import by.belisa.service.PublicationService;
import by.belisa.service.SectionFondService;
import by.belisa.service.UchStepeniService;
import by.belisa.service.UchZvaniyService;
import by.belisa.service.UserService;
import by.belisa.service.ZayavkaFIService;
import by.belisa.util.Utils;

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
	@Qualifier(value = "statusZayavkaFIDao")
	private StatusZayavkaFIDao statusZayavkaFIDao;
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
	@Autowired
	@Qualifier("publicationService")
	private PublicationService publicationService;
	@Autowired
	@Qualifier("calcZpService")
	private CalcZpService calcZpService;
	@Autowired
	@Qualifier("calcTripService")
	private CalcTripService calcTripService;
	@Autowired
	@Qualifier("calcOtherCostsService")
	private CalcOtherCostsService calcOtherCostsService;
	@Autowired
	@Qualifier("calcMaterialsService")
	private CalcMaterialsService calcMaterialsService;
	@Autowired
	@Qualifier("anketaService")
	private AnketaService anketaService;
	@Autowired
	@Qualifier("userService")
	private UserService userService;

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
	
	@ModelAttribute(value = "publicationModel")
	public PublicationDTO initPublicationModel(){
		return new PublicationDTO();
	}
	
	@ModelAttribute(value = "ispolnitelModel")
	public IspolnitelDTO initIspolnitelModel(){
		return new IspolnitelDTO();
	}
	
	@ModelAttribute(value = "calcZpModel")
	public CalcZpDTO initCalcZpModel(){
		return new CalcZpDTO();
	}
	@ModelAttribute(value = "calcMaterialsModel")
	public CalcMaterialsDTO initCalcMaterialsModel(){
		return new CalcMaterialsDTO();
	}
	@ModelAttribute(value = "calcTripModel")
	public CalcTripDTO initCalcTripModel(){
		return new CalcTripDTO();
	}
	@ModelAttribute(value = "calcOtherCostsModel")
	public CalcOtherCostsDTO initCalcOtherCostsModel(){
		return new CalcOtherCostsDTO();
	}

	@RenderMapping
	public String renderView(Model model, PortletRequest request) throws ServiceException, DaoException {
		List<KonkursyDTO> konkursyList = konkursyService.getActiveKonkursy();
		model.addAttribute("konkursyList", konkursyList);
		return "konkursy";
	}

	@RenderMapping(params = "view=zayavka")
	public String renderZayavkaForm(Model model, PortletRequest request) throws ServiceException, NumberFormatException, PortalException,
			SystemException, DaoException, ParseException {
		Long userId = PortalUtil.getUser(request).getUserId();
		anketaService.checkUser(PortalUtil.getUser(request));
		String konkursId = ParamUtil.getString(request, "konkursId");
		ZayavkaFIDTO zayavkaFIDTO = zayavkaFIService.getZayavkaFIDTOByUserId(userId, Integer.parseInt(konkursId));
		if (zayavkaFIDTO.getId()==null){
			AnketaDTO anketaDTO = anketaService.getDTO(userId);
			Integer fizInfoId = fizInfoService.addFizInfo(anketaDTO);
			CheckUslResult checkUslResult = konkursyService.checkUsloviyaRuk(Integer.parseInt(konkursId), fizInfoId);
			if (!checkUslResult.isAvailable()){
				String errorMsg = Utils.createErrorMsg(anketaDTO.getFio(), checkUslResult);
				model.addAttribute("errorMsg", errorMsg);
				return renderView(model,request);
			}
		}
		model.addAttribute("zayavkaModel", zayavkaFIDTO);
		List<Organization> listOrg = orgService.getAll();
		model.addAttribute("listOrg", listOrg);
		List<OrganizationNR> orgNrList = orgNrService.getAll();
		model.addAttribute("orgNrList", orgNrList);
		return "zayavka";
	}

	@ActionMapping(params="action=send")
	public void sendZayavka(ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException, NumberFormatException, ServiceException {
		String zayavkaId = ParamUtil.getString(req, "zayavkaId");
		if (!zayavkaId.isEmpty()){
			
			zayavkaFIService.changeStatus(3, Integer.parseInt(zayavkaId));
			model.addAttribute("save_result", "Заявка подана");
		}else{
			model.addAttribute("errorMsg", "Заявка не заполнена");
		}
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}
//	@ActionMapping
//	public void saveZayavka(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
//		zayavkaFIService.saveOrUpdate(zayavkaFIDTO);
//		resp.setRenderParameter("view", "zayavka");
//		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
//		model.addAttribute("save_result", "Сохранено");
//	}
	
	@ActionMapping(params="form=form1")
	public void saveForm1(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm1(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form2")
	public void saveForm2(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm2(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form3")
	public void saveForm3(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm3(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form4")
	public void saveForm4(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm4(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form5")
	public void saveForm5(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm5(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form8")
	public void saveForm8(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm8(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form9")
	public void saveForm9(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm9(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form10")
	public void saveForm10(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm10(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form11")
	public void saveForm11(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm11(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	@ActionMapping(params="form=form12")
	public void saveForm12(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm12(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form13")
	public void saveForm13(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm13(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form15")
	public void saveForm15(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		zayavkaFIService.saveForm15(zayavkaFIDTO);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	@ActionMapping(params = "action=addIspolnitel")
	public void addIspolnitel(@ModelAttribute IspolnitelDTO ispolnitelDTO, ActionRequest req, ActionResponse resp, Model model) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
	
			String konkursId = ParamUtil.getString(req, "konkursId");
			Long userId = PortalUtil.getUser(req).getUserId();
			ZayavkaFIDTO zayavkaFIDTO = zayavkaFIService.getZayavkaFIDTOByUserId(PortalUtil.getUser(req).getUserId(), Integer.parseInt(konkursId));
			if (zayavkaFIDTO.getId()==null){
				zayavkaFIDTO.setUserId(userId);
				zayavkaFIDTO.setKonkursId(Integer.parseInt(konkursId));
				Integer zayavkaFIId = zayavkaFIService.saveOrUpdate(zayavkaFIDTO);
				zayavkaFIDTO.setId(zayavkaFIId);
			}
			
			ispolnitelDTO.setZayavkaFIId(zayavkaFIDTO.getId());
			Integer fizInfoId = fizInfoService.addFizInfo(ispolnitelDTO);
			CheckUslResult checkUslResult = konkursyService.checkUsloviyaIspl(Integer.parseInt(konkursId), fizInfoId); 
			if (!checkUslResult.isAvailable()){
				String errorMsg = Utils.createErrorMsg(ispolnitelDTO.getSurname(), checkUslResult);
				model.addAttribute("errorMsg", errorMsg);
			}else{
				fizInfoService.addZayavkaFI(fizInfoId,zayavkaFIDTO.getId());
				ispolnitelService.saveOrUpdate(ispolnitelDTO);
			}	
			resp.setRenderParameter("view", "zayavka");
			resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}
	
	@ActionMapping(params = "action=addSoOrg")
	public void addSoOrg(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
	
			Integer konkursId = ParamUtil.getInteger(req, "konkursId");
			Integer soOrgId = ParamUtil.getInteger(req, "soOrgId");;
			ZayavkaFIDTO zayavkaFIDTO = zayavkaFIService.getZayavkaFIDTOByUserId(PortalUtil.getUser(req).getUserId(), konkursId);
			if (zayavkaFIDTO.getId()==null){
				zayavkaFIDTO.setUserId(PortalUtil.getUser(req).getUserId());
				zayavkaFIDTO.setKonkursId(konkursId);
				Integer zayavkaFIId = zayavkaFIService.saveOrUpdate(zayavkaFIDTO);
				zayavkaFIDTO.setId(zayavkaFIId);
			}
			orgService.addSoOrg(soOrgId, zayavkaFIDTO.getId());
			resp.setRenderParameter("view", "zayavka");
			resp.setRenderParameter("konkursId", konkursId.toString());
	}
	
	@ActionMapping(params = "action=addPublication")
	public void addPublication(@ModelAttribute(value="publicationModel") PublicationDTO publication, ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
			Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
			Integer konkursId = ParamUtil.getInteger(req, "konkursId");
			Long userId = PortalUtil.getUser(req).getUserId();
			ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO();
			zayavkaFIDTO.setId(zayavkaId);
			zayavkaFIDTO.setKonkursId(konkursId);
			zayavkaFIDTO.setUserId(userId);
			zayavkaFIService.addPublication(zayavkaFIDTO,publication);
			resp.setRenderParameter("view", "zayavka");
			resp.setRenderParameter("konkursId", konkursId.toString());
	}
	
	@ActionMapping(params = "action=addCalcZp")
	public void addCalcZp(@ModelAttribute(value="calcZpModel") CalcZpDTO calcZp, ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
			Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
			Integer konkursId = ParamUtil.getInteger(req, "konkursId");
			Long userId = PortalUtil.getUser(req).getUserId();
			ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO();
			zayavkaFIDTO.setId(zayavkaId);
			zayavkaFIDTO.setKonkursId(konkursId);
			zayavkaFIDTO.setUserId(userId);
			zayavkaFIService.addCalcZp(zayavkaFIDTO,calcZp);
			resp.setRenderParameter("view", "zayavka");
			resp.setRenderParameter("konkursId", konkursId.toString());
	}
	@ActionMapping(params = "action=addCalcMaterials")
	public void addCalcMaterials(@ModelAttribute(value="calcMaterialsModel") CalcMaterialsDTO calcMaterials, ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
			Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
			Integer konkursId = ParamUtil.getInteger(req, "konkursId");
			Long userId = PortalUtil.getUser(req).getUserId();
			ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO();
			zayavkaFIDTO.setId(zayavkaId);
			zayavkaFIDTO.setKonkursId(konkursId);
			zayavkaFIDTO.setUserId(userId);
			zayavkaFIService.addCalcMaterials(zayavkaFIDTO,calcMaterials);
			resp.setRenderParameter("view", "zayavka");
			resp.setRenderParameter("konkursId", konkursId.toString());
	}
	@ActionMapping(params = "action=addCalcTrip")
	public void addCalcTrip(@ModelAttribute(value="calcTripModel") CalcTripDTO calcTrip, ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
			Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
			Integer konkursId = ParamUtil.getInteger(req, "konkursId");
			Long userId = PortalUtil.getUser(req).getUserId();
			ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO();
			zayavkaFIDTO.setId(zayavkaId);
			zayavkaFIDTO.setKonkursId(konkursId);
			zayavkaFIDTO.setUserId(userId);
			zayavkaFIService.addCalcTrip(zayavkaFIDTO,calcTrip);
			resp.setRenderParameter("view", "zayavka");
			resp.setRenderParameter("konkursId", konkursId.toString());
	}
	@ActionMapping(params = "action=addCalcOtherCosts")
	public void addCalcOtherCosts(@ModelAttribute(value="calcOtherCostsModel") CalcOtherCostsDTO calcOtherCosts, ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
			Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
			Integer konkursId = ParamUtil.getInteger(req, "konkursId");
			Long userId = PortalUtil.getUser(req).getUserId();
			ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO();
			zayavkaFIDTO.setId(zayavkaId);
			zayavkaFIDTO.setKonkursId(konkursId);
			zayavkaFIDTO.setUserId(userId);
			zayavkaFIService.addCalcOtherCosts(zayavkaFIDTO,calcOtherCosts);
			resp.setRenderParameter("view", "zayavka");
			resp.setRenderParameter("konkursId", konkursId.toString());
	}
	
	@ActionMapping(params = "action=deleteIspolnitel")
	public void deleteIspolnitel(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		
		Integer ispolnitelId = ParamUtil.getInteger(req, "ispolnitelId");
		Ispolnitel ispolnitel = ispolnitelService.get(ispolnitelId);
		if (ispolnitel!=null){
			fizInfoService.removeZayavkaFI(PortalUtil.getUser(req).getUserId(), Integer.parseInt(ParamUtil.getString(req, "konkursId")), ispolnitel);
			ispolnitelService.delete(ispolnitel);
		}
		
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
		
		
	}
	
	@ActionMapping(params = "action=deletePublication")
	public void deletePublication(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		Integer publicationId = ParamUtil.getInteger(req, "publicationId");
		publicationService.delete(publicationService.get(publicationId));
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}
	
	@ActionMapping(params = "action=deleteCalcZp")
	public void deleteCalcZp(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		Integer calcZpId = ParamUtil.getInteger(req, "calcZpId");
		calcZpService.delete(calcZpService.get(calcZpId));
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}
	@ActionMapping(params = "action=deleteCalcTrip")
	public void deleteCalcTrip(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		Integer calcTripId = ParamUtil.getInteger(req, "calcTripId");
		calcTripService.delete(calcTripService.get(calcTripId));
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}
	@ActionMapping(params = "action=deleteCalcOtherCosts")
	public void deleteCalcOtherCosts(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		Integer calcOtherCostsId = ParamUtil.getInteger(req, "calcOtherCostsId");
		calcOtherCostsService.delete(calcOtherCostsService.get(calcOtherCostsId));
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}
	@ActionMapping(params = "action=deleteCalcMaterials")
	public void deleteCalcMaterials(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		Integer calcMaterialsId = ParamUtil.getInteger(req, "calcMaterialsId");
		calcMaterialsService.delete(calcMaterialsService.get(calcMaterialsId));
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
