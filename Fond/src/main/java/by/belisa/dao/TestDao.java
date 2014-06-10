package by.belisa.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
	private static Logger log = Logger.getLogger(TestDao.class);
	public TestDao(){
		log.debug("!!!!!!!! Test dao constructor");
	}
}
