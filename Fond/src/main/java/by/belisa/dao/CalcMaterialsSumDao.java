package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.CalcMaterialsSum;

@Repository
public class CalcMaterialsSumDao extends DaoImpl<CalcMaterialsSum, Integer>{

	public CalcMaterialsSumDao() {
		super(CalcMaterialsSum.class);
	}

}
