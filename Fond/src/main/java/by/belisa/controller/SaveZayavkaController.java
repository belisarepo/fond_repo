package by.belisa.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
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
import by.belisa.bean.OrgNrDTO;
import by.belisa.bean.PublicationDTO;
import by.belisa.bean.PublicationMDTO;
import by.belisa.bean.ZayavkaFIDTO;
import by.belisa.dao.StatusZayavkaFIDao;
import by.belisa.entity.Ispolnitel;
import by.belisa.entity.Okogu;
import by.belisa.entity.Oksm;
import by.belisa.entity.Organization;
import by.belisa.entity.OrganizationNR;
import by.belisa.entity.OtraslNauka;
import by.belisa.entity.PrioritetNauka;
import by.belisa.entity.PublicationType;
import by.belisa.entity.SectionFond;
import by.belisa.entity.UchStepeni;
import by.belisa.entity.UchZvaniy;
import by.belisa.entity.VidOrg;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;
import by.belisa.service.AnketaService;
import by.belisa.service.AnnotationService;
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
import by.belisa.service.ObosnovanieService;
import by.belisa.service.OkoguService;
import by.belisa.service.OksmService;
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
import by.belisa.service.VidOrgService;
import by.belisa.service.ZayavkaFIService;
import by.belisa.util.Utils;
import by.belisa.validation.ValidationResult;

