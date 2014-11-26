package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.Dogovor;

@Service
public class DogovorService extends ServiceImpl<Dogovor, Integer>{

	public DogovorService() {
		super(Dogovor.class);
	}

	@Override
	@Autowired
	@Qualifier(value="dogovorDao")
	protected void setBaseDao(Dao<Dogovor, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

}
