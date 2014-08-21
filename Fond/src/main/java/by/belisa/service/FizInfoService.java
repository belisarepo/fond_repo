package by.belisa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.IspolnitelDTO;
import by.belisa.dao.Dao;
import by.belisa.dao.FizInfoDao;
import by.belisa.dao.OrgDao;
import by.belisa.dao.UchStepeniDao;
import by.belisa.dao.UchZvanieDao;
import by.belisa.dao.ZayavkaFIDao;
import by.belisa.entity.FizInfo;
import by.belisa.entity.Ispolnitel;
import by.belisa.entity.ZayavkaFI;
import by.belisa.exception.DaoException;

@Service
public class FizInfoService extends ServiceImpl<FizInfo, Integer>{

	public FizInfoService() {
		super(FizInfo.class);
	}
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
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
	
	@Override
	@Autowired
	@Qualifier(value="fizInfoDao")
	protected void setBaseDao(Dao<FizInfo, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	public void addFizInfo(IspolnitelDTO dto) throws ParseException, DaoException{
		Date birthday = dateFormat.parse(dto.getBirthday());
		FizInfo fizInfo = fizInfoDao.getByFio(dto.getSurname(),dto.getName(),dto.getPatronymic(),birthday);
		if (fizInfo==null){
			fizInfo = new FizInfo();
			fizInfo.setBirthday(birthday);
			fizInfo.setSurname(dto.getSurname()+" "+dto.getName()+" "+dto.getPatronymic());
		}
		if (dto.getOrgId()!=null){
			fizInfo.setOrg(orgDao.get(dto.getOrgId()));
		}
		
		fizInfo.setPost(dto.getPost());
		if (dto.getUchStepeniId()!=null){
			fizInfo.setUchStepeni(uchStepeniDao.get(dto.getUchStepeniId()));
		}
		
		if (dto.getUchZvaniyId()!=null){
			fizInfo.setUchZvaniy(uchZvanieDao.get(dto.getUchZvaniyId()));
		}
		
		fizInfo.getZayavki().add(zayavkaFIDao.get(dto.getZayavkaFIId()));
		fizInfoDao.saveOrUpdate(fizInfo);
	}
	public void removeFizInfoFromZayavkaFI(Long userId, Integer konkursId, Ispolnitel ispolnitel) throws DaoException{
		ZayavkaFI zayavkaFI = zayavkaFIDao.getZayavkaFIByUserId(userId, konkursId);
		FizInfo fizInfo = fizInfoDao.getByFio(ispolnitel.getSurname(),ispolnitel.getName(),ispolnitel.getPatronymic(),ispolnitel.getBirthday());
		fizInfo.getZayavki().remove(zayavkaFI);
		fizInfoDao.saveOrUpdate(fizInfo);
	}

}