import com.aspose.words.Document;
import com.aspose.words.ImportFormatMode;
import com.aspose.words.SaveFormat;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
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
	@Qualifier(value = "oksmService")
	protected OksmService oksmService;
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
	@Autowired
	@Qualifier("vidOrgService")
	private VidOrgService vidOrgService;
	@Autowired
	@Qualifier("okoguService")
	private OkoguService okoguService;
	@Autowired
	@Qualifier("annotationService")
	private AnnotationService annotationService;
	@Autowired
	@Qualifier("obosnovanieService")
	private ObosnovanieService obosnService;

	private List<OtraslNauka> otraslNaukaList = null;
	private List<SectionFond> sectionFondList = null;
	private List<PrioritetNauka> prioritetNaukaList = null;
	private List<UchStepeni> uchStepeniList = null;
	private List<UchZvaniy> uchZvaniyList = null;
	private List<PublicationType> publicationTypes = null;
	private List<Oksm> oksmList = null;

	@ModelAttribute(value = "oksmList")
	public List<Oksm> initOksmList() throws ServiceException {
		if (oksmList == null) {
			oksmList = oksmService.getAll();
		}
		return oksmList;
	}

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
	public PublicationDTO initPublicationModel() {
		return new PublicationDTO();
	}

	@ModelAttribute(value = "publicationMModel")
	public PublicationMDTO initPublicationMModel() {
		return new PublicationMDTO();
	}

	@ModelAttribute(value = "ispolnitelModel")
	public IspolnitelDTO initIspolnitelModel() {
		return new IspolnitelDTO();
	}

	@ModelAttribute(value = "calcZpModel")
	public CalcZpDTO initCalcZpModel() {
		return new CalcZpDTO();
	}

	@ModelAttribute(value = "calcMaterialsModel")
	public CalcMaterialsDTO initCalcMaterialsModel() {
		return new CalcMaterialsDTO();
	}

	@ModelAttribute(value = "calcTripModel")
	public CalcTripDTO initCalcTripModel() {
		return new CalcTripDTO();
	}

	@ModelAttribute(value = "calcOtherCostsModel")
	public CalcOtherCostsDTO initCalcOtherCostsModel() {
		return new CalcOtherCostsDTO();
	}

	@RenderMapping(params = "view=zayavka")
	public abstract String renderZayavkaForm(Model model, PortletRequest request) throws Exception;

	@ActionMapping(params = "action=send")
	public void sendZayavka(ActionRequest req, ActionResponse resp, Model model) throws DaoException, ParseException, NumberFormatException,
			ServiceException {
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");

		zayavkaFIService.changeStatus(3, zayavkaId);
		model.addAttribute("save_result", "Заявка подана");

		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}

	@ActionMapping(params = "action=validateZ")
	public void validateZayavka(ActionRequest req, ActionResponse resp, Model model) throws DaoException {
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		ValidationResult vr = null;

		if (zayavkaId != 0) {
			vr = zayavkaFIService.checkZayavkaFI(zayavkaId);

			if (vr.isOk()) {

				model.addAttribute("save_result", "Заявка заполнена корректно");
				model.addAttribute("validate_result", "ok");
			} else {
				model.addAttribute("errorMsg", Utils.createErrorMsg(vr));
			}
		} else {
			model.addAttribute("errorMsg", "Заявка не заполнена");
		}
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}

	// @ActionMapping
	// public void saveZayavka(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO,
	// ActionRequest req, ActionResponse resp, Model model) throws DaoException,
	// ParseException {
	// zayavkaFIService.saveOrUpdate(zayavkaFIDTO);
	// resp.setRenderParameter("view", "zayavka");
	// resp.setRenderParameter("konkursId",
	// String.valueOf(zayavkaFIDTO.getKonkursId()));
	// model.addAttribute("save_result", "Сохранено");
	// }

	@ActionMapping(params = "form=form1")
	public void saveForm1(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException,
			ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm1(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}

	@ActionMapping(params = "form=form2")
	public void saveForm2(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException,
			ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm2(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}

	@ActionMapping(params = "form=form3")
	public void saveForm3(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException,
			ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm3(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}

	@ActionMapping(params = "form=form4")
	public void saveForm4(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException,
			ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm4(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}

	@ActionMapping(params = "form=form5")
	public void saveForm5(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException,
			ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm5(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}

	@ActionMapping(params = "form=form8")
	public void saveForm8(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException,
			ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm8(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}

	@ActionMapping(params = "form=form9")
	public void saveForm9(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException,
			ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm9(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}

	@ActionMapping(params = "form=form10")
	public void saveForm10(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException,
			ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm10(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}

	@ActionMapping(params = "form=form11")
	public void saveForm11(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException,
			ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm11(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}

	@ActionMapping(params = "form=form12")
	public void saveForm12(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException,
			ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm12(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}

	@ActionMapping(params = "form=form13")
	public void saveForm13(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException,
			ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm13(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}

	@ActionMapping(params = "form=form15")
	public void saveForm15(@ModelAttribute ZayavkaFIDTO zayavkaFIDTO, ActionRequest req, ActionResponse resp, Model model) throws DaoException,
			ParseException {
		Integer zayavkaId = zayavkaFIService.saveForm15(zayavkaFIDTO);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", String.valueOf(zayavkaFIDTO.getKonkursId()));
		model.addAttribute("save_result", "Сохранено");
	}

	@ActionMapping(params = "action=addIspolnitel")
	public void addIspolnitel(@ModelAttribute IspolnitelDTO ispolnitelDTO, ActionRequest req, ActionResponse resp, Model model)
			throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException {

		Integer konkursId = ParamUtil.getInteger(req, "konkursId");
		Long userId = PortalUtil.getUser(req).getUserId();

		Integer fizInfoId = fizInfoService.addFizInfo(ispolnitelDTO);
		CheckUslResult checkUslResult = konkursyService.checkUsloviyaIspl(konkursId, fizInfoId);
		if (!checkUslResult.isAvailable()) {
			String errorMsg = Utils.createErrorMsg(ispolnitelDTO.getSurname(), checkUslResult);
			model.addAttribute("errorMsg", errorMsg);
		} else {
			ZayavkaFIDTO zayavkaFIDTO = zayavkaFIService.getZayavkaFIDTOByUserId(PortalUtil.getUser(req).getUserId(), konkursId);
			if (zayavkaFIDTO.getId() == null) {
				Integer zayavkaFIId = zayavkaFIService.saveOrUpdate(zayavkaFIDTO);
				zayavkaFIDTO.setId(zayavkaFIId);
			}
			ispolnitelDTO.setZayavkaFIId(zayavkaFIDTO.getId());
			ispolnitelDTO.setFizInfoId(fizInfoId);
			fizInfoService.addZayavkaFI(fizInfoId, zayavkaFIDTO.getId());
			ispolnitelService.saveOrUpdate(ispolnitelDTO);
			resp.setRenderParameter("zayavkaId", zayavkaFIDTO.getId().toString());
		}

		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}

	@ActionMapping(params = "action=addSoOrg")
	public void addSoOrg(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException,
			PortalException, SystemException {

		Integer konkursId = ParamUtil.getInteger(req, "konkursId");
		Integer soOrgId = ParamUtil.getInteger(req, "soOrgId");
		;
		ZayavkaFIDTO zayavkaFIDTO = zayavkaFIService.getZayavkaFIDTOByUserId(PortalUtil.getUser(req).getUserId(), konkursId);
		if (zayavkaFIDTO.getId() == null) {
			Integer zayavkaFIId = zayavkaFIService.saveOrUpdate(zayavkaFIDTO);
			zayavkaFIDTO.setId(zayavkaFIId);
		}
		orgService.addSoOrg(soOrgId, zayavkaFIDTO.getId());
		resp.setRenderParameter("zayavkaId", zayavkaFIDTO.getId().toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", konkursId.toString());
	}

	@ActionMapping(params = "action=addPetition")
	public void addPetition(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException,
			PortalException, SystemException {

		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		Integer konkursId = ParamUtil.getInteger(req, "konkursId");
		Long userId = PortalUtil.getUser(req).getUserId();
		String petitionName = ParamUtil.getString(req, "petitionName");

		ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO();
		zayavkaFIDTO.setId(zayavkaId);
		zayavkaFIDTO.setKonkursId(konkursId);
		zayavkaFIDTO.setUserId(userId);
		zayavkaId = zayavkaFIService.addPetition(zayavkaFIDTO, petitionName);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", konkursId.toString());
	}

	@ActionMapping(params = "action=addPublication")
	public void addPublication(@ModelAttribute(value = "publicationModel") PublicationDTO publication, ActionRequest req, ActionResponse resp)
			throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException {
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		Integer konkursId = ParamUtil.getInteger(req, "konkursId");
		Long userId = PortalUtil.getUser(req).getUserId();
		ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO();
		zayavkaFIDTO.setId(zayavkaId);
		zayavkaFIDTO.setKonkursId(konkursId);
		zayavkaFIDTO.setUserId(userId);
		zayavkaId = zayavkaFIService.addPublication(zayavkaFIDTO, publication);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", konkursId.toString());
	}

	@ActionMapping(params = "action=addPublicationM")
	public void addPublicationM(@ModelAttribute(value = "publicationMModel") PublicationMDTO publication, ActionRequest req, ActionResponse resp)
			throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException {
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		Integer konkursId = ParamUtil.getInteger(req, "konkursId");
		Integer fizInfoId = ParamUtil.getInteger(req, "fizInfoId");
		publication.setFizInfoId(fizInfoId);
		Long userId = PortalUtil.getUser(req).getUserId();
		ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO();
		zayavkaFIDTO.setId(zayavkaId);
		zayavkaFIDTO.setKonkursId(konkursId);
		zayavkaFIDTO.setUserId(userId);
		zayavkaId = zayavkaFIService.addPublicationM(zayavkaFIDTO, publication);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", konkursId.toString());
	}

	@ActionMapping(params = "action=addCalcZp")
	public void addCalcZp(@ModelAttribute(value = "calcZpModel") CalcZpDTO calcZp, ActionRequest req, ActionResponse resp) throws ParseException,
			DaoException, NumberFormatException, ServiceException, PortalException, SystemException {
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		Integer konkursId = ParamUtil.getInteger(req, "konkursId");
		Long userId = PortalUtil.getUser(req).getUserId();
		ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO();
		zayavkaFIDTO.setId(zayavkaId);
		zayavkaFIDTO.setKonkursId(konkursId);
		zayavkaFIDTO.setUserId(userId);
		zayavkaId = zayavkaFIService.addCalcZp(zayavkaFIDTO, calcZp);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", konkursId.toString());
	}

	@ActionMapping(params = "action=addCalcMaterials")
	public void addCalcMaterials(@ModelAttribute(value = "calcMaterialsModel") CalcMaterialsDTO calcMaterials, ActionRequest req, ActionResponse resp)
			throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException {
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		Integer konkursId = ParamUtil.getInteger(req, "konkursId");
		Long userId = PortalUtil.getUser(req).getUserId();
		ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO();
		zayavkaFIDTO.setId(zayavkaId);
		zayavkaFIDTO.setKonkursId(konkursId);
		zayavkaFIDTO.setUserId(userId);
		zayavkaId = zayavkaFIService.addCalcMaterials(zayavkaFIDTO, calcMaterials);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("konkursId", konkursId.toString());
	}

	@ActionMapping(params = "action=addCalcTrip")
	public void addCalcTrip(@ModelAttribute(value = "calcTripModel") CalcTripDTO calcTrip, ActionRequest req, ActionResponse resp)
			throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException {
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		Integer konkursId = ParamUtil.getInteger(req, "konkursId");
		Long userId = PortalUtil.getUser(req).getUserId();
		ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO();
		zayavkaFIDTO.setId(zayavkaId);
		zayavkaFIDTO.setKonkursId(konkursId);
		zayavkaFIDTO.setUserId(userId);
		zayavkaId = zayavkaFIService.addCalcTrip(zayavkaFIDTO, calcTrip);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", konkursId.toString());
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
	}

	@ActionMapping(params = "action=addCalcOtherCosts")
	public void addCalcOtherCosts(@ModelAttribute(value = "calcOtherCostsModel") CalcOtherCostsDTO calcOtherCosts, ActionRequest req,
			ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException, PortalException, SystemException {
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		Integer konkursId = ParamUtil.getInteger(req, "konkursId");
		Long userId = PortalUtil.getUser(req).getUserId();
		ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO();
		zayavkaFIDTO.setId(zayavkaId);
		zayavkaFIDTO.setKonkursId(konkursId);
		zayavkaFIDTO.setUserId(userId);
		zayavkaId = zayavkaFIService.addCalcOtherCosts(zayavkaFIDTO, calcOtherCosts);
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("konkursId", konkursId.toString());
	}

	@ActionMapping(params = "action=deleteIspolnitel")
	public void deleteIspolnitel(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException,
			ServiceException, PortalException, SystemException {

		Integer ispolnitelId = ParamUtil.getInteger(req, "ispolnitelId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		Ispolnitel ispolnitel = ispolnitelService.get(ispolnitelId);
		if (ispolnitel != null) {
			fizInfoService.removeZayavkaFI(zayavkaId, ispolnitel);
			ispolnitelService.delete(ispolnitel);
		}
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));

	}

	@ActionMapping(params = "action=deletePetition")
	public void deletePetition(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException,
			PortalException, SystemException {
		Integer petitionId = ParamUtil.getInteger(req, "petitionId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		petitionService.delete(petitionService.get(petitionId));
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}

	@ActionMapping(params = "action=deletePublication")
	public void deletePublication(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException,
			ServiceException, PortalException, SystemException {
		Integer publicationId = ParamUtil.getInteger(req, "publicationId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		publicationService.delete(publicationService.get(publicationId));
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}

	@ActionMapping(params = "action=deletePublicationM")
	public void deletePublicationM(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException,
			ServiceException, PortalException, SystemException {
		Integer publicationId = ParamUtil.getInteger(req, "publicationId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		publicationMService.delete(publicationMService.get(publicationId));
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}

	@ActionMapping(params = "action=deleteCalcZp")
	public void deleteCalcZp(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException,
			PortalException, SystemException {
		Integer calcZpId = ParamUtil.getInteger(req, "calcZpId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		calcZpService.delete(calcZpService.get(calcZpId));
		calcZpSumService.recalculate(zayavkaId);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}

	@ActionMapping(params = "action=deleteCalcTrip")
	public void deleteCalcTrip(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException,
			PortalException, SystemException {
		Integer calcTripId = ParamUtil.getInteger(req, "calcTripId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		calcTripService.delete(calcTripService.get(calcTripId));
		calcTripSumService.recalculate(zayavkaId);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}

	@ActionMapping(params = "action=deleteCalcOtherCosts")
	public void deleteCalcOtherCosts(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException,
			ServiceException, PortalException, SystemException {
		Integer calcOtherCostsId = ParamUtil.getInteger(req, "calcOtherCostsId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		calcOtherCostsService.delete(calcOtherCostsService.get(calcOtherCostsId));
		calcOtherCostsSumService.recalculate(zayavkaId);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}

	@ActionMapping(params = "action=deleteCalcMaterials")
	public void deleteCalcMaterials(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException,
			ServiceException, PortalException, SystemException {
		Integer calcMaterialsId = ParamUtil.getInteger(req, "calcMaterialsId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		calcMaterialsService.delete(calcMaterialsService.get(calcMaterialsId));
		calcMaterialsSumService.recalculate(zayavkaId);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}

	@ActionMapping(params = "action=deleteSoOrg")
	public void deleteSoOrg(ActionRequest req, ActionResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException,
			PortalException, SystemException {

		Integer soOrgId = ParamUtil.getInteger(req, "soOrgId");
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		orgService.deleteSoOrg(soOrgId, zayavkaId);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", ParamUtil.getString(req, "konkursId"));
	}

	@RenderMapping(params = "action=addOrg")
	public String renderAddOrgForm(Model model, PortletRequest request) throws ServiceException, DaoException {
		OrgDTO orgModel = new OrgDTO();
		List<VidOrg> vidOrgList = vidOrgService.getAll();
		List<Okogu> okoguList = okoguService.getAll();
		model.addAttribute("okoguList", okoguList);
		model.addAttribute("vidOrgList", vidOrgList);
		model.addAttribute("orgModel", orgModel);
		return "addOrgForm";
	}

	@RenderMapping(params = "action=addOrgNr")
	public String renderAddOrgNrForm(Model model, PortletRequest request) throws ServiceException, DaoException {
		Integer konkursId = ParamUtil.getInteger(request, "konkursId");
		Integer countryId = konkursyService.get(konkursId).getCountryId();

		Oksm oksm = null;
		if (countryId != null) {
			oksm = oksmService.get(countryId);
		}

		OrgNrDTO orgNrModel = new OrgNrDTO();
		if (oksm != null) {
			orgNrModel.setOksmId(oksm.getId());
			orgNrModel.setOksmName(oksm.getNameR());
		}

		// List<VidOrg> vidOrgList = vidOrgService.getAll();
		// model.addAttribute("vidOrgList", vidOrgList);
		model.addAttribute("orgNrModel", orgNrModel);
		return "addOrgNrForm";
	}

	@RenderMapping(params = "action=editPublication")
	public String renderEditPublicationForm(Model model, PortletRequest request) throws ServiceException, DaoException {
		Integer id = ParamUtil.getInteger(request, "publId");
		PublicationDTO publ = publicationService.getDTO(id);
		model.addAttribute("publModel", publ);
		return "editPublicationForm";
	}

	@RenderMapping(params = "action=editPublicationM")
	public String renderEditPublicationMForm(Model model, PortletRequest request) throws ServiceException, DaoException {
		Integer id = ParamUtil.getInteger(request, "publMId");
		PublicationMDTO publM = publicationMService.getDTO(id);
		model.addAttribute("publMModel", publM);
		return "editPublicationMForm";
	}

	@RenderMapping(params = "action=editIspolnitel")
	public String renderEditIspolnitelForm(Model model, PortletRequest request) throws ServiceException, DaoException {
		Integer id = ParamUtil.getInteger(request, "isplId");
		IspolnitelDTO ispl = ispolnitelService.getDTO(id);
		model.addAttribute("isplModel", ispl);
		List<Organization> listOrg = orgService.getAll();
		model.addAttribute("listOrg", listOrg);
		return "editIspolnitelForm";
	}

	@RenderMapping(params = "action=editCalcZP")
	public String renderEditCalcZPForm(Model model, PortletRequest request) throws ServiceException, DaoException {
		Integer id = ParamUtil.getInteger(request, "CalcZPId");
		Integer zayavkaId = ParamUtil.getInteger(request, "zayavkaId");
		CalcZpDTO calcZp = calcZpService.getDTO(id);
		model.addAttribute("calcZpModel", calcZp);
		model.addAttribute("zayavkaId", zayavkaId);
		return "editCalcZPForm";
	}

	@RenderMapping(params = "action=editCalcMaterials")
	public String renderEditCalcMaterialsForm(Model model, PortletRequest request) throws ServiceException, DaoException {
		Integer id = ParamUtil.getInteger(request, "CalcMaterialsId");
		Integer zayavkaId = ParamUtil.getInteger(request, "zayavkaId");
		CalcMaterialsDTO calcMaterials = calcMaterialsService.getDTO(id);
		model.addAttribute("calcMaterialsModel", calcMaterials);
		model.addAttribute("zayavkaId", zayavkaId);
		return "editCalcMaterialsForm";
	}

	@RenderMapping(params = "action=editCalcOtherCosts")
	public String renderEditCalcOtherCostsForm(Model model, PortletRequest request) throws ServiceException, DaoException {
		Integer id = ParamUtil.getInteger(request, "calcOtherCostsId");
		Integer zayavkaId = ParamUtil.getInteger(request, "zayavkaId");
		CalcOtherCostsDTO calcOtherCosts = calcOtherCostsService.getDTO(id);
		model.addAttribute("calcOtherCostsModel", calcOtherCosts);
		model.addAttribute("zayavkaId", zayavkaId);
		return "editCalcOtherCostsForm";
	}

	@RenderMapping(params = "action=editCalcTrip")
	public String renderEditCalcTripForm(Model model, PortletRequest request) throws ServiceException, DaoException {
		Integer id = ParamUtil.getInteger(request, "calcTripId");
		Integer zayavkaId = ParamUtil.getInteger(request, "zayavkaId");
		CalcTripDTO calcTrip = calcTripService.getDTO(id);
		model.addAttribute("calcTripModel", calcTrip);
		model.addAttribute("zayavkaId", zayavkaId);
		return "editCalcTripForm";

	}

	@RenderMapping(params = "action=popup")
	public String renderPopup(Model model, PortletRequest request) {
		String inputId = ParamUtil.getString(request, "input_id");
		model.addAttribute("input_id", inputId);
		return "popup";
	}

	@ActionMapping(params = "action=uploadAnnotation")
	public void uploadAnnotation(ActionRequest req, ActionResponse resp, Model model) throws IOException, PortalException, SystemException,
			DaoException {
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		Integer konkursId = ParamUtil.getInteger(req, "konkursId");
		Long userId = PortalUtil.getUser(req).getUserId();

		UploadPortletRequest upr = PortalUtil.getUploadPortletRequest(req);
		File f = upr.getFile("fileAnnotation");
		String fileName = upr.getFullFileName("fileAnnotation");
		if (!fileName.endsWith(".rtf")) {
			model.addAttribute("errorMsg", "<p>Документ должен быть в формате rtf</p>");
		} else {
			FileInputStream fis = new FileInputStream(f);
			int size = fis.available();
			byte annotation[] = new byte[size];
			fis.read(annotation);
			fis.close();

			ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO();
			zayavkaFIDTO.setId(zayavkaId);
			zayavkaFIDTO.setKonkursId(konkursId);
			zayavkaFIDTO.setUserId(userId);
			zayavkaId = zayavkaFIService.addAnnotationFile(zayavkaFIDTO, annotation, fileName);
		}

		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", konkursId.toString());

	}

	@ResourceMapping(value = "getAnnotationFile")
	public void getAnnotationFile(ResourceRequest request, ResourceResponse response) {

		Integer zayavkaId = ParamUtil.getInteger(request, "zayavkaId");
		String fileName = ParamUtil.getString(request, "fileName");
		byte[] annotation = annotationService.getFile(zayavkaId);
		response.setContentType("application/msword");
		response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
		response.setContentLength(annotation.length);
		response.setProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
		OutputStream outStream = null;
		try {
			outStream = response.getPortletOutputStream();
			outStream.write(annotation);
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

	@ActionMapping(params = "action=deleteAnnotationFile")
	public void deleteAnnotationFile(ActionRequest req, ActionResponse resp) {
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		annotationService.deleteFile(zayavkaId);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
	}

	@ActionMapping(params = "action=uploadObosn")
	public void uploadObosn(ActionRequest req, ActionResponse resp, Model model) throws IOException, PortalException, SystemException, DaoException {
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		Integer konkursId = ParamUtil.getInteger(req, "konkursId");

		UploadPortletRequest upr = PortalUtil.getUploadPortletRequest(req);
		File f = upr.getFile("fileObosn");
		String fileName = upr.getFullFileName("fileObosn");
		if (!fileName.endsWith(".rtf")) {
			model.addAttribute("errorMsg", "<p>Документ должен быть в формате rtf</p>");
		} else {
			FileInputStream fis = new FileInputStream(f);
			int size = fis.available();
			byte obosn[] = new byte[size];
			fis.read(obosn);
			fis.close();

			Long userId = PortalUtil.getUser(req).getUserId();

			ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO();
			zayavkaFIDTO.setId(zayavkaId);
			zayavkaFIDTO.setKonkursId(konkursId);
			zayavkaFIDTO.setUserId(userId);
			zayavkaId = zayavkaFIService.addObosnFile(zayavkaFIDTO, obosn, fileName);
		}

		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
		resp.setRenderParameter("konkursId", konkursId.toString());

	}

	@ResourceMapping(value = "getObosnFile")
	public void getObosnFile(ResourceRequest request, ResourceResponse response) {

		Integer zayavkaId = ParamUtil.getInteger(request, "zayavkaId");
		String fileName = ParamUtil.getString(request, "fileName");
		byte[] obosn = obosnService.getFile(zayavkaId);
		response.setContentType("application/msword");
		response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
		response.setContentLength(obosn.length);
		response.setProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
		OutputStream outStream = null;
		try {
			outStream = response.getPortletOutputStream();
			outStream.write(obosn);
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

	@ActionMapping(params = "action=deleteObosnFile")
	public void deleteObosnFile(ActionRequest req, ActionResponse resp) {
		Integer zayavkaId = ParamUtil.getInteger(req, "zayavkaId");
		obosnService.deleteFile(zayavkaId);
		resp.setRenderParameter("zayavkaId", zayavkaId.toString());
		resp.setRenderParameter("view", "zayavka");
	}

	@ResourceMapping(value = "getOrgById")
	public void getOrgByid(ResourceRequest request, ResourceResponse response) throws NumberFormatException, DaoException {

		String orgId = request.getParameter("orgId");
		OrgDTO orgDTO = orgService.getOrgDTOById(Integer.parseInt(orgId));
		OutputStream outStream = null;
		try {
			outStream = response.getPortletOutputStream();
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(orgDTO);
			outStream.write(jsonString.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (outStream != null) {
				try {
					outStream.flush();
					outStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	@ResourceMapping(value = "getOrgNrById")
	public void getOrgNrByid(ResourceRequest request, ResourceResponse response) throws NumberFormatException, DaoException, ServiceException {

		String orgId = request.getParameter("orgId");
		OrganizationNR orgNr = orgNrService.get(Integer.parseInt(orgId));
		OutputStream outStream = null;
		try {
			outStream = response.getPortletOutputStream();
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(orgNr);
			outStream.write(jsonString.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (outStream != null) {
				try {
					outStream.flush();
					outStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	@ResourceMapping(value = "addOrg")
	public void addOrg(ResourceRequest req, ResourceResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException,
			PortalException, SystemException {
		String name = req.getParameter("name");
		String full_name_rus = req.getParameter("full_name_rus");
		String full_name_eng = req.getParameter("full_name_eng");
		String unp = req.getParameter("unp");
		/* String vidOrgId = req.getParameter("vidOrgId"); */
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		/* String kod_booker = req.getParameter("kod_booker"); */
		String okoguId = req.getParameter("okoguId");
		Organization o = new Organization();
		o.setName(name);
		o.setFullNameR(full_name_rus);
		o.setFullNameE(full_name_eng);
		o.setUnp(unp);
		/*
		 * if(!vidOrgId.isEmpty())
		 * o.setVidOrg(vidOrgService.get(Integer.parseInt(vidOrgId)));
		 */
		o.setAddress(address);
		o.setEmail(email);
		/* o.setCodeBooker(kod_booker); */
		if (!okoguId.isEmpty())
			o.setOkogu(okoguService.get(Integer.parseInt(okoguId)));
		Organization newOrg = orgService.add(o);
		OrgDTO dto = orgService.getOrgDTOById(newOrg.getId());
		OutputStream outStream = null;
		try {
			outStream = resp.getPortletOutputStream();
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(dto);
			outStream.write(jsonString.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outStream != null) {
				try {
					outStream.flush();
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@ResourceMapping(value = "addOrgNr")
	public void addOrgNr(ResourceRequest req, ResourceResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException,
			PortalException, SystemException {
		/* String nameR = req.getParameter("nameR"); */
		String nameE = req.getParameter("nameE");
		String fullName = req.getParameter("fullName");
		/* String vidOrgId = req.getParameter("vidOrgId"); */
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String oksmId = req.getParameter("oksmId");
		OrganizationNR o = new OrganizationNR();
		/* o.setNameR(nameR); */
		o.setNameE(nameE);
		o.setFullName(fullName);
		/*
		 * if(!vidOrgId.isEmpty())
		 * o.setVidOrg(vidOrgService.get(Integer.parseInt(vidOrgId)));
		 */
		o.setAddress(address);
		o.setEmail(email);
		if (!oksmId.isEmpty())
			o.setOksm(oksmService.get(Integer.parseInt(oksmId)));
		OrganizationNR newOrg = orgNrService.add(o);
		OrgNrDTO dto = orgNrService.getOrgNrDTOById(newOrg.getId());
		OutputStream outStream = null;
		try {
			outStream = resp.getPortletOutputStream();
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(dto);
			outStream.write(jsonString.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outStream != null) {
				try {
					outStream.flush();
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@ResourceMapping(value = "editPublication")
	public void editPublication(ResourceRequest req, ResourceResponse resp) throws ParseException, DaoException, NumberFormatException,
			ServiceException, PortalException, SystemException, IOException {
		String publId = req.getParameter("id");
		String name = req.getParameter("name");
		String edition = req.getParameter("edition");
		String authors = req.getParameter("authors");
		String citationIndex = req.getParameter("citationIndex");
		String database = req.getParameter("database");
		PublicationDTO dto = new PublicationDTO(Integer.parseInt(publId), name, edition, authors, citationIndex, database);
		publicationService.edit(dto);
	}

	@ResourceMapping(value = "editPublicationM")
	public void editPublicationM(ResourceRequest req, ResourceResponse resp) throws ParseException, DaoException, NumberFormatException,
			ServiceException, PortalException, SystemException, IOException {
		String publMId = req.getParameter("id");
		String name = req.getParameter("name");
		String edition = req.getParameter("edition");
		String authors = req.getParameter("authors");
		String pages = req.getParameter("pages");
		PublicationMDTO dto = new PublicationMDTO(Integer.parseInt(publMId), name, edition, Integer.parseInt(pages), authors);
		publicationMService.edit(dto);
	}

	@ResourceMapping(value = "editCalcZP")
	public void editCalcZP(ResourceRequest req, ResourceResponse resp) throws ParseException, DaoException, NumberFormatException, ServiceException,
			PortalException, SystemException, IOException {
		String calcZPId = req.getParameter("id");
		String name = req.getParameter("name");
		String salary = req.getParameter("salary");
		String rate = req.getParameter("rate");
		String duration = req.getParameter("duration");
		String fondZp = req.getParameter("fondZp");
		String note = req.getParameter("note");
		String zayavkaId = req.getParameter("zayavkaId");
		CalcZpDTO dto = new CalcZpDTO(Integer.parseInt(calcZPId), name, Float.parseFloat(salary), Float.parseFloat(rate), Float.parseFloat(duration),
				Float.parseFloat(fondZp), note);
		calcZpService.edit(dto);
		calcZpSumService.recalculate(Integer.parseInt(zayavkaId));
	}

	@ResourceMapping(value = "editCalcOtherCosts")
	public void editCalcOtherCosts(ResourceRequest req, ResourceResponse resp) throws ParseException, DaoException, NumberFormatException,
			ServiceException, PortalException, SystemException, IOException {
		String calcOtherCostsId = req.getParameter("id");
		String name = req.getParameter("name");
		String sum = req.getParameter("sum");
		String note = req.getParameter("note");
		String zayavkaId = req.getParameter("zayavkaId");
		CalcOtherCostsDTO dto = new CalcOtherCostsDTO(Integer.parseInt(calcOtherCostsId), name, Float.parseFloat(sum), note);
		calcOtherCostsService.edit(dto);
		calcOtherCostsSumService.recalculate(Integer.parseInt(zayavkaId));
	}

	@ResourceMapping(value = "editCalcTrip")
	public void editCalcTrip(ResourceRequest req, ResourceResponse resp) throws ParseException, DaoException, NumberFormatException,
			ServiceException, PortalException, SystemException, IOException {
		String calcTripId = req.getParameter("id");
		String tripGoal = req.getParameter("tripGoal");
		String tripPoint = req.getParameter("tripPoint");
		String count = req.getParameter("count");
		String duration = req.getParameter("duration");
		String costs = req.getParameter("costs");
		String zayavkaId = req.getParameter("zayavkaId");
		CalcTripDTO dto = new CalcTripDTO(Integer.parseInt(calcTripId), tripGoal, tripPoint, Float.parseFloat(count), Float.parseFloat(duration),
				Float.parseFloat(costs));
		calcTripService.edit(dto);
		calcTripSumService.recalculate(Integer.parseInt(zayavkaId));
	}

	@ResourceMapping(value = "editIspolnitel")
	public void editIspolnitel(ResourceRequest req, ResourceResponse resp) throws ParseException, DaoException, NumberFormatException,
			ServiceException, PortalException, SystemException, IOException {
		String isplId = req.getParameter("id");
		// String surname = req.getParameter("surname");
		// String name = req.getParameter("name");
		// String patronymic = req.getParameter("patronymic");
		// String birthday = req.getParameter("birthday");
		String post = req.getParameter("post");
		String[] uchStepeniIdArrStr = req.getParameterValues("uchStepeniIdArr[]");
		uchStepeniIdArrStr = uchStepeniIdArrStr == null ? new String[] {} : uchStepeniIdArrStr;
		Integer[] uchStepeniIdArrInt = new Integer[uchStepeniIdArrStr.length];
		int n = 0;
		for (String s : uchStepeniIdArrStr) {
			uchStepeniIdArrInt[n] = Integer.parseInt(s);
			n++;
		}
		String[] uchZvaniyIdArrStr = req.getParameterValues("uchZvaniyIdArr[]");
		uchZvaniyIdArrStr = uchZvaniyIdArrStr == null ? new String[] {} : uchZvaniyIdArrStr;
		Integer[] uchZvaniyIdArrInt = new Integer[uchZvaniyIdArrStr.length];
		n = 0;
		for (String s : uchZvaniyIdArrStr) {
			uchZvaniyIdArrInt[n] = Integer.parseInt(s);
			n++;
		}
		String orgId = req.getParameter("orgId");
		Integer orgIdInt = orgId.isEmpty() ? null : Integer.parseInt(orgId);

		IspolnitelDTO dto = new IspolnitelDTO(Integer.parseInt(isplId), post, uchStepeniIdArrInt, uchZvaniyIdArrInt, orgIdInt);
		ispolnitelService.edit(dto);
	}

	@ResourceMapping(value = "editCalcMaterials")
	public void editCalcMaterials(ResourceRequest req, ResourceResponse resp) throws ParseException, DaoException, NumberFormatException,
			ServiceException, PortalException, SystemException, IOException {
		String CalcMaterialsId = req.getParameter("id");
		String name = req.getParameter("name");
		String unit = req.getParameter("unit");
		String count = req.getParameter("count");
		String sum = req.getParameter("sum");
		String zayavkaId = req.getParameter("zayavkaId");
		CalcMaterialsDTO dto = new CalcMaterialsDTO(Integer.parseInt(CalcMaterialsId), name, unit, Float.parseFloat(count), Float.parseFloat(sum));
		calcMaterialsService.edit(dto);
		calcMaterialsSumService.recalculate(Integer.parseInt(zayavkaId));
	}

	@ResourceMapping(value = "report")
	public void getReport(ResourceRequest request, ResourceResponse response) throws DaoException {
		int zayavkaId = ParamUtil.getInteger(request, "zayavkaId");

		URL url = null;
		OutputStream outStream = null;
		InputStream is = null;

		try {
			byte[] annotation = annotationService.getFile(zayavkaId);
			int annotationSize = annotation != null ? annotation.length : 0;
			byte[] obosn = obosnService.getFile(zayavkaId);
			int obosnSize = obosn != null ? obosn.length : 0;
			boolean loadedFile = obosnSize != 0 || annotationSize != 0;
			String msgKey;
			if (loadedFile) {
				if (annotationSize == 0) {
					msgKey = "zayavka.reportAnnotationUrl";
				} else if (obosnSize == 0) {
					msgKey = "zayavka.reportObosnUrl";
				} else {
					msgKey = "zayavka.reportEmptyUrl";
				}
			} else {
				msgKey = "zayavka.reportFullUrl";
			}
			String strUrl = messageSource.getMessage(msgKey, new Object[] { zayavkaId }, Locale.getDefault());
			System.out.println("!!!!!!" + zayavkaId);
			url = new URL(strUrl);
			URLConnection urlConnection = url.openConnection();
			is = urlConnection.getInputStream();

			response.setContentType("application/rtf");
			response.setProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=zayavka.rtf");

			outStream = response.getPortletOutputStream();

			if (!loadedFile) {
				byte[] buffer = new byte[1024];
				int lenght;
				while ((lenght = is.read(buffer)) != -1) {
					outStream.write(buffer, 0, lenght);
				}
			} else {
				Document publDoc = new Document(is);
				if (annotationSize != 0) {
					Document annotationDoc = new Document(new ByteArrayInputStream(annotation));
					publDoc.appendDocument(annotationDoc, ImportFormatMode.KEEP_SOURCE_FORMATTING);
				}
				if (obosnSize != 0) {
					Document obosnDoc = new Document(new ByteArrayInputStream(obosn));
					publDoc.appendDocument(obosnDoc, ImportFormatMode.KEEP_SOURCE_FORMATTING);
				}
				publDoc.save(outStream, SaveFormat.RTF);
			}

			/*
			 * Utils.writePublisherReport(is, outStream, loadedFile); if
			 * (annotationSize!=0){ Utils.writeLoadedFile(outStream, annotation,
			 * obosnSize!=0); } if (obosnSize!=0){
			 * Utils.writeLoadedFile(outStream, obosn, false); }
			 */

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outStream != null) {
				try {
					outStream.flush();
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
