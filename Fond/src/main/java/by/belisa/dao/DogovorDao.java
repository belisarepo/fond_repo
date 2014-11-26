package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.Dogovor;

@Repository
public class DogovorDao extends DaoImpl<Dogovor, Integer>{

	public DogovorDao() {
		super(Dogovor.class);
	}

}
