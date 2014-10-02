package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.CalcZpSum;

@Repository
public class CalcZpSumDao extends DaoImpl<CalcZpSum, Integer>{

	public CalcZpSumDao() {
		super(CalcZpSum.class);
	}

}
