package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.OtraslNauka;
@Service
public class OtraslNaukaService extends ServiceImpl<OtraslNauka,Integer>{

	public OtraslNaukaService() {
		super(OtraslNauka.class);
	}

	@Override
	@Autowired
	@Qualifier(value="otraslNaukaDao")
	protected void setBaseDao(Dao<OtraslNauka, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

}
