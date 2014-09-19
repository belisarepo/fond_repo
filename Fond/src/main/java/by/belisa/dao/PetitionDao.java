package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.Petition;

@Repository
public class PetitionDao extends DaoImpl<Petition, Integer>{

	public PetitionDao() {
		super(Petition.class);
	}
	
}
