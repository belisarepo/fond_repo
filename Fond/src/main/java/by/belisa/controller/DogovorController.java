package by.belisa.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller(value="dogovorController")
@RequestMapping(value = "VIEW")
public class DogovorController {
	private static Logger log = Logger.getLogger(DogovorController.class);
	
	@RenderMapping
	public String renderDogovorForm(){
		return "dogovor";
	}

}
