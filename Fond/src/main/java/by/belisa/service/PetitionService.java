package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.Petition;

@Service
public class PetitionService extends ServiceImpl<Petition, Integer>{

	public PetitionService() {
		super(Petition.class);
	}

		
	@Override
	@Autowired
	@Qualifier(value="petitionDao")
	protected void setBaseDao(Dao<Petition, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	
	
}
