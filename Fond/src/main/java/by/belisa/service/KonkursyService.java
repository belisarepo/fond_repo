package by.belisa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.KonkursyDTO;
import by.belisa.dao.AnketaDao;
import by.belisa.dao.Dao;
import by.belisa.dao.FizInfoDao;
import by.belisa.dao.KonkursyDao;
import by.belisa.dao.ZayavkaFIDao;
import by.belisa.entity.Anketa;
import by.belisa.entity.Konkursy;
import by.belisa.entity.TipKonkursa;
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
	@Autowired
	@Qualifier("fizInfoDao")
	private FizInfoDao fizInfoDao;
	@Autowired
	@Qualifier("anketaDao")
	private AnketaDao anketaDao;
	@Autowired
	@Qualifier("zayavkaFIDao")
	private ZayavkaFIDao zayavkaFIDao;
	
	
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

	
	public boolean checkUsloviy(Integer konkursId, Integer fizInfoId, Long userId) throws DaoException{
		
		Konkursy konkurs = baseDao.get(konkursId);
		if (konkurs.getTipKonkursa().getFinRazdel().getId()==1){
			return true;
		}
		TipKonkursa tipKonkursa = konkurs.getTipKonkursa();
		Integer countIspl = konkurs.getCountIspolnitel();
		Integer countRuk = konkurs.getCountRukovoditel();
		Integer countIsplRuk = konkurs.getCountIspolRukov();
		
		Anketa anketa = anketaDao.get(userId);
		long currentRukCount = zayavkaFIDao.getActualCountAsRukByUser(fizInfoId, konkurs.getStartProject());
		long currentIsplCount = zayavkaFIDao.getActualCountAsIspolnitelByUser(fizInfoId, konkurs.getStartProject());
		long currentIsplRuk = zayavkaFIDao.getActualCountByKonkursType(fizInfoId, konkurs.getTipKonkursa().getId(), konkurs.getStartProject(), countIsplRuk);
		System.out.println("!!!!!!!"+currentIsplRuk);
//		if(countRuk!=null && currentRukCount>=countRuk){
//			return false;
//		}
//		if(countIspl!=null && currentIsplCount>=countIspl){
//			return false;
//		}
		if(countIsplRuk!=null && currentIsplRuk>=countIsplRuk){
			return false;
		}
		return true;
	}
}
