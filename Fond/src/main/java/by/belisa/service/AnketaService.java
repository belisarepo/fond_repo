package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.Anketa;
@Service
public class AnketaService extends ServiceImpl<Anketa,Long>{
	
	public AnketaService() {
		super(Anketa.class);
	}

	@Override
	@Autowired
	@Qualifier("anketaDao")
	protected void setBaseDao(Dao<Anketa, Long> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	
	
	

}
