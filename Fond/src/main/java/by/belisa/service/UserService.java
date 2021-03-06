package by.belisa.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.belisa.dao.Dao;
import by.belisa.entity.User;
import by.belisa.exception.ServiceException;

@Service
public class UserService extends ServiceImpl<User, Long> {
	private static Logger log = Logger.getLogger(UserService.class);
	
	public UserService() {
		super(User.class);
	}

	@Override
	@Autowired
	@Qualifier("userDao")
	protected void setBaseDao(Dao<User, Long> baseDao) {
		super.setBaseDao(baseDao);
	}
	

}
