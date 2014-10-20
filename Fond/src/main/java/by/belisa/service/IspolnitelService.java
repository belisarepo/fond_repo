package by.belisa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.IspolnitelDTO;
import by.belisa.dao.Dao;
import by.belisa.dao.FizInfoDao;
import by.belisa.dao.IspolniteliDao;
import by.belisa.dao.OrgDao;
import by.belisa.dao.UchStepeniDao;
import by.belisa.dao.UchZvanieDao;
import by.belisa.dao.ZayavkaFIDao;
import by.belisa.entity.Ispolnitel;
import by.belisa.entity.UchStepeni;
import by.belisa.entity.UchZvaniy;
import by.belisa.exception.DaoException;
@Service
public class IspolnitelService extends ServiceImpl<Ispolnitel, Integer>{

	public IspolnitelService() {
		super(Ispolnitel.class);
	}

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	@Override
	@Autowired
	@Qualifier(value="ispolniteliDao")
	protected void setBaseDao(Dao<Ispolnitel, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	@Autowired
	@Qualifier(value="fizInfoDao")
	private FizInfoDao fizInfoDao;
	@Autowired
	@Qualifier("uchStepeniDao")
	private UchStepeniDao uchStepeniDao;
	@Autowired
	@Qualifier("uchZvanieDao")
	private UchZvanieDao uchZvanieDao;
	@Autowired
	@Qualifier("orgDao")
	private OrgDao orgDao;
	@Autowired
	@Qualifier("zayavkaFIDao")
	private ZayavkaFIDao zayavkaFIDao;
	
	public List<IspolnitelDTO> getAllDTOByZayavkaId(Integer zayavkaId) throws DaoException{
		if (zayavkaId==null){
			return new ArrayList<IspolnitelDTO>();
		}
		IspolniteliDao ispolniteliDao= (IspolniteliDao)baseDao; 
		List<Ispolnitel> ispolnitelList = ispolniteliDao.getAllByZayavkaId(zayavkaId);
		List<IspolnitelDTO> ispolnitelDTOList = new ArrayList<IspolnitelDTO>();
		for (Ispolnitel i : ispolnitelList){
			ispolnitelDTOList.add(new IspolnitelDTO(i,false));
		}
		return ispolnitelDTOList;
	}
	
	public void saveOrUpdate(IspolnitelDTO dto) throws ParseException, DaoException{
		Ispolnitel ispolnitel ;
		if (dto.getId()!=null){
			ispolnitel = baseDao.get(dto.getId());
		}else{
			ispolnitel = new Ispolnitel();
		}
		
		if (dto.getBirthday()!=null && !dto.getBirthday().isEmpty()){
			ispolnitel.setBirthday(dateFormat.parse(dto.getBirthday()));
		}
		ispolnitel.setName(dto.getName());
		if (dto.getOrgId()!=null){
			ispolnitel.setOrg(orgDao.get(dto.getOrgId()));
		}
		
		ispolnitel.setPatronymic(dto.getPatronymic());
		ispolnitel.setPost(dto.getPost());
		ispolnitel.setSurname(dto.getSurname());
		ispolnitel.setFizInfo(fizInfoDao.get(dto.getFizInfoId()));
		if (dto.getUchStepeniIdArr()!=null){
			List<UchStepeni> uchStepeniList = new ArrayList<UchStepeni>();
			for (Integer i : dto.getUchStepeniIdArr()){
				uchStepeniList.add(uchStepeniDao.get(i));
			}
			ispolnitel.setUchStepeniList(uchStepeniList);
		}
		
		
		if (dto.getUchZvaniyIdArr()!=null){
			List<UchZvaniy> uchZvaniyList = new ArrayList<UchZvaniy>();
			for (Integer i : dto.getUchZvaniyIdArr()){
				uchZvaniyList.add(uchZvanieDao.get(i));
			}
			ispolnitel.setUchZvaniyList(uchZvaniyList);
		}
		
		ispolnitel.setZayavkaFI(zayavkaFIDao.get(dto.getZayavkaFIId()));
		baseDao.saveOrUpdate(ispolnitel);
		
	}
	public IspolnitelDTO getDTO(Integer id) throws DaoException{
		Ispolnitel ispl = baseDao.get(id);
		return new IspolnitelDTO(ispl, false);
	}
	public void edit(IspolnitelDTO dto) throws DaoException, ParseException{
		Ispolnitel entity = baseDao.get(dto.getId());
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//		entity.setBirthday(df.parse(dto.getBirthday()));
//		entity.setName(dto.getName());
//		entity.setPatronymic(dto.getPatronymic());
		entity.setPost(dto.getPost());
//		entity.setSurname(dto.getSurname());
		
		List<UchStepeni> uchStepeniList = new ArrayList<UchStepeni>();
		if (dto.getUchStepeniIdArr()!=null){
			for (Integer i : dto.getUchStepeniIdArr()){
				uchStepeniList.add(uchStepeniDao.get(i));
			}
		}
		entity.setUchStepeniList(uchStepeniList);
		List<UchZvaniy> uchZvaniyList = new ArrayList<UchZvaniy>();
		if (dto.getUchZvaniyIdArr()!=null){
			for (Integer i : dto.getUchZvaniyIdArr()){
				uchZvaniyList.add(uchZvanieDao.get(i));
			}
		}
		entity.setUchZvaniyList(uchZvaniyList);
		if (dto.getOrgId()!=null)
		entity.setOrg(orgDao.get(dto.getOrgId()));
		baseDao.update(entity);
	}

}
