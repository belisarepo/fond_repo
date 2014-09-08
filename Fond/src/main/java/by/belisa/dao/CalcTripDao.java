package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.CalcTrip;
@Repository
public class CalcTripDao extends DaoImpl<CalcTrip,Integer> {

	public CalcTripDao() {
		super(CalcTrip.class);
	}

}
