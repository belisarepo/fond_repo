package by.belisa.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;

import by.belisa.bean.KonkursyDTO;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;
import by.belisa.service.KonkursyService;

@Controller(value="konkursyController")
@RequestMapping(value="VIEW")
public class KonkursyController {
	private static Logger log = Logger.getLogger(KonkursyController.class);
	@Autowired
	@Qualifier(value="konkursyService")
	private KonkursyService konkursyService;
	
	@RenderMapping
	public String renderView(Model model, PortletRequest request) throws ServiceException, DaoException{
		List<KonkursyDTO> konkursyList = konkursyService.getActiveKonkursy();
		model.addAttribute("konkursyList", konkursyList);
		return "konkursy";
	}
	@ResourceMapping()
	public void getUsloviy(ResourceRequest request, ResourceResponse response){
		
		String konkursId = ParamUtil.getString(request, "konkursId");
		byte[] usloviy = konkursyService.getUsloviy(Integer.parseInt(konkursId));
		response.setContentType("application/msword");
		response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");        
		response.setContentLength(usloviy.length);
		OutputStream outStream = null;
		try {
			outStream = response.getPortletOutputStream();
			outStream.write(usloviy);
			outStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(outStream!=null){
				try {
					outStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
