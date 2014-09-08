package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.CalcMaterials;

@Repository
public class CalcMaterialsDao extends DaoImpl<CalcMaterials, Integer>{

	public CalcMaterialsDao() {
		super(CalcMaterials.class);
	}

}
