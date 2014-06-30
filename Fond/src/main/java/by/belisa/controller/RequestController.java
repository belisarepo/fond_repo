package by.belisa.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import by.belisa.bean.RequestBean;


@Controller(value="requestController")
@RequestMapping(value="VIEW")
public class RequestController {
	private static Logger log = Logger.getLogger(RequestController.class);
	@RenderMapping
	public String renderForm(Model model){
		Map<Integer,String> testMap = new HashMap<Integer,String>();
		testMap.put(1, "one");testMap.put(2, "two");testMap.put(3, "three");
		model.addAttribute("testMap", testMap);
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
	
	@ResourceMapping(value="ajax")
	public void ajax(ResourceRequest request, ResourceResponse response){
		String fioManager = request.getParameter("fioManager");
		System.out.println(fioManager);
		
	}

}
