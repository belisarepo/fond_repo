package by.belisa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.CheckUslResult;
import by.belisa.bean.KonkursyDTO;
import by.belisa.dao.AnketaDao;
import by.belisa.dao.Dao;
import by.belisa.dao.FizInfoDao;
import by.belisa.dao.KonkursyDao;
import by.belisa.dao.ZayavkaFIDao;
import by.belisa.entity.Anketa;
import by.belisa.entity.Konkursy;
import by.belisa.entity.TipKonkursa;
import by.belisa.entity.ZayavkaFI;
import by.belisa.exception.DaoException;

@Service
public class KonkursyService extends ServiceImpl<Konkursy, Integer> {

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

	public List<KonkursyDTO> getAllKonkursyDTO() throws DaoException {
		List<Konkursy> konkursyList = baseDao.getAll();
		List<KonkursyDTO> konkursyDTOList = new ArrayList<KonkursyDTO>();
		for (Konkursy i : konkursyList) {
			KonkursyDTO dto = new KonkursyDTO(i);
			konkursyDTOList.add(dto);
		}
		return konkursyDTOList;
	}

	public byte[] getUsloviy(int id) {
		KonkursyDao konkursyDao = (KonkursyDao) baseDao;
		return konkursyDao.getUsloviy(id);
	}

	public List<KonkursyDTO> getActiveKonkursy() {
		KonkursyDao konkursyDao = (KonkursyDao) baseDao;
		List<Konkursy> konkursyList = konkursyDao.getActiveKonkursy();
		List<KonkursyDTO> konkursyDTOList = new ArrayList<KonkursyDTO>();
		for (Konkursy i : konkursyList) {
			KonkursyDTO dto = new KonkursyDTO(i);
			konkursyDTOList.add(dto);
		}
		return konkursyDTOList;

	}

	public CheckUslResult checkUsloviyaRuk(Integer konkursId, Integer fizInfoId) throws DaoException {
		CheckUslResult result = new CheckUslResult();
		
		Konkursy konkurs = baseDao.get(konkursId);
		Date startProject = konkurs.getStartProject();
		
		Integer countIspl = konkurs.getCountIspolnitel();
		Integer countRuk = konkurs.getCountRukovoditel();
		Integer countIsplRuk = konkurs.getCountIspolRukov();
		Integer countAllTime = konkurs.getCountAllTime();
		
		int currentIsplCount=0;
		int currentRukCount=0;
		int currentIsplRuk=0;
		int currentAllTime=0;
		
		if (countAllTime!=null){
			List<ZayavkaFI> list = zayavkaFIDao.getAllTimeByKonkursType(fizInfoId, konkurs.getTipKonkursa().getId());
			currentAllTime = list.size();
			if (currentAllTime>=countAllTime){
				for (ZayavkaFI i : list){
					result.getKonkursRuk().put(i.getKonkursy().getNameR(), i.getFizInfo().getSurname());
				}
				return result;
			}
		}
		
		if (countIsplRuk!=null){
			List<ZayavkaFI> list = zayavkaFIDao.getActualByKonkursType(fizInfoId, konkurs.getTipKonkursa().getId(), startProject);
			currentIsplRuk = list.size();
			if (currentIsplRuk>=countIsplRuk){
				for (ZayavkaFI i : list){
					result.getKonkursRuk().put(i.getKonkursy().getNameR(), i.getFizInfo().getSurname());
				}
				return result;
			}
		}
		
		if (countRuk!=null){
			List<ZayavkaFI> list = zayavkaFIDao.getActualAsRukByUser(fizInfoId, startProject);
			currentRukCount = list.size();
			if (currentRukCount>=countRuk){
				for (ZayavkaFI i : list){
					result.getKonkursRuk().put(i.getKonkursy().getNameR(), i.getFizInfo().getSurname());
				}
				return result;
			}
		}
		
		if (countIspl!=null){
			List<ZayavkaFI> list = zayavkaFIDao.getActualAsIspolnitelByUser(fizInfoId, startProject);
			currentIsplCount = list.size();
			if (countRuk==null){
				List<ZayavkaFI> listRuk = zayavkaFIDao.getActualAsRukByUser(fizInfoId, startProject);
				currentRukCount = listRuk.size();
				list.addAll(listRuk);
			}
			if (currentIsplCount+currentRukCount>=countIspl){
				for (ZayavkaFI i : list){
					result.getKonkursRuk().put(i.getKonkursy().getNameR(), i.getFizInfo().getSurname());
				}
				return result;
			}
		}
		
		
		
		return result;
	}

	public CheckUslResult checkUsloviyaIspl(Integer konkursId, Integer fizInfoId) throws DaoException {
		CheckUslResult result = new CheckUslResult();
		
		Konkursy konkurs = baseDao.get(konkursId);
		Date startProject = konkurs.getStartProject();
		
		Integer countIspl = konkurs.getCountIspolnitel();
		Integer countRuk = konkurs.getCountRukovoditel();
		Integer countIsplRuk = konkurs.getCountIspolRukov();
		
		int currentIsplCount=0;
		int currentRukCount=0;
		int currentIsplRuk=0;
		
		if (countIsplRuk!=null){
			List<ZayavkaFI> list = zayavkaFIDao.getActualByKonkursType(fizInfoId, konkurs.getTipKonkursa().getId(), startProject);
			currentIsplRuk = list.size();
			if (currentIsplRuk>=countIsplRuk){
				for (ZayavkaFI i : list){
					result.getKonkursRuk().put(i.getKonkursy().getNameR(), i.getFizInfo().getSurname());
				}
				return result;
			}
		}
		
		if (countIspl!=null){
			List<ZayavkaFI> list = zayavkaFIDao.getActualAsIspolnitelByUser(fizInfoId, startProject);
			currentIsplCount = list.size();
			if (countRuk==null){
				List<ZayavkaFI> listRuk = zayavkaFIDao.getActualAsRukByUser(fizInfoId, startProject);
				currentRukCount = listRuk.size();
				list.addAll(listRuk);
			}
			if (currentIsplCount+currentRukCount>=countIspl){
				for (ZayavkaFI i : list){
					result.getKonkursRuk().put(i.getKonkursy().getNameR(), i.getFizInfo().getSurname());
				}
				return result;
			}
		}
		
		return result;
	}

	
}
