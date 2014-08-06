package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.SectionFond;
@Repository
public class SectionFondDao extends DaoImpl<SectionFond,Integer>{

	public SectionFondDao() {
		super(SectionFond.class);
	}

}
