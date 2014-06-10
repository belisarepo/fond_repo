package by.belisa.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class TestService {
	private static Logger log = Logger.getLogger(TestService.class);
	public TestService(){
		log.debug("!!!!!!!!!created Test Service");
	}
}
