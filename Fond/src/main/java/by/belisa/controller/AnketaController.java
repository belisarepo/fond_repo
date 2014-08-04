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

import by.belisa.bean.AnketaVO;
import by.belisa.entity.Anketa;
import by.belisa.entity.Organization;
import by.belisa.entity.UchStepeni;
import by.belisa.entity.UchZvaniy;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;
import by.belisa.service.AnketaService;
import by.belisa.service.OrgService;
import by.belisa.service.UchStepeniService;
import by.belisa.service.UchZvaniyService;
import by.belisa.service.UserService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.util.PortalUtil;

@Controller(value="anketaController")
@RequestMapping(value="VIEW")
//@SessionAttributes("anketa")
public class AnketaController {
	private static Logger log = Logger.getLogger(AnketaController.class);
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	@Autowired
	@Qualifier("anketaService")
	private AnketaService anketaService;
	@Autowired
	@Qualifier("uchStepeniService")
	private UchStepeniService uchStepeniService;
	@Autowired
	@Qualifier("uchZvaniyService")
	private UchZvaniyService uchZvaniyService;
	@Autowired
	@Qualifier("orgService")
	private OrgService orgService;
	
	
//	@ModelAttribute("my_anketa")
//	public Anketa prepareFormModel(PortletRequest request){
//		System.out.println("model attribute");
//		Anketa anketa = new Anketa();
//		try {
//			com.liferay.portal.model.User user = PortalUtil.getUser(request);
//			if (user!=null){
//				long pk = user.getPrimaryKey();
//				by.belisa.entity.Anketa ank =  anketaService.get(pk);
//				if (ank!=null){
//					
//					anketa.setSurname(ank.getSurname());
//					anketa.setName(ank.getName());
//					anketa.setPatronymic(ank.getPatronymic());
//					anketa.setAge(ank.getAge());
//				}
//				
//			}
//			
//		} catch (PortalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return anketa;
//	}
	
	@RenderMapping
	public String renderView(Model model, PortletRequest request) throws ServiceException, DaoException {
		AnketaVO anketaVO = null;
		try {
			com.liferay.portal.model.User user = PortalUtil.getUser(request);
			if (user!=null){
				long pk = user.getPrimaryKey();
				anketaVO =  anketaService.getVO(pk);
				if(anketaVO.getId()==0){
					anketaVO.setEmail(user.getEmailAddress());
					anketaVO.setFullFio(user.getLastName()+" "+user.getFirstName()+" "+user.getMiddleName());
					anketaVO.setFio(user.getLastName()+" "+user.getFirstName().charAt(0)+"."+user.getMiddleName().charAt(0)+".");
				}
				
			}else{
				anketaVO = new AnketaVO(); 
			}
			
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<UchStepeni> uchStepeniList = uchStepeniService.getAll();
		List<UchZvaniy> uchZvaniyList = uchZvaniyService.getAll();
		List<Organization> orgList = orgService.getAll();
		model.addAttribute("uchStepeniList", uchStepeniList);
		model.addAttribute("uchZvaniyList", uchZvaniyList);
		model.addAttribute("orgList", orgList);
		model.addAttribute("anketa", anketaVO);
		return "anketa";
	}
	@ActionMapping
	public void getFormData(@ModelAttribute AnketaVO anketaVO, ActionRequest aRequest, Model model) throws ServiceException, PortalException, SystemException, ParseException, DaoException{
		long pk = PortalUtil.getUser(aRequest).getPrimaryKey();	
		anketaVO.setId(pk);
		anketaService.saveOrUpdate(anketaVO);
		model.addAttribute("save_result","ok");
	}
	
}
