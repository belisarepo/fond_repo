package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.CalcMaterialsDTO;
import by.belisa.dao.Dao;
import by.belisa.entity.CalcMaterials;
import by.belisa.exception.DaoException;

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
	
	public CalcMaterialsDTO getDTO(Integer id) throws DaoException{
		CalcMaterials calcMaterials = baseDao.get(id);
		return new CalcMaterialsDTO(calcMaterials);
	}
	public void edit(CalcMaterialsDTO dto) throws DaoException{
		CalcMaterials entity = baseDao.get(dto.getId());
		entity.setName(dto.getName());
		entity.setUnit(dto.getUnit());
		entity.setCount(dto.getCount());
		entity.setSum(dto.getSum());
		baseDao.update(entity);
	}


}
