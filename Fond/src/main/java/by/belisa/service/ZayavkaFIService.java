package by.belisa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.CalcMaterialsDTO;
import by.belisa.bean.CalcOtherCostsDTO;
import by.belisa.bean.CalcTripDTO;
import by.belisa.bean.CalcZpDTO;
import by.belisa.bean.PublicationDTO;
import by.belisa.bean.PublicationMDTO;
import by.belisa.bean.ZayavkaFIDTO;
import by.belisa.dao.AnketaDao;
import by.belisa.dao.Dao;
import by.belisa.dao.FizInfoDao;
import by.belisa.dao.KonkursyDao;
import by.belisa.dao.OrgDao;
import by.belisa.dao.OrgNrDao;
import by.belisa.dao.OtraslNaukaDao;
import by.belisa.dao.PrioritetNaukaDao;
import by.belisa.dao.PublicationDao;
import by.belisa.dao.PublicationTypeDao;
import by.belisa.dao.SectionFondDao;
import by.belisa.dao.StatusZayavkaFIDao;
import by.belisa.dao.UchStepeniDao;
import by.belisa.dao.UchZvanieDao;
import by.belisa.dao.ZayavkaFIDao;
import by.belisa.entity.Anketa;
import by.belisa.entity.Annotation;
import by.belisa.entity.CalcMaterials;
import by.belisa.entity.CalcOtherCosts;
import by.belisa.entity.CalcTrip;
import by.belisa.entity.CalcZp;
import by.belisa.entity.Calculation;
import by.belisa.entity.FizInfo;
import by.belisa.entity.Obosnovanie;
import by.belisa.entity.Publication;
import by.belisa.entity.PublicationM;
import by.belisa.entity.Rukovoditel;
import by.belisa.entity.RukovoditelNR;
import by.belisa.entity.ZayavkaFI;
import by.belisa.exception.DaoException;
import by.belisa.validation.ValidationResult;

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
	@Autowired
	@Qualifier("publicationDao")
	private PublicationDao publicationDao;
	@Autowired
	@Qualifier(value="fizInfoDao")
	private FizInfoDao fizInfoDao;
	@Autowired
	@Qualifier(value="publicationTypeDao")
	private PublicationTypeDao publicationTypeDao;

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

	public void changeStatus(int newStatus, Integer zayavkaId) throws DaoException{
		ZayavkaFI zayavka = baseDao.get(zayavkaId);
		zayavka.setStatusZayavkaFI(statusZayavkaFIDao.get(newStatus));
		baseDao.update(zayavka);
	}
	
	public ValidationResult checkZayavkaFI(Integer zayavkaId) throws DaoException{
		ZayavkaFI zayavka = baseDao.get(zayavkaId);
		return zayavka.validate();
		
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
	
	public Integer saveForm8(ZayavkaFIDTO dto) throws DaoException, ParseException {
		ZayavkaFI zayavkaFI = commonSave(dto);
		zayavkaFI.setLastingDeadline(dto.getLastingDeadline());
		if (dto.getStartDeadline()!=null && !dto.getStartDeadline().isEmpty())
		zayavkaFI.setStartDeadline(dateFormat.parse(dto.getStartDeadline()));
		if (dto.getStopDeadline()!=null && !dto.getStopDeadline().isEmpty())
		zayavkaFI.setStopDeadline(dateFormat.parse(dto.getStopDeadline()));
		baseDao.saveOrUpdate(zayavkaFI);
		return zayavkaFI.getId();

	}
	public Integer saveForm9(ZayavkaFIDTO dto) throws DaoException {
		ZayavkaFI zayavkaFI = commonSave(dto);
		zayavkaFI.setCostAll(dto.getCostAll());
		zayavkaFI.setCostFirstYear(dto.getCostFirstYear());
		baseDao.saveOrUpdate(zayavkaFI);
		return zayavkaFI.getId();

	}
	public Integer saveForm10(ZayavkaFIDTO dto) throws DaoException {
		ZayavkaFI zayavkaFI = commonSave(dto);
		Annotation annotation = zayavkaFI.getAnnotation();
		if (annotation == null){
			annotation = new Annotation();
		}
		annotation.setIdea(dto.getIdea());
		annotation.setJobGoal(dto.getJobGoal());
		annotation.setKeyWords(dto.getKeyWords());
		annotation.setResults(dto.getResults());
		annotation.setZayavkaFI(zayavkaFI);
		zayavkaFI.setAnnotation(annotation);
		baseDao.saveOrUpdate(zayavkaFI);
		return zayavkaFI.getId();

	}
	
	public Integer saveForm11(ZayavkaFIDTO dto) throws DaoException {
		ZayavkaFI zayavkaFI = commonSave(dto);
		Obosnovanie obosnovanie = zayavkaFI.getObosnovanie();
		if (obosnovanie == null){
			obosnovanie = new Obosnovanie();
		}
		obosnovanie.setAnalizResults(dto.getAnalizResults());
		obosnovanie.setExpediency(dto.getExpediency());
		obosnovanie.setGoal(dto.getGoal());
		obosnovanie.setIdeaFormulation(dto.getIdeaFormulation());
		obosnovanie.setIdeaInnovation(dto.getIdeaInnovation());
		obosnovanie.setPreviousKonkurs(dto.getPreviousKonkurs());
		obosnovanie.setProvisionEquipment(dto.getProvisionEquipment());
		obosnovanie.setReserveAuthors(dto.getReserveAuthors());
		obosnovanie.setResultsNir(dto.getResultsNir());
		obosnovanie.setStructureOfStudy(dto.getStructureOfStudy());
		obosnovanie.setTeamCharacteristic(dto.getTeamCharacteristic());
		obosnovanie.setUsingResults(dto.getUsingResults());
		obosnovanie.setZayavkaFI(zayavkaFI);
		zayavkaFI.setObosnovanie(obosnovanie);
		baseDao.saveOrUpdate(zayavkaFI);
		return zayavkaFI.getId();

	}
	public Integer saveForm12(ZayavkaFIDTO dto) throws DaoException {
		ZayavkaFI zayavkaFI = commonSave(dto);
		Rukovoditel rukovoditel = zayavkaFI.getRukovoditel();
		if (rukovoditel == null) {
			rukovoditel = new Rukovoditel();
		}
		rukovoditel.setBiography(dto.getBiographyRk());
		rukovoditel.setZayavkaFI(zayavkaFI);
		zayavkaFI.setRukovoditel(rukovoditel);
		baseDao.saveOrUpdate(zayavkaFI);
		return zayavkaFI.getId();

	}
	public Integer saveForm13(ZayavkaFIDTO dto) throws DaoException {
		ZayavkaFI zayavkaFI = commonSave(dto);
		Rukovoditel rukovoditel = zayavkaFI.getRukovoditel();
		if (rukovoditel == null) {
			rukovoditel = new Rukovoditel();
		}
		rukovoditel.setCitationIndexISI(dto.getCitationIndexISI());
		rukovoditel.setCitationIndexRINC(dto.getCitationIndexRINC());
		rukovoditel.setCitationIndexScopus(dto.getCitationIndexScopus());
		rukovoditel.setCountPublicationISI(dto.getCountPublicationISI());
		rukovoditel.setCountPublicationRINC(dto.getCountPublicationRINC());
		rukovoditel.setCountPublicationScopus(dto.getCountPublicationScopus());
		rukovoditel.setIndexHirshaISI(dto.getIndexHirshaISI());
		rukovoditel.setIndexHirshaRINC(dto.getIndexHirshaRINC());
		rukovoditel.setIndexHirshaScopus(dto.getIndexHirshaScopus());
		rukovoditel.setIndexWithoutSelfISI(dto.getIndexWithoutSelfISI());
		rukovoditel.setIndexWithoutSelfRINC(dto.getIndexWithoutSelfRINC());
		rukovoditel.setIndexWithoutSelfScopus(dto.getIndexWithoutSelfScopus());
		rukovoditel.setZayavkaFI(zayavkaFI);
		zayavkaFI.setRukovoditel(rukovoditel);
		baseDao.saveOrUpdate(zayavkaFI);
		return zayavkaFI.getId();

	}
	
	public Integer saveForm15(ZayavkaFIDTO dto) throws DaoException {
		ZayavkaFI zayavkaFI = commonSave(dto);
		Calculation calc = zayavkaFI.getCalculation();
		if (calc==null){
			calc = new Calculation();
		}
		calc.setId(dto.getCalcId());
		calc.setZpFull(dto.getZpFull());
		calc.setZpFirstYear(dto.getZpFirstYear());
		calc.setFsznFull(dto.getFsznFull());
		calc.setFsznFirstYear(dto.getFsznFirstYear());
		calc.setInsuranceFull(dto.getInsuranceFull());
		calc.setInsuranceFirstYear(dto.getInsuranceFirstYear());
		calc.setHardwareFull(dto.getHardwareFull());
		calc.setHardwareFirstYear(dto.getHardwareFirstYear());
		calc.setFuelFull(dto.getFuelFull());
		calc.setFuelFirstYear(dto.getFuelFirstYear());
		calc.setEquipmentFull(dto.getEquipmentFull());
		calc.setEquipmentFirstYear(dto.getEquipmentFirstYear());
		calc.setBusinessTripFull(dto.getBusinessTripFull());
		calc.setBusinessTripFirstYear(dto.getBusinessTripFirstYear());
		calc.setThirdPartyServicesFull(dto.getThirdPartyServicesFull());
		calc.setThirdPartyServicesFirstYear(dto.getThirdPartyServicesFirstYear());
		calc.setOtherFull(dto.getOtherFull());
		calc.setOtherFirstYear(dto.getOtherFirstYear());
		calc.setOverheadFull(dto.getOverheadFull());
		calc.setOverheadFirstYear(dto.getOverheadFirstYear());
		calc.setInnovationFondFull(dto.getInnovationFondFull());
		calc.setInnovationFondFirstYear(dto.getInnovationFondFirstYear());
		calc.setPlannedCostFull(dto.getPlannedCostFull());
		calc.setPlannedCostFirstYear(dto.getPlannedCostFirstYear());
		calc.setProfitFull(dto.getProfitFull());
		calc.setProfitFirstYear(dto.getProfitFirstYear());
		calc.setAllFull(dto.getAllFull());
		calc.setAllFirstYear(dto.getAllFirstYear());
		calc.setZayavkaFI(zayavkaFI);
		zayavkaFI.setCalculation(calc);
		baseDao.saveOrUpdate(zayavkaFI);
		return zayavkaFI.getId();

	}
	
	public void addPublication(ZayavkaFIDTO zayavkaDto, PublicationDTO publDto) throws DaoException{
		ZayavkaFI zayavkaFI = commonSave(zayavkaDto);
		Rukovoditel ruk = zayavkaFI.getRukovoditel();
		if (ruk==null){
			ruk = new Rukovoditel();
		}
		Publication publ = new Publication();
		publ.setAuthors(publDto.getAuthors());
		publ.setCitationIndex(publDto.getCitationIndex());
		publ.setDatabase(publDto.getDatabase());
		publ.setEdition(publDto.getEdition());
		publ.setName(publDto.getName());
		ruk.getPublicationSet().add(publ);
		zayavkaFI.setRukovoditel(ruk);
		ruk.setZayavkaFI(zayavkaFI);
		baseDao.saveOrUpdate(zayavkaFI);
	}
	
	public void addPublicationM(ZayavkaFIDTO zayavkaDto, PublicationMDTO publDto) throws DaoException{
		ZayavkaFI zayavkaFI = commonSave(zayavkaDto);
		FizInfo fizInfo;
		if (publDto.getFizInfoId()==0){
			fizInfo = zayavkaFI.getFizInfo();
		}else{
			fizInfo = fizInfoDao.get(publDto.getFizInfoId());
		}
		
		PublicationM publ = new PublicationM();
		publ.setAuthors(publDto.getAuthors());
		publ.setEdition(publDto.getEdition());
		publ.setName(publDto.getName());
		publ.setPages(publDto.getPages());
		publ.setPublicationType(publicationTypeDao.get(publDto.getPublicationTypeId()));
		publ.setFizInfo(fizInfo);
		publ.setPn(publDto.getPn());
		
		fizInfo.getPublication().add(publ);
		zayavkaFI.setFizInfo(fizInfo);
		
		baseDao.saveOrUpdate(zayavkaFI);
	}
	
	public void addCalcZp(ZayavkaFIDTO zayavkaDto, CalcZpDTO calcZpDto) throws DaoException{
		ZayavkaFI zayavkaFI = commonSave(zayavkaDto);
		CalcZp calcZp = new CalcZp();
		calcZp.setDuration(calcZpDto.getDuration());
		calcZp.setFondZp(calcZpDto.getFondZp());
		calcZp.setName(calcZpDto.getName());
		calcZp.setNote(calcZpDto.getNote());
		calcZp.setRate(calcZpDto.getRate());
		calcZp.setSalary(calcZpDto.getSalary());
		zayavkaFI.getCalcZpSet().add(calcZp);
		baseDao.saveOrUpdate(zayavkaFI);
	}
	
	public void addCalcMaterials(ZayavkaFIDTO zayavkaDto, CalcMaterialsDTO calcMaterialsDto) throws DaoException{
		ZayavkaFI zayavkaFI = commonSave(zayavkaDto);
		CalcMaterials calcMaterials = new CalcMaterials();
		calcMaterials.setCount(calcMaterialsDto.getCount());
		calcMaterials.setName(calcMaterialsDto.getName());
		calcMaterials.setPn(calcMaterialsDto.getPn());
		calcMaterials.setSum(calcMaterialsDto.getSum());
		calcMaterials.setUnit(calcMaterialsDto.getUnit());
		zayavkaFI.getCalcMaterialsSet().add(calcMaterials);
		baseDao.saveOrUpdate(zayavkaFI);
	}
	
	public void addCalcTrip(ZayavkaFIDTO zayavkaDto, CalcTripDTO calcTripDto) throws DaoException{
		ZayavkaFI zayavkaFI = commonSave(zayavkaDto);
		CalcTrip calcTrip = new CalcTrip();
		calcTrip.setCosts(calcTripDto.getCosts());
		calcTrip.setCount(calcTripDto.getCount());
		calcTrip.setDuration(calcTripDto.getDuration());
		calcTrip.setTripGoal(calcTripDto.getTripGoal());
		calcTrip.setTripPoint(calcTripDto.getTripPoint());
		zayavkaFI.getCalcTripSet().add(calcTrip);
		baseDao.saveOrUpdate(zayavkaFI);
	}
	
	public void addCalcOtherCosts(ZayavkaFIDTO zayavkaDto, CalcOtherCostsDTO calcOtherCostsDto) throws DaoException{
		ZayavkaFI zayavkaFI = commonSave(zayavkaDto);
		CalcOtherCosts calcOtherCosts = new CalcOtherCosts();
		calcOtherCosts.setName(calcOtherCostsDto.getName());
		calcOtherCosts.setNote(calcOtherCostsDto.getNote());
		calcOtherCosts.setPn(calcOtherCostsDto.getPn());
		calcOtherCosts.setSum(calcOtherCostsDto.getSum());
		zayavkaFI.getCalcOtherCostsSet().add(calcOtherCosts);
		baseDao.saveOrUpdate(zayavkaFI);
	}
	
	
	public Integer saveOrUpdate(ZayavkaFIDTO dto) throws DaoException, ParseException {
		ZayavkaFI zayavkaFI = commonSave(dto);
		baseDao.saveOrUpdate(zayavkaFI);
		return zayavkaFI.getId();
	}

	private ZayavkaFI commonSave(ZayavkaFIDTO dto) throws DaoException {
		ZayavkaFI zayavkaFI;
		Anketa anketa = anketaDao.get(dto.getUserId());
		FizInfo fizInfo = fizInfoDao.getByFio(anketa.getSurname(),anketa.getName(),anketa.getPatronymic(),anketa.getBirthday());
		if (dto.getId()==null){
			zayavkaFI = new ZayavkaFI();
			zayavkaFI.setAnketa(anketa);
			zayavkaFI.setFizInfo(fizInfo);
			zayavkaFI.setKonkursy(konkursyDao.get(dto.getKonkursId()));
			zayavkaFI.setStatusZayavkaFI(statusZayavkaFIDao.get(1));// id=1 -
			// Подготовка
			// материалов
		}else{
			zayavkaFI = baseDao.get(dto.getId());
		}
		return zayavkaFI;
	}
}
