package by.belisa.service;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.belisa.dao.DaoImpl;
import by.belisa.entity.User;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;
@Service
public class UserService extends ServiceImpl<User,Long>
{
	private static Logger log = Logger.getLogger(UserService.class);
	public UserService(){
		super();
		log.debug("!!!!!!!!!!user service created");
	}
	@Autowired
	@Qualifier("userDao")
	@Override
	public void setBaseDao(DaoImpl<User, Long> baseDao) {
		// TODO Auto-generated method stub
		super.setBaseDao(baseDao);
	}
	
	
}
