package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.Oksm;

@Repository
public class OksmDao extends DaoImpl<Oksm, Integer>{

	public OksmDao() {
		super(Oksm.class);
	}

}
