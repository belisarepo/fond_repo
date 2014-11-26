package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.CalculationD;

@Service
public class CalculationDService extends ServiceImpl<CalculationD, Integer>{

	public CalculationDService() {
		super(CalculationD.class);
	}


	@Override
	@Autowired
	@Qualifier(value="calculationDDao")
	protected void setBaseDao(Dao<CalculationD, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

}
