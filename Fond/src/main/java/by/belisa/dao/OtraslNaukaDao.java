package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.OtraslNauka;
@Repository
public class OtraslNaukaDao extends DaoImpl<OtraslNauka,Integer>{

	public OtraslNaukaDao() {
		super(OtraslNauka.class);
	}
	
}
