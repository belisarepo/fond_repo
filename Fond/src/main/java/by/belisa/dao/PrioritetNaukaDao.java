package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.PrioritetNauka;
@Repository
public class PrioritetNaukaDao extends DaoImpl<PrioritetNauka, Integer>{

	public PrioritetNaukaDao() {
		super(PrioritetNauka.class);
	}

}
