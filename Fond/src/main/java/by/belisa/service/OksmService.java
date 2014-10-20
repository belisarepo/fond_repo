package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.Oksm;

@Service
public class OksmService extends ServiceImpl<Oksm, Integer>{

	public OksmService() {
		super(Oksm.class);
	}

	@Override
	@Autowired
	@Qualifier(value="oksmDao")
	protected void setBaseDao(Dao<Oksm, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

}
