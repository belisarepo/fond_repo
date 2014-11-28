package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.DogovorDTO;
import by.belisa.dao.Dao;
import by.belisa.entity.Dogovor;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;

@Service
public class DogovorService extends ServiceImpl<Dogovor, Integer>{

	public DogovorService() {
		super(Dogovor.class);
	}

	@Override
	@Autowired
	@Qualifier(value="dogovorDao")
	protected void setBaseDao(Dao<Dogovor, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	public DogovorDTO getDTO(Integer id) throws ServiceException{
		try {
			return new DogovorDTO(baseDao.get(id));
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
