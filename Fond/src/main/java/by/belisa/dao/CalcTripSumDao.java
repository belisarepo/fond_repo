package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.CalcTripSum;

@Repository
public class CalcTripSumDao extends DaoImpl<CalcTripSum, Integer>{

	public CalcTripSumDao() {
		super(CalcTripSum.class);
	}

}
