package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.dao.ZayavkaFIDao;
import by.belisa.entity.CalcZp;
import by.belisa.entity.CalcZpSum;
import by.belisa.exception.DaoException;

@Service
public class CalcZpSumService extends ServiceImpl<CalcZpSum, Integer>{

	public CalcZpSumService() {
		super(CalcZpSum.class);
	}

	@Autowired
	@Qualifier("zayavkaFIDao")
	private ZayavkaFIDao zayavkaFIDao;
	
	@Override
	@Autowired
	@Qualifier(value="calcZpSumDao")
	protected void setBaseDao(Dao<CalcZpSum, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	public void recalculate(Integer id) throws DaoException{
		Float sum = 0f;
		for (CalcZp i : zayavkaFIDao.get(id).getCalcZpSet()){
			sum = sum + i.getFondZp();
		}
		CalcZpSum calcZpSum = baseDao.get(id);
		calcZpSum.setSum(sum);
		baseDao.saveOrUpdate(calcZpSum);
	}

}
