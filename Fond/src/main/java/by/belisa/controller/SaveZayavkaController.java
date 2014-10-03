package by.belisa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import by.belisa.bean.CalcMaterialsDTO;
import by.belisa.bean.CalcOtherCostsDTO;
import by.belisa.bean.CalcTripDTO;
import by.belisa.bean.CalcZpDTO;
import by.belisa.bean.CheckUslResult;
import by.belisa.bean.IspolnitelDTO;
import by.belisa.bean.OrgDTO;
import by.belisa.bean.PublicationDTO;
import by.belisa.bean.PublicationMDTO;
import by.belisa.bean.ZayavkaFIDTO;
import by.belisa.dao.StatusZayavkaFIDao;
import by.belisa.entity.Ispolnitel;
import by.belisa.entity.OrganizationNR;
import by.belisa.entity.OtraslNauka;
import by.belisa.entity.PrioritetNauka;
import by.belisa.entity.PublicationType;
import by.belisa.entity.SectionFond;
import by.belisa.entity.UchStepeni;
import by.belisa.entity.UchZvaniy;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;
import by.belisa.service.AnketaService;
import by.belisa.service.CalcMaterialsService;
import by.belisa.service.CalcMaterialsSumService;
import by.belisa.service.CalcOtherCostsService;
import by.belisa.service.CalcOtherCostsSumService;
import by.belisa.service.CalcTripService;
import by.belisa.service.CalcTripSumService;
import by.belisa.service.CalcZpService;
import by.belisa.service.CalcZpSumService;
import by.belisa.service.FizInfoService;
import by.belisa.service.IspolnitelService;
import by.belisa.service.KonkursyService;
import by.belisa.service.OrgNrService;
import by.belisa.service.OrgService;
import by.belisa.service.OtraslNaukaService;
import by.belisa.service.PetitionService;
import by.belisa.service.PrioritetNaukaService;
import by.belisa.service.PublicationMService;
import by.belisa.service.PublicationService;
import by.belisa.service.PublicationTypeService;
import by.belisa.service.SectionFondService;
import by.belisa.service.UchStepeniService;
import by.belisa.service.UchZvaniyService;
import by.belisa.service.UserService;
import by.belisa.service.ZayavkaFIService;
import by.belisa.util.Utils;
import by.belisa.validation.ValidationResult;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
@Controller
public abstract class SaveZayavkaController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	@Qualifier(value = "statusZayavkaFIDao")
	protected StatusZayavkaFIDao statusZayavkaFIDao;
	@Autowired
	@Qualifier(value = "konkursyService")
	protected KonkursyService konkursyService;
	@Autowired
	@Qualifier(value = "sectionFondService")
	protected SectionFondService sectionFondService;
	@Autowired
	@Qualifier(value = "zayavkaFIService")
	protected ZayavkaFIService zayavkaFIService;
	@Autowired
	@Qualifier(value = "otraslNaukaService")
	protected OtraslNaukaService otraslNaukaService;
	@Autowired
	@Qualifier(value = "prioritetNaukaService")
	protected PrioritetNaukaService prioritetNaukaService;
	@Autowired
	@Qualifier(value = "orgService")
	protected OrgService orgService;
	@Autowired
	@Qualifier(value = "petitionService")
	protected PetitionService petitionService;
	@Autowired
	@Qualifier(value = "orgNrService")
	protected OrgNrService orgNrService;
	@Autowired
	@Qualifier(value = "fizInfoService")
	protected FizInfoService fizInfoService;
	@Autowired
	@Qualifier(value = "ispolnitelService")
	protected IspolnitelService ispolnitelService;
	@Autowired
	@Qualifier("uchStepeniService")
	protected UchStepeniService uchStepeniService;
	@Autowired
	@Qualifier("uchZvaniyService")
	protected UchZvaniyService uchZvaniyService;
	@Autowired
	@Qualifier("publicationService")
	protected PublicationService publicationService;
	@Autowired
	@Qualifier("publicationMService")
	protected PublicationMService publicationMService;
	@Autowired
	@Qualifier("calcZpService")
	protected CalcZpService calcZpService;
	@Autowired
	@Qualifier("calcZpSumService")
	protected CalcZpSumService calcZpSumService;
	@Autowired
	@Qualifier("calcTripService")
	protected CalcTripService calcTripService;
	@Autowired
	@Qualifier("calcTripSumService")
	protected CalcTripSumService calcTripSumService;
	@Autowired
	@Qualifier("calcOtherCostsService")
	protected CalcOtherCostsService calcOtherCostsService;
	@Autowired
	@Qualifier("calcOtherCostsSumService")
	protected CalcOtherCostsSumService calcOtherCostsSumService;
	@Autowired
	@Qualifier("calcMaterialsService")
	protected CalcMaterialsService calcMaterialsService;
	@Autowired
	@Qualifier("calcMaterialsSumService")
	protected CalcMaterialsSumService calcMaterialsSumService;
	@Autowired
	@Qualifier("anketaService")
	protected AnketaService anketaService;
	@Autowired
	@Qualifier("userService")
	protected UserService userService;
	@Autowired
	@Qualifier("publicationTypeService")
	protected PublicationTypeService publicationTypeService;

	private List<OtraslNauka> otraslNaukaList = null;
	private List<SectionFond> sectionFondList = null;
	private List<PrioritetNauka> prioritetNaukaList = null;
	private List<UchStepeni> uchStepeniList = null;
	private List<UchZvaniy> uchZvaniyList = null;
	private List<PublicationType> publicationTypes = null;

	@ModelAttribute(value = "publicationTypes")
	public List<PublicationType> initPublicationTypes() throws ServiceException {
		if (publicationTypes == null) {
			publicationTypes = publicationTypeService.getAll();
		}
		return publicationTypes;
	}
	
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
	public List<PrioritetNauka> initPrioritetNaukaList() throws ServiceException, DaoException {
		if (prioritetNaukaList == null) {
			prioritetNaukaList = prioritetNaukaService.getAllActual();
		}
		return prioritetNaukaList;
	}
	
	@ModelAttribute(value = "publicationModel")
	public PublicationDTO initPublicationModel(){
		return new PublicationDTO();
	}
	
	@ModelAttribute(value = "publicationMModel")
	public PublicationMDTO initPublicationMModel(){
		return new PublicationMDTO();
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

	
	@RenderMapping(params = "view=zayavka")
	public abstract String renderZayavkaForm(Model model, PortletRequest request) throws Exception ;

	@ActionMapping(params="action=send")
	public void sendZayavka(ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException, NumberFormatException, ServiceException {
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		ValidationResult vr = null;
		
		if (zayavkaId!=0){
			
			vr = zayavkaFIService.checkZayavkaFI(zayavkaId);
			
			if (vr.isOk()){
				zayavkaFIService.changeStatus(3, zayavkaId);
				model.addAttribute("save_result", "Заявка подана");
			}else{
				model.addAttribute("errorMsg", Utils.createErrorMsg(vr));
			}
		}else{
			model.addAttribute("errorMsg", "Заявка не заполнена");
		}
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
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
		Integer zayavkaId = zayavkaFIService.saveForm1(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form2")
	public void saveForm2(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm2(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form3")
	public void saveForm3(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm3(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form4")
	public void saveForm4(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm4(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form5")
	public void saveForm5(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm5(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form8")
	public void saveForm8(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm8(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form9")
	public void saveForm9(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm9(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form10")
	public void saveForm10(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm10(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form11")
	public void saveForm11(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm11(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	@ActionMapping(params="form=form12")
	public void saveForm12(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm12(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form13")
	public void saveForm13(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm13(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}
	
	@ActionMapping(params="form=form15")
	public void saveForm15(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm15(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
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
			ispolnitelDTO.setFizInfoId(fizInfoId);
			CheckUslResult checkUslResult = konkursyService.checkUsloviyaIspl(Integer.parseInt(konkursId), fizInfoId); 
			if (!checkUslResult.isAvailable()){
				String errorMsg = Utils.createErrorMsg(ispolnitelDTO.getSurname(), checkUslResult);
				model.addAttribute("errorMsg", errorMsg);
			}else{
				fizInfoService.addZayavkaFI(fizInfoId,zayavkaFIDTO.getId());
				ispolnitelService.saveOrUpdate(ispolnitelDTO);
			}	
			resp.setRenderParameter("zayavkaId", zayavkaFIDTO.getId().toString());
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
			resp.setRenderParameter("zayavkaId", zayavkaFIDTO.getId().toString());
			resp.setRenderParameter("view", "zayavka");
			resp.setRenderParameter("konkursId", konkursId.toString());
	}
	
	@ActionMapping(params = "action=addPetition")
	public void addPetition(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
			
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		Integer konkursId = ParamUtil.getInteger(req, "konkursId");
		Long userId = PortalUtil.getUser(req).getUserId();
		String petitionName = ParamUtil.getString(req, "petitionName");
		
		ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO();
		zayavkaFIDTO.setId(zayavkaId);
		zayavkaFIDTO.setKonkursId(konkursId);
		zayavkaFIDTO.setUserId(userId);
		zayavkaId = zayavkaFIService.addPetition(zayavkaFIDTO,petitionName);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
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
			zayavkaId = zayavkaFIService.addPublication(zayavkaFIDTO,publication);
			resp.setRenderParameter("zayavkaId", zayavkaId.toString());
			resp.setRenderParameter("view", "zayavka");
			resp.setRenderParameter("konkursId", konkursId.toString());
	}
	
	
	@ActionMapping(params = "action=addPublicationM")
	public void addPublicationM(@ModelAttribute(value="publicationMModel") PublicationMDTO publication, ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
			Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
			Integer konkursId = ParamUtil.getInteger(req, "konkursId");
			Integer fizInfoId = ParamUtil.getInteger(req, "fizInfoId");
			publication.setFizInfoId(fizInfoId);
			Long userId = PortalUtil.getUser(req).getUserId();
			ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO();
			zayavkaFIDTO.setId(zayavkaId);
			zayavkaFIDTO.setKonkursId(konkursId);
			zayavkaFIDTO.setUserId(userId);
			zayavkaId = zayavkaFIService.addPublicationM(zayavkaFIDTO,publication);
			resp.setRenderParameter("zayavkaId", zayavkaId.toString());
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
			zayavkaId = zayavkaFIService.addCalcZp(zayavkaFIDTO,calcZp);
			resp.setRenderParameter("zayavkaId", zayavkaId.toString());
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
			zayavkaId = zayavkaFIService.addCalcMaterials(zayavkaFIDTO,calcMaterials);
			resp.setRenderParameter("view", "zayavka");
			resp.setRenderParameter("zayavkaId", zayavkaId.toString());
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
			zayavkaId = zayavkaFIService.addCalcTrip(zayavkaFIDTO,calcTrip);
			resp.setRenderParameter("view", "zayavka");
			resp.setRenderParameter("konkursId", konkursId.toString());
			resp.setRenderParameter("zayavkaId", zayavkaId.toString());
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
			zayavkaId = zayavkaFIService.addCalcOtherCosts(zayavkaFIDTO,calcOtherCosts);
			resp.setRenderParameter("view", "zayavka");
			resp.setRenderParameter("zayavkaId", zayavkaId.toString());
			resp.setRenderParameter("konkursId", konkursId.toString());
	}
	
	@ActionMapping(params = "action=deleteIspolnitel")
	public void deleteIspolnitel(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		
		Integer ispolnitelId = ParamUtil.getInteger(req, "ispolnitelId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		Ispolnitel ispolnitel = ispolnitelService.get(ispolnitelId);
		if (ispolnitel!=null){
			fizInfoService.removeZayavkaFI(zayavkaId, ispolnitel);
			ispolnitelService.delete(ispolnitel);
		}
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
		
		
	}
	@ActionMapping(params = "action=deletePetition")
	public void deletePetition(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		Integer petitionId = ParamUtil.getInteger(req, "petitionId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		petitionService.delete(petitionService.get(petitionId));
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}
	@ActionMapping(params = "action=deletePublication")
	public void deletePublication(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		Integer publicationId = ParamUtil.getInteger(req, "publicationId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		publicationService.delete(publicationService.get(publicationId));
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}
	
	@ActionMapping(params = "action=deletePublicationM")
	public void deletePublicationM(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		Integer publicationId = ParamUtil.getInteger(req, "publicationId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		publicationMService.delete(publicationMService.get(publicationId));
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}
	
	@ActionMapping(params = "action=deleteCalcZp")
	public void deleteCalcZp(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		Integer calcZpId = ParamUtil.getInteger(req, "calcZpId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		calcZpService.delete(calcZpService.get(calcZpId));
		calcZpSumService.recalculate(zayavkaId);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}
	@ActionMapping(params = "action=deleteCalcTrip")
	public void deleteCalcTrip(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		Integer calcTripId = ParamUtil.getInteger(req, "calcTripId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		calcTripService.delete(calcTripService.get(calcTripId));
		calcTripSumService.recalculate(zayavkaId);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}
	@ActionMapping(params = "action=deleteCalcOtherCosts")
	public void deleteCalcOtherCosts(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		Integer calcOtherCostsId = ParamUtil.getInteger(req, "calcOtherCostsId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		calcOtherCostsService.delete(calcOtherCostsService.get(calcOtherCostsId));
		calcOtherCostsSumService.recalculate(zayavkaId);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}
	@ActionMapping(params = "action=deleteCalcMaterials")
	public void deleteCalcMaterials(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		Integer calcMaterialsId = ParamUtil.getInteger(req, "calcMaterialsId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		calcMaterialsService.delete(calcMaterialsService.get(calcMaterialsId));
		calcMaterialsSumService.recalculate(zayavkaId);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}
	
	@ActionMapping(params = "action=deleteSoOrg")
	public void deleteSoOrg(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException{
		
		Integer soOrgId = ParamUtil.getInteger(req, "soOrgId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		orgService.deleteSoOrg(soOrgId, zayavkaId);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}
	
	@RenderMapping(params = "action=editPublication")
	public String renderEditPublicationForm(Model model, PortletRequest request) throws ServiceException, DaoException{
		Integer id = ParamUtil.getInteger(request, "publId");
		PublicationDTO publ = publicationService.getDTO(id);
		model.addAttribute("publModel", publ);
		return "editPublicationForm";
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
	@ResourceMapping(value = "editPublication")
	public void editPublication(ResourceRequest req, ResourceResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException, IOException{
//		OutputStream outStream = resp.getPortletOutputStream();
		String publId = req.getParameter("id");
		String name = req.getParameter("name");
		String edition = req.getParameter("edition");
		String authors = req.getParameter("authors");
		String citationIndex = req.getParameter("citationIndex");
		String database = req.getParameter("database");
		PublicationDTO dto = new PublicationDTO(Integer.parseInt(publId), name, edition, authors, citationIndex, database);
		publicationService.edit(dto);	
//		outStream.write(0);
	}
	
	@ResourceMapping(value="report")
	public void getReport(ResourceRequest request, ResourceResponse response) throws IOException{
		int zayavkaId = ParamUtil.getInteger(request,"zayavkaId");
		String strUrl = messageSource.getMessage("zayavka.reportUrl", new Object[]{zayavkaId}, Locale.getDefault());

		URL url = new URL(strUrl);
		URLConnection urlConnection = url.openConnection();
		InputStream is = urlConnection.getInputStream();
		
		response.setContentType("application/rtf");
		response.setContentLength(is.available());
		response.setProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=zayavka.rtf");
		
		OutputStream outStream = response.getPortletOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = is.read(buffer)) != -1) {
		    outStream.write(buffer, 0, len);
		}
		outStream.flush();
		outStream.close();
		is.close();
	}
}
