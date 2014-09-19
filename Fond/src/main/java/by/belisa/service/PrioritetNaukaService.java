package by.belisa.service;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.PrioritetNauka;
import by.belisa.exception.DaoException;

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
	
	public List<PrioritetNauka> getAllActual() throws DaoException{
		Criterion[] criterions = {Restrictions.eq("priznak", 3)};
		return baseDao.getList(criterions);
	}
	

}
