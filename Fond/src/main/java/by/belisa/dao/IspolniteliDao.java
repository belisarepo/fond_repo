package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.Ispolnitel;
@Repository
public class IspolniteliDao extends DaoImpl<Ispolnitel, Integer>{

	public IspolniteliDao() {
		super(Ispolnitel.class);
	}

}
