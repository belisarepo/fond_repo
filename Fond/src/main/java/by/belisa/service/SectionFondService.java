package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.SectionFond;

@Service
public class SectionFondService extends ServiceImpl<SectionFond,Integer>{

	public SectionFondService() {
		super(SectionFond.class);
	}

	@Override
	@Autowired
	@Qualifier("sectionFondDao")
	protected void setBaseDao(Dao<SectionFond, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
}