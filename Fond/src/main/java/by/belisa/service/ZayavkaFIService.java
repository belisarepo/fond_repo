package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.ZayavkaFIDTO;
import by.belisa.dao.Dao;
import by.belisa.dao.ZayavkaFIDao;
import by.belisa.entity.ZayavkaFI;
import by.belisa.exception.DaoException;
@Service
public class ZayavkaFIService extends ServiceImpl<ZayavkaFI, Integer> {

	public ZayavkaFIService() {
		super(ZayavkaFI.class);
	}

	@Override
	@Autowired
	@Qualifier(value="zayavkaFIDao")
	protected void setBaseDao(Dao<ZayavkaFI, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	public ZayavkaFIDTO getZayavkaFIDTO(int id) throws DaoException{
		ZayavkaFI zayavkaFI = baseDao.get(id);
		return new ZayavkaFIDTO(zayavkaFI);
	}
	public ZayavkaFIDTO getZayavkaFIDTOByUserId(long userId, int konkursId){
		ZayavkaFIDao zayavkaFIDao = (ZayavkaFIDao)baseDao;
		return new ZayavkaFIDTO(zayavkaFIDao.getZayavkaFIByUserId(userId, konkursId));
	}
}