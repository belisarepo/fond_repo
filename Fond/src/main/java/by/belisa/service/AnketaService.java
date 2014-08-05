package by.belisa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.AnketaDTO;
import by.belisa.dao.Dao;
import by.belisa.dao.OrgDao;
import by.belisa.dao.UchStepeniDao;
import by.belisa.dao.UchZvanieDao;
import by.belisa.dao.UserDao;
import by.belisa.entity.Anketa;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;
@Service
public class AnketaService extends ServiceImpl<Anketa,Long>{
	
	public AnketaService() {
		super(Anketa.class);
	}
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
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
	@Qualifier("anketaDao")
	protected void setBaseDao(Dao<Anketa, Long> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	public void saveOrUpdate(AnketaDTO anketaDTO) throws ParseException, DaoException, ServiceException{
		Anketa anketa = baseDao.get(anketaDTO.getId());
		 if (anketa==null){
			 anketa = new Anketa();
		 }
		anketa.setAddress(anketaDTO.getAddress());
		anketa.setBiography(anketaDTO.getBiography());
		if (anketaDTO.getBirthday()!=null && !anketaDTO.getBirthday().isEmpty()){
			anketa.setBirthday(dateFormat.parse(anketaDTO.getBirthday()));
		}
		anketa.setEmail(anketaDTO.getEmail());
		anketa.setFio(anketaDTO.getFio());
		anketa.setFullFio(anketaDTO.getFullFio());
		anketa.setHomePhone(anketaDTO.getHomePhone());
		anketa.setJobPhone(anketaDTO.getJobPhone());
		anketa.setLab(anketaDTO.getLab());
		anketa.setMobilePhone(anketaDTO.getMobilePhone());
		anketa.setOrg(orgDao.get(anketaDTO.getOrgId()));
		anketa.setPost(anketaDTO.getPost());
		anketa.setUchStepeni(uchStepeniDao.get(anketaDTO.getUchStepenId()));
		anketa.setUchZvanie(uchZvanieDao.get(anketaDTO.getUchZvaniyId()));
		anketa.setUser(userDao.get(anketaDTO.getId()));
		baseDao.saveOrUpdate(anketa);
	}
	
	public AnketaDTO getVO(Long id) throws DaoException{
		Anketa anketa = baseDao.get(id);
		AnketaDTO anketaDTO = new AnketaDTO(anketa);
		return anketaDTO;
		
	}
	
	

}
