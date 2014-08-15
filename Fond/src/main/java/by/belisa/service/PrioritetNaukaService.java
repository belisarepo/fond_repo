package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.PrioritetNauka;

@Service
public class PrioritetNaukaService extends ServiceImpl<PrioritetNauka, Integer>{

	public PrioritetNaukaService() {
		super(PrioritetNauka.class);
	}

	@Override
	@Autowired
	@Qualifier(value="prioritetNaukaDao")
	protected void setBaseDao(Dao<PrioritetNauka, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	

}
