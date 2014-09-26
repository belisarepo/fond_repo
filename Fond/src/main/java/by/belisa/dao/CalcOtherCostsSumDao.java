package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.CalcOtherCostsSum;

@Repository
public class CalcOtherCostsSumDao extends DaoImpl<CalcOtherCostsSum, Integer>{

	public CalcOtherCostsSumDao() {
		super(CalcOtherCostsSum.class);
	}

}
