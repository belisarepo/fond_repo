package by.belisa.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import by.belisa.bean.RequestBean;

@Controller(value="requestController")
@RequestMapping(value="VIEW")
public class RequestController {
	private static Logger log = Logger.getLogger(RequestController.class);
	@RenderMapping
	public String renderForm(Model model){
		model.addAttribute("requestBean", new RequestBean());
		return "requestForm";
	}
	@RenderMapping(params="action=popup")
	public String renderPopup(Model model){
		
		return "popup";
	}
	@ActionMapping
	public void getFormData(@ModelAttribute("requestBean")RequestBean requestBean){
		System.out.println(requestBean.getText());
	}

}
