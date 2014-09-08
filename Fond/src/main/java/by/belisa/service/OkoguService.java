	package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.Okogu;
@Service
public class OkoguService extends ServiceImpl<Okogu, Integer>{

	public OkoguService() {
		super(Okogu.class);
	}

	@Override
	@Autowired
	@Qualifier("okoguDao")
	protected void setBaseDao(Dao<Okogu, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
}
