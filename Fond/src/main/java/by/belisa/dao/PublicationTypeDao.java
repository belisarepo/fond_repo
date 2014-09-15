package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.PublicationType;

@Repository
public class PublicationTypeDao extends DaoImpl<PublicationType, Integer>{

	public PublicationTypeDao() {
		super(PublicationType.class);
	}

}
