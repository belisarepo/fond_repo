package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.PublicationM;

@Repository
public class PublicationMDao extends DaoImpl<PublicationM, Integer>{

	public PublicationMDao() {
		super(PublicationM.class);
	}

}
