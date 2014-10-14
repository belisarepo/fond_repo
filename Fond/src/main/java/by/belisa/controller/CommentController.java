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
import by.belisa.bean.CommentDTO;
import by.belisa.bean.OrgDTO;
import by.belisa.dao.OkoguDao;
import by.belisa.entity.Okogu;
import by.belisa.entity.Organization;
import by.belisa.entity.VidOrg;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;
import by.belisa.service.AnketaService;
import by.belisa.service.CommentService;
import by.belisa.service.OkoguService;
import by.belisa.service.OrgService;
import by.belisa.service.UchStepeniService;
import by.belisa.service.VidOrgService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.OrganizationService;
import com.liferay.portal.util.PortalUtil;

@Controller(value = "commentController")
@RequestMapping(value = "VIEW")
public class CommentController {
	private static Logger log = Logger.getLogger(CommentController.class);

	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;
	@RenderMapping
	public String renderView(Model model, PortletRequest request) throws ServiceException, DaoException {
		CommentDTO commentDTO = new CommentDTO();
		model.addAttribute("comment", commentDTO);
		return "comment";
	}

	@ActionMapping
	public void getFormData(@ModelAttribute CommentDTO commentDTO, ActionRequest aRequest, Model model) throws ServiceException, PortalException,
			SystemException, ParseException, DaoException {
		long pk = PortalUtil.getUser(aRequest).getPrimaryKey();
		commentDTO.setUser_id(pk);
		commentService.saveOrUpdate(commentDTO);
		model.addAttribute("save_result", "Сохранено");

	}

}
