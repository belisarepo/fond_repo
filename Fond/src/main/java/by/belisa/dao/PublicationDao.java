package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.Publication;

@Repository
public class PublicationDao extends DaoImpl<Publication, Integer>{

	public PublicationDao() {
		super(Publication.class);
	}

}
