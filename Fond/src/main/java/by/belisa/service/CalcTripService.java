package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.CalcTrip;

@Service
public class CalcTripService extends ServiceImpl<CalcTrip, Integer>{

	public CalcTripService() {
		super(CalcTrip.class);
	}

	@Override
	@Autowired
	@Qualifier(value="calcTripDao")
	protected void setBaseDao(Dao<CalcTrip, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	

}
