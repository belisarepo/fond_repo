package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.CalcZp;
@Repository
public class CalcZpDao extends DaoImpl<CalcZp,Integer> {

	public CalcZpDao() {
		super(CalcZp.class);
	}

}
