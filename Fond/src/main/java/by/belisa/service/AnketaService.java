package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.DaoImpl;
import by.belisa.entity.Anketa;
@Service
public class AnketaService extends ServiceImpl<Anketa,Long>{
	@Autowired
	@Qualifier("anketaDao")
	@Override
	public void setBaseDao(DaoImpl<Anketa, Long> baseDao) {
		// TODO Auto-generated method stub
		super.setBaseDao(baseDao);
	}
	

}
