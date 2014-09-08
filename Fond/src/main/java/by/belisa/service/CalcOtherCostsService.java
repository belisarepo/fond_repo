package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.CalcOtherCosts;

@Service
public class CalcOtherCostsService extends ServiceImpl<CalcOtherCosts, Integer>{

	public CalcOtherCostsService() {
		super(CalcOtherCosts.class);
	}

	@Override
	@Autowired
	@Qualifier(value="calcOtherCostsDao")
	protected void setBaseDao(Dao<CalcOtherCosts, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

}
