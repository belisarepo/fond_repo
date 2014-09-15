package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.PublicationType;

@Service
public class PublicationTypeService extends ServiceImpl<PublicationType, Integer>{

	public PublicationTypeService() {
		super(PublicationType.class);
	}

	@Override
	@Autowired
	@Qualifier(value="publicationTypeDao")
	protected void setBaseDao(Dao<PublicationType, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

}
