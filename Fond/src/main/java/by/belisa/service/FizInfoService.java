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
import by.belisa.entity.FizInfo;
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
		fizInfo.setOrg(orgDao.get(dto.getOrgId()));
		fizInfo.setPost(dto.getPost());
		fizInfo.setUchStepeni(uchStepeniDao.get(dto.getUchStepeniId()));
		fizInfo.setUchZvaniy(uchZvanieDao.get(dto.getUchZvaniyId()));
		fizInfoDao.saveOrUpdate(fizInfo);
	}
	

}
