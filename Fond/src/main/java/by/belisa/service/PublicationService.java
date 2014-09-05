package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.PublicationDTO;
import by.belisa.dao.Dao;
import by.belisa.entity.Publication;

@Service
public class PublicationService extends ServiceImpl<Publication, Integer>{

	public PublicationService() {
		super(Publication.class);
	}

	@Override
	@Autowired
	@Qualifier(value="publicationDao")
	protected void setBaseDao(Dao<Publication, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
}
