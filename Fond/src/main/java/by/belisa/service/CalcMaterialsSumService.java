package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.dao.ZayavkaFIDao;
import by.belisa.entity.CalcMaterials;
import by.belisa.entity.CalcMaterialsSum;
import by.belisa.exception.DaoException;

@Service
public class CalcMaterialsSumService extends ServiceImpl<CalcMaterialsSum, Integer>{

	public CalcMaterialsSumService() {
		super(CalcMaterialsSum.class);
	}

	@Autowired
	@Qualifier("zayavkaFIDao")
	private ZayavkaFIDao zayavkaFIDao;
	
	@Override
	@Autowired
	@Qualifier(value="calcZpSumDao")
	protected void setBaseDao(Dao<CalcMaterialsSum, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	public void recalculate(Integer id) throws DaoException{
		Float sum = 0f;
		for (CalcMaterials i : zayavkaFIDao.get(id).getCalcMaterialsSet()){
			sum = sum + i.getSum();
		}
		CalcMaterialsSum calcMaterialsSum = baseDao.get(id);
		calcMaterialsSum.setSum(sum);
		baseDao.saveOrUpdate(calcMaterialsSum);
	}

}
