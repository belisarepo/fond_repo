package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.CalcZpDTO;
import by.belisa.dao.Dao;
import by.belisa.entity.CalcZp;
import by.belisa.exception.DaoException;

@Service
public class CalcZpService extends ServiceImpl<CalcZp, Integer>{

	public CalcZpService() {
		super(CalcZp.class);
	}

	@Override
	@Autowired
	@Qualifier(value="calcZpDao")
	protected void setBaseDao(Dao<CalcZp, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	public CalcZpDTO getDTO(Integer id) throws DaoException{
		CalcZp calcZp = baseDao.get(id);
		return new CalcZpDTO(calcZp);
	}
	public void edit(CalcZpDTO dto) throws DaoException{
		CalcZp entity = baseDao.get(dto.getId());
		entity.setDuration(dto.getDuration());
		entity.setFondZp(dto.getFondZp());
		entity.setName(dto.getName());
		entity.setNote(dto.getNote());
		entity.setRate(dto.getRate());
		entity.setSalary(dto.getSalary());
		baseDao.update(entity);
	}

}
