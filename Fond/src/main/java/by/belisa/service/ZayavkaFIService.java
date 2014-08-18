package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.ZayavkaFIDTO;
import by.belisa.dao.AnketaDao;
import by.belisa.dao.Dao;
import by.belisa.dao.KonkursyDao;
import by.belisa.dao.OrgDao;
import by.belisa.dao.OtraslNaukaDao;
import by.belisa.dao.SectionFondDao;
import by.belisa.dao.ZayavkaFIDao;
import by.belisa.entity.Anketa;
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
	
	@Autowired
	@Qualifier(value="anketaDao")
	private AnketaDao anketaDao;
	@Autowired
	@Qualifier(value="konkursyDao")
	private KonkursyDao konkursyDao;
	@Autowired
	@Qualifier(value="otraslNaukaDao")
	private OtraslNaukaDao otraslNaukaDao;
	@Autowired
	@Qualifier(value="sectionFondDao")
	private SectionFondDao sectionFondDao;
	@Autowired
	@Qualifier(value="orgDao")
	private OrgDao orgDao;
	
	
	public ZayavkaFIDTO getZayavkaFIDTO(int id) throws DaoException{
		ZayavkaFI zayavkaFI = baseDao.get(id);
		return new ZayavkaFIDTO(zayavkaFI);
	}
	public ZayavkaFIDTO getZayavkaFIDTOByUserId(long userId, int konkursId) throws DaoException{
		ZayavkaFIDao zayavkaFIDao = (ZayavkaFIDao)baseDao;
		ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO(zayavkaFIDao.getZayavkaFIByUserId(userId, konkursId));
		
		
		if (zayavkaFIDTO.getOrgId()==null){
			Anketa anketa = anketaDao.get(userId);
			if (anketa != null && anketa.getOrg()!=null){
				zayavkaFIDTO.setOrgId(anketa.getOrg().getId());
			}
		}
		return zayavkaFIDTO;
	}
	public Integer saveOrUpdate(ZayavkaFIDTO dto) throws DaoException{
		Integer id = dto.getId()!=null ? dto.getId() : -1; 
		ZayavkaFI zayavkaFI = baseDao.get(id);
		if (zayavkaFI==null){
			zayavkaFI = new ZayavkaFI();
		}
		zayavkaFI.setAnketa(anketaDao.get(dto.getUserId()));
		zayavkaFI.setKonkursy(konkursyDao.get(dto.getKonkursId()));
		zayavkaFI.setOtraslNauka(otraslNaukaDao.get(dto.getOtraslNaukaId()));
		zayavkaFI.setSectionFond(sectionFondDao.get(dto.getSectionFondId()));
		zayavkaFI.setTemaZName(dto.getTemaName());
		zayavkaFI.setOrganization(orgDao.get(dto.getOrgId()));
		baseDao.saveOrUpdate(zayavkaFI);
		return zayavkaFI.getId();
	}
}