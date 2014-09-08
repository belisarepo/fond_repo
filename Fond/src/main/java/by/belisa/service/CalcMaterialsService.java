package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.CalcMaterials;

@Service
public class CalcMaterialsService extends ServiceImpl<CalcMaterials, Integer>{

	public CalcMaterialsService() {
		super(CalcMaterials.class);
	}

	@Override
	@Autowired
	@Qualifier(value="calcMaterialsDao")
	protected void setBaseDao(Dao<CalcMaterials, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

}
