package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.CalcTripDTO;
import by.belisa.dao.Dao;
import by.belisa.entity.CalcTrip;
import by.belisa.exception.DaoException;

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
	public CalcTripDTO getDTO(Integer id) throws DaoException{
		CalcTrip calcTrip = baseDao.get(id);
		return new CalcTripDTO(calcTrip);
	}
	public void edit(CalcTripDTO dto) throws DaoException{
		CalcTrip entity = baseDao.get(dto.getId());
		entity.setCosts(dto.getCosts());
		entity.setCount(dto.getCount());
		entity.setDuration(dto.getDuration());
		entity.setTripGoal(dto.getTripGoal());
		entity.setTripPoint(dto.getTripPoint());
		baseDao.update(entity);
	}

}
