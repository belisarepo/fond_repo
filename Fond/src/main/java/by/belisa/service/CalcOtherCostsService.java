package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.CalcOtherCostsDTO;
import by.belisa.dao.Dao;
import by.belisa.entity.CalcOtherCosts;
import by.belisa.exception.DaoException;

@Service
public class CalcOtherCostsService extends ServiceImpl<CalcOtherCosts, Integer>{

	public CalcOtherCostsService() {
		super(CalcOtherCosts.class);
	}

	@Override
	@Autowired
	@Qualifier(value="calcOtherCostsDao")
	protected void setBaseDao(Dao<CalcOtherCosts, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	public CalcOtherCostsDTO getDTO(Integer id) throws DaoException{
		CalcOtherCosts calcOtherCosts = baseDao.get(id);
		return new CalcOtherCostsDTO(calcOtherCosts);
	}
	public void edit(CalcOtherCostsDTO dto) throws DaoException{
		CalcOtherCosts entity = baseDao.get(dto.getId());
		entity.setName(dto.getName());
		entity.setNote(dto.getNote());
		entity.setSum(dto.getSum());
		baseDao.update(entity);
	}

}
