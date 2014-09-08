package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.CalcZp;

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

}
