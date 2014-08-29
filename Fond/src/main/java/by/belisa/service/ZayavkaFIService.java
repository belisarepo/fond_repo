package by.belisa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.ZayavkaFIDTO;
import by.belisa.dao.AnketaDao;
import by.belisa.dao.Dao;
import by.belisa.dao.KonkursyDao;
import by.belisa.dao.OrgDao;
import by.belisa.dao.OrgNrDao;
import by.belisa.dao.OtraslNaukaDao;
import by.belisa.dao.PrioritetNaukaDao;
import by.belisa.dao.SectionFondDao;
import by.belisa.dao.StatusZayavkaFIDao;
import by.belisa.dao.UchStepeniDao;
import by.belisa.dao.UchZvanieDao;
import by.belisa.dao.ZayavkaFIDao;
import by.belisa.entity.Anketa;
import by.belisa.entity.Rukovoditel;
import by.belisa.entity.RukovoditelNR;
import by.belisa.entity.ZayavkaFI;
import by.belisa.exception.DaoException;

@Service
public class ZayavkaFIService extends ServiceImpl<ZayavkaFI, Integer> {

	public ZayavkaFIService() {
		super(ZayavkaFI.class);
	}

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	@Autowired
	@Qualifier(value = "zayavkaFIDao")
	protected void setBaseDao(Dao<ZayavkaFI, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

	@Autowired
	@Qualifier(value = "anketaDao")
	private AnketaDao anketaDao;
	@Autowired
	@Qualifier(value = "konkursyDao")
	private KonkursyDao konkursyDao;
	@Autowired
	@Qualifier(value = "otraslNaukaDao")
	private OtraslNaukaDao otraslNaukaDao;
	@Autowired
	@Qualifier(value = "prioritetNaukaDao")
	private PrioritetNaukaDao prioritetNaukaDao;
	@Autowired
	@Qualifier(value = "sectionFondDao")
	private SectionFondDao sectionFondDao;
	@Autowired
	@Qualifier(value = "orgDao")
	private OrgDao orgDao;
	@Autowired
	@Qualifier(value = "orgNrDao")
	private OrgNrDao orgNrDao;
	@Autowired
	@Qualifier(value = "statusZayavkaFIDao")
	private StatusZayavkaFIDao statusZayavkaFIDao;
	@Autowired
	@Qualifier("uchStepeniDao")
	private UchStepeniDao uchStepeniDao;
	@Autowired
	@Qualifier("uchZvanieDao")
	private UchZvanieDao uchZvanieDao;

	public ZayavkaFIDTO getZayavkaFIDTO(int id) throws DaoException {
		ZayavkaFI zayavkaFI = baseDao.get(id);
		return new ZayavkaFIDTO(zayavkaFI);
	}

	public ZayavkaFIDTO getZayavkaFIDTOByUserId(long userId, int konkursId) throws DaoException {
		ZayavkaFIDao zayavkaFIDao = (ZayavkaFIDao) baseDao;
		ZayavkaFI zayavkaFI = zayavkaFIDao.getZayavkaFIByUserId(userId, konkursId);
		if (zayavkaFI == null) {
			zayavkaFI = new ZayavkaFI();
			Anketa anketa = anketaDao.get(userId);
			zayavkaFI.setAnketa(anketa);
			zayavkaFI.setOrganization(anketa.getOrg());
			zayavkaFI.setKonkursy(konkursyDao.get(konkursId));
		}
		ZayavkaFIDTO zayavkaFIDTO = new ZayavkaFIDTO(zayavkaFI);
		return zayavkaFIDTO;
	}

	public Integer saveForm1(ZayavkaFIDTO dto) throws DaoException {
		ZayavkaFI zayavkaFI = commonSave(dto);
		if (dto.getOtraslNaukaId() != null)
			zayavkaFI.setOtraslNauka(otraslNaukaDao.get(dto.getOtraslNaukaId()));
		if (dto.getPrioritetNaukaId() != null)
			zayavkaFI.setPrioritetNauka(prioritetNaukaDao.get(dto.getPrioritetNaukaId()));
		if (dto.getSectionFondId() != null)
			zayavkaFI.setSectionFond(sectionFondDao.get(dto.getSectionFondId()));
		zayavkaFI.setTemaZName(dto.getTemaName());
		zayavkaFI.setCodeUdk(dto.getUdk());
		baseDao.saveOrUpdate(zayavkaFI);
		return zayavkaFI.getId();

	}
	
	public Integer saveForm2(ZayavkaFIDTO dto) throws DaoException, ParseException {
		ZayavkaFI zayavkaFI = commonSave(dto);
		Rukovoditel rukovoditel = zayavkaFI.getRukovoditel();
		if (rukovoditel == null) {
			rukovoditel = new Rukovoditel();
		}
		rukovoditel.setAddress(dto.getAddressRk());
//		rukovoditel.setBiography(dto.getBiographyRk());
		if (dto.getBirthdayRk() != null && !dto.getBirthdayRk().isEmpty()) {
			rukovoditel.setBirthday(dateFormat.parse(dto.getBirthdayRk()));
		}
		// rukovoditel.setCitationIndexISI(citationIndexISI);
		// rukovoditel.setCitationIndexRINC(citationIndexRINC);
		// rukovoditel.setCitationIndexScopus(citationIndexScopus);
		// rukovoditel.setCountPublicationISI(countPublicationISI);
		// rukovoditel.setCountPublicationRINC(countPublicationRINC);
		// rukovoditel.setCountPublicationScopus(countPublicationScopus);
		rukovoditel.setEmail(dto.getEmailRk());
		rukovoditel.setFio(zayavkaFI.getAnketa().getFio());
		rukovoditel.setFullFio(zayavkaFI.getAnketa().getFullFio());
		rukovoditel.setHomePhone(dto.getHomePhoneRk());
		// rukovoditel.setIndexHirshaISI(indexHirshaISI);
		// rukovoditel.setIndexHirshaRINC(indexHirshaRINC);
		// rukovoditel.setIndexHirshaScopus(indexHirshaScopus);
		// rukovoditel.setIndexWithoutSelfISI(indexWithoutSelfISI);
		// rukovoditel.setIndexWithoutSelfRINC(indexWithoutSelfRINC);
		// rukovoditel.setIndexWithoutSelfScopus(indexWithoutSelfScopus);
		rukovoditel.setJobPhone(dto.getJobPhoneRk());
		rukovoditel.setLab(dto.getLabRk());
		rukovoditel.setMobilePhone(dto.getMobilePhoneRk());
		if (dto.getOrgIdRk() != null)
			rukovoditel.setOrg(orgDao.get(dto.getOrgIdRk()));
		rukovoditel.setPost(dto.getPostRk());
		// rukovoditel.setPublicationSet(publicationSet);
		if (dto.getUchStepenIdRk() != null)
			rukovoditel.setUchStepeni(uchStepeniDao.get(dto.getUchStepenIdRk()));
		if (dto.getUchZvaniyIdRk() != null)
			rukovoditel.setUchZvaniy(uchZvanieDao.get(dto.getUchZvaniyIdRk()));
		rukovoditel.setZayavkaFI(zayavkaFI);
		zayavkaFI.setRukovoditel(rukovoditel);
		baseDao.saveOrUpdate(zayavkaFI);
		return zayavkaFI.getId();

	}
	
	public Integer saveForm3(ZayavkaFIDTO dto) throws DaoException {
		ZayavkaFI zayavkaFI = commonSave(dto);
		zayavkaFI.setOrganization(orgDao.get(dto.getOrgId()));
		baseDao.saveOrUpdate(zayavkaFI);
		return zayavkaFI.getId();

	}
	
	public Integer saveForm4(ZayavkaFIDTO dto) throws DaoException, ParseException {
		ZayavkaFI zayavkaFI = commonSave(dto);
		RukovoditelNR ruk = zayavkaFI.getRukovoditelNr();
		if (ruk==null){
			ruk = new RukovoditelNR();
		}
		ruk.setFio(dto.getFioRkNr());
		ruk.setFullFio(dto.getFullFioRkNr());
		if (dto.getBirthdayRkNr() != null && !dto.getBirthdayRkNr().isEmpty()) {
			ruk.setBirthday(dateFormat.parse(dto.getBirthdayRkNr()));
		}
		ruk.setPost(dto.getPostRkNr());
		if (dto.getUchStepenIdRkNr()!=null)
		ruk.setUchStepeni(uchStepeniDao.get(dto.getUchStepenIdRkNr()));
		if (dto.getUchZvaniyIdRkNr()!=null)
		ruk.setUchZvaniy(uchZvanieDao.get(dto.getUchZvaniyIdRkNr()));
		ruk.setZayavkaFI(zayavkaFI);
		zayavkaFI.setRukovoditelNr(ruk);
		baseDao.saveOrUpdate(zayavkaFI);
		return zayavkaFI.getId();

	}
	public Integer saveForm5(ZayavkaFIDTO dto) throws DaoException {
		ZayavkaFI zayavkaFI = commonSave(dto);
		zayavkaFI.setOrgNR(orgNrDao.get(dto.getOrgNrId()));
		baseDao.saveOrUpdate(zayavkaFI);
		return zayavkaFI.getId();

	}

	public Integer saveOrUpdate(ZayavkaFIDTO dto) throws DaoException, ParseException {
		ZayavkaFI zayavkaFI = commonSave(dto);
		baseDao.saveOrUpdate(zayavkaFI);
		return zayavkaFI.getId();
	}

	private ZayavkaFI commonSave(ZayavkaFIDTO dto) throws DaoException {
		Integer id = dto.getId() != null ? dto.getId() : -1;
		ZayavkaFI zayavkaFI = baseDao.get(id);
		if (zayavkaFI == null) {
			zayavkaFI = new ZayavkaFI();
		}
		zayavkaFI.setAnketa(anketaDao.get(dto.getUserId()));
		zayavkaFI.setKonkursy(konkursyDao.get(dto.getKonkursId()));
		zayavkaFI.setStatusZayavkaFI(statusZayavkaFIDao.get(1));// id=1 -
		// Подготовка
		// материалов
		return zayavkaFI;
	}
}