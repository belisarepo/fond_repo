package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.PublicationM;

@Service
public class PublicationMService extends ServiceImpl<PublicationM, Integer>{

	public PublicationMService() {
		super(PublicationM.class);
	}

	@Override
	@Autowired
	@Qualifier("publicationMDao")
	protected void setBaseDao(Dao<PublicationM, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	

}
