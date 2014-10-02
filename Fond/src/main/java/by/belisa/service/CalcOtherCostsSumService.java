package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.dao.ZayavkaFIDao;
import by.belisa.entity.CalcOtherCosts;
import by.belisa.entity.CalcOtherCostsSum;
import by.belisa.exception.DaoException;

@Service
public class CalcOtherCostsSumService extends ServiceImpl<CalcOtherCostsSum, Integer>{

	public CalcOtherCostsSumService() {
		super(CalcOtherCostsSum.class);
	}

	@Autowired
	@Qualifier("zayavkaFIDao")
	private ZayavkaFIDao zayavkaFIDao;
	
	@Override
	@Autowired
	@Qualifier(value="calcOtherCostsSumDao")
	protected void setBaseDao(Dao<CalcOtherCostsSum, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	public void recalculate(Integer id) throws DaoException{
		Float sum = 0f;
		for (CalcOtherCosts i : zayavkaFIDao.get(id).getCalcOtherCostsSet()){
			sum = sum + i.getSum();
		}
		CalcOtherCostsSum calcOtherCostsSum = baseDao.get(id);
		calcOtherCostsSum.setSum(sum);
		baseDao.saveOrUpdate(calcOtherCostsSum);
	}

}
