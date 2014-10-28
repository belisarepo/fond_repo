package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.dao.ObosnovanieDao;
import by.belisa.entity.Obosnovanie;

@Service
public class ObosnovanieService extends ServiceImpl<Obosnovanie, Integer>{

	public ObosnovanieService() {
		super(Obosnovanie.class);
	}

	@Override
	@Autowired
	@Qualifier(value="obosnovanieDao")
	protected void setBaseDao(Dao<Obosnovanie, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

	public byte[] getFile(int id) {
		ObosnovanieDao obosnovanieDao = (ObosnovanieDao) baseDao;
		return obosnovanieDao.getFile(id);
	}

	public void deleteFile(Integer zayavkaId) {
		ObosnovanieDao obosnovanieDao = (ObosnovanieDao) baseDao;
		obosnovanieDao.deleteFile(zayavkaId);
	}
}
