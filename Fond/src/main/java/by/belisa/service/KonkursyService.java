package by.belisa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.KonkursyDTO;
import by.belisa.dao.Dao;
import by.belisa.dao.KonkursyDao;
import by.belisa.entity.Konkursy;
import by.belisa.exception.DaoException;

@Service
public class KonkursyService extends ServiceImpl<Konkursy, Integer>{

	public KonkursyService() {
		super(Konkursy.class);
	}
	
	
	@Override
	@Autowired
	@Qualifier("konkursyDao")
	protected void setBaseDao(Dao<Konkursy, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	public List<KonkursyDTO> getAllKonkursyDTO() throws DaoException{
		List<Konkursy> konkursyList = baseDao.getAll();
		List<KonkursyDTO> konkursyDTOList = new ArrayList<KonkursyDTO>();
		for (Konkursy i : konkursyList){
			KonkursyDTO dto = new KonkursyDTO(i);
			konkursyDTOList.add(dto);
		}
		return konkursyDTOList;
	}
	
	public byte[] getUsloviy(int id){
		KonkursyDao konkursyDao = (KonkursyDao)baseDao;
		return konkursyDao.getUsloviy(id);
	}
	
	public List<KonkursyDTO> getActiveKonkursy(){
		KonkursyDao konkursyDao = (KonkursyDao)baseDao;
		List<Konkursy> konkursyList = konkursyDao.getActiveKonkursy();
		List<KonkursyDTO> konkursyDTOList = new ArrayList<KonkursyDTO>();
		for (Konkursy i : konkursyList){
			KonkursyDTO dto = new KonkursyDTO(i);
			konkursyDTOList.add(dto);
		}
		return konkursyDTOList;
		
	}

}
