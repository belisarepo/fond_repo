package by.belisa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import by.belisa.bean.DogovorDTO;
import by.belisa.entity.CalculationArticle;
import by.belisa.entity.CalculationD;
import by.belisa.entity.Organization;
import by.belisa.exception.ServiceException;
import by.belisa.service.CalculationArticleService;
import by.belisa.service.DogovorService;
import by.belisa.service.OrgService;

import com.liferay.portal.kernel.util.ParamUtil;

@Controller(value="dogovorController")
@RequestMapping(value = "VIEW")
public class DogovorController {
	private static Logger log = Logger.getLogger(DogovorController.class);
	@Autowired
	private DogovorService dogovorService;
	@Autowired
	@Qualifier(value = "orgService")
	private OrgService orgService;
	@Autowired
	@Qualifier(value="calculationArticleService")
	private CalculationArticleService calculationArticleService;
	
	@RenderMapping
	public String renderDogovorForm(RenderRequest req,Model model) throws ServiceException{
		Integer id = ParamUtil.getInteger(req, "dogId");
		id=466;
		DogovorDTO dogovorDTO = dogovorService.getDTO(id);
		
		List<Organization> orgList = orgService.getAll();
		model.addAttribute("orgList", orgList);
		if (dogovorDTO.getCalculationMap().isEmpty()){
			List<CalculationArticle> latestCalcArticle =calculationArticleService.getLatestArticles();
			for (CalculationArticle i : latestCalcArticle){
				dogovorDTO.getCalculationMap().put(i, new ArrayList<CalculationD>());
			}
		}
		model.addAttribute("dogovor", dogovorDTO);
		return "dogovor";
	}

}
