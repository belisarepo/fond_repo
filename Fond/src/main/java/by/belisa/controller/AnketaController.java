package by.belisa.controller;



import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.util.PortalUtil;

import by.belisa.bean.Anketa;
import by.belisa.dao.TestDao;
import by.belisa.entity.User;
import by.belisa.exception.ServiceException;
import by.belisa.service.AnketaService;
import by.belisa.service.IService;
import by.belisa.service.ServiceImpl;
import by.belisa.service.TestService;
import by.belisa.service.UserService;

@Controller(value="anketaController")
@RequestMapping(value="VIEW")
//@SessionAttributes("anketa")
public class AnketaController {
	private static Logger log = Logger.getLogger(AnketaController.class);
	
	@Autowired
	@Qualifier("userService")
	private IService<User,Long> userService;
	@Autowired
	@Qualifier("anketaService")
	private IService<by.belisa.entity.Anketa,Long> anketaService;
	
	
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
	public String renderView(Model model, PortletRequest request) {
		Anketa anketa = new Anketa();
		try {
			com.liferay.portal.model.User user = PortalUtil.getUser(request);
			if (user!=null){
				long pk = user.getPrimaryKey();
				by.belisa.entity.Anketa ank =  anketaService.get(pk);
				if (ank!=null){
					anketa.setFio(ank.getFio());
				}
				
			}
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("anketa", anketa);
		return "anketa";
	}
	@ActionMapping
	public void getFormData(@ModelAttribute Anketa anketa, ActionRequest aRequest) throws ServiceException, PortalException, SystemException{
		long pk = PortalUtil.getUser(aRequest).getPrimaryKey();
		User user = userService.get(pk);
		
		if (user==null){
			return;
		}
		by.belisa.entity.Anketa ank = user.getAnketa();
		
		if (ank==null){
			ank = new by.belisa.entity.Anketa();
		}
		System.out.println(ank.getFio());
		ank.setFio(anketa.getFio());
		ank.setUser(user);
		anketaService.update(ank);
	}
	
}
