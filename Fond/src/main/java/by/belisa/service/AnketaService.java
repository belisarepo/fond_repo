package by.belisa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.AnketaVO;
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
	
	public void saveOrUpdate(AnketaVO anketaVo) throws ParseException, DaoException, ServiceException{
		Anketa anketa = baseDao.get(anketaVo.getId());
		 if (anketa==null){
			 anketa = new Anketa();
		 }
		anketa.setAddress(anketaVo.getAddress());
		anketa.setBiography(anketaVo.getBiography());
		if (anketaVo.getBirthday()!=null && !anketaVo.getBirthday().isEmpty()){
			anketa.setBirthday(dateFormat.parse(anketaVo.getBirthday()));
		}
		anketa.setEmail(anketaVo.getEmail());
		anketa.setFio(anketaVo.getFio());
		anketa.setFullFio(anketaVo.getFullFio());
		anketa.setHomePhone(anketaVo.getHomePhone());
		anketa.setJobPhone(anketaVo.getJobPhone());
		anketa.setLab(anketaVo.getLab());
		anketa.setMobilePhone(anketaVo.getMobilePhone());
		anketa.setOrg(orgDao.get(anketaVo.getOrgId()));
		anketa.setPost(anketaVo.getPost());
		anketa.setUchStepeni(uchStepeniDao.get(anketaVo.getUchStepenId()));
		anketa.setUchZvanie(uchZvanieDao.get(anketaVo.getUchZvaniyId()));
		anketa.setUser(userDao.get(anketaVo.getId()));
		baseDao.saveOrUpdate(anketa);
	}
	
	public AnketaVO getVO(Long id) throws DaoException{
		Anketa anketa = baseDao.get(id);
		AnketaVO anketaVO = new AnketaVO(anketa);
		return anketaVO;
		
	}
	
	

}
