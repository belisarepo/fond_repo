package by.belisa.controller;

import java.text.ParseException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import by.belisa.bean.AnketaDTO;
import by.belisa.bean.OrgDTO;
import by.belisa.dao.OkoguDao;
import by.belisa.entity.Okogu;
import by.belisa.entity.Organization;
import by.belisa.entity.VidOrg;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;
import by.belisa.service.AnketaService;
import by.belisa.service.OkoguService;
import by.belisa.service.OrgService;
import by.belisa.service.UchStepeniService;
import by.belisa.service.VidOrgService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.OrganizationService;
import com.liferay.portal.util.PortalUtil;

@Controller(value = "organizationController")
@RequestMapping(value = "VIEW")
public class OrganizationController {
	private static Logger log = Logger.getLogger(OrganizationController.class);

	@Autowired
	@Qualifier("vidOrgService")
	private VidOrgService vidOrgService;
	@Autowired
	@Qualifier("orgService")
	private OrgService orgService;
	@Autowired
	@Qualifier("okoguService")
	private OkoguService okoguService;

	@RenderMapping
	public String renderView(Model model, PortletRequest request) throws ServiceException, DaoException {
		OrgDTO orgDTO = new OrgDTO();
		List<VidOrg> vidOrgList = vidOrgService.getAll();
		List<Okogu> okoguList = okoguService.getAll();
		model.addAttribute("okoguList", okoguList);
		model.addAttribute("vidOrgList", vidOrgList);
		model.addAttribute("organization", orgDTO);
		return "organiation";
	}

	@ActionMapping
	public void getFormData(@ModelAttribute OrgDTO orgDTO, ActionRequest aRequest, Model model) throws ServiceException, PortalException,
			SystemException, ParseException, DaoException {
		long pk = PortalUtil.getUser(aRequest).getPrimaryKey();
		System.out.println(orgDTO.getAddress() + "- Adress");
		System.out.println(orgDTO.getEmail() + "- Email");
		System.out.println(orgDTO.getName() + "- Name");
		System.out.println(orgDTO.getKod_old() + "- Kod old");
		System.out.println(orgDTO.getUnp() + "- Unp");
		System.out.println(orgDTO.getKod_booker() + "- Kod Booker ");
		System.out.println(orgDTO.getOkoguName() + "- Okogu name");
		System.out.println(orgDTO.getFull_name_rus() + "- name rus");
		System.out.println(orgDTO.getFull_name_eng() + "- name eng");
		System.out.println(orgDTO.getVidOrgId() + "- vid org");
		orgService.saveOrUpdate(orgDTO);
		model.addAttribute("save_result", "Сохранено");

	}

}
