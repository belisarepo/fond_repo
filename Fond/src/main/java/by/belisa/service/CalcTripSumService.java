package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.dao.ZayavkaFIDao;
import by.belisa.entity.CalcTrip;
import by.belisa.entity.CalcTripSum;
import by.belisa.exception.DaoException;

@Service
public class CalcTripSumService extends ServiceImpl<CalcTripSum, Integer>{

	public CalcTripSumService() {
		super(CalcTripSum.class);
	}

	@Autowired
	@Qualifier("zayavkaFIDao")
	private ZayavkaFIDao zayavkaFIDao;
	
	@Override
	@Autowired
	@Qualifier(value="calcZpSumDao")
	protected void setBaseDao(Dao<CalcTripSum, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	public void recalculate(Integer id) throws DaoException{
		Float sum = 0f;
		for (CalcTrip i : zayavkaFIDao.get(id).getCalcTripSet()){
			sum = sum + i.getCosts();
		}
		CalcTripSum calcTripSum = baseDao.get(id);
		calcTripSum.setSum(sum);
		baseDao.saveOrUpdate(calcTripSum);
	}

}
