package by.belisa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import by.belisa.entity.Ispolnitel;
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
	
	public List<IspolnitelDTO> getAllDTO() throws DaoException{
		List<Ispolnitel> ispolnitelList = baseDao.getAll();
		List<IspolnitelDTO> ispolnitelDTOList = new ArrayList<IspolnitelDTO>();
		for (Ispolnitel i : ispolnitelList){
			ispolnitelDTOList.add(new IspolnitelDTO(i));
		}
		return ispolnitelDTOList;
	}
	
	public void addIspolnitel(IspolnitelDTO dto) throws ParseException, DaoException{
		Date birthday = dateFormat.parse(dto.getBirthday());
		Ispolnitel ispolnitel = new Ispolnitel();
		
	}
	

}
