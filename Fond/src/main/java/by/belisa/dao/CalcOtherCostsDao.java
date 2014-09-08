package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.CalcOtherCosts;
@Repository
public class CalcOtherCostsDao extends DaoImpl<CalcOtherCosts, Integer> {

	public CalcOtherCostsDao() {
		super(CalcOtherCosts.class);
	}

}
