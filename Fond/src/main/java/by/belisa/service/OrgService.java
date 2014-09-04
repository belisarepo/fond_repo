package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.OrgDTO;
import by.belisa.dao.Dao;
import by.belisa.dao.ZayavkaFIDao;
import by.belisa.entity.Organization;
import by.belisa.exception.DaoException;
@Service
public class OrgService extends ServiceImpl<Organization, Integer>{

	public OrgService() {
		super(Organization.class);
	}
	@Autowired
	@Qualifier(value="zayavkaFIDao")
	private ZayavkaFIDao zayavkaFIDao;
	
	@Override
	@Autowired
	@Qualifier("orgDao")
	protected void setBaseDao(Dao<Organization, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	public OrgDTO getOrgDTOById(Integer id) throws DaoException{
		return new OrgDTO(baseDao.get(id)); 
	}
	
	public void addSoOrg(Integer orgId, Integer zayavkaId) throws DaoException{
		Organization soOrg = baseDao.get(orgId);
		soOrg.getZayavki().add(zayavkaFIDao.get(zayavkaId));
		baseDao.update(soOrg);
	}
	
	public void deleteSoOrg(Integer orgId, Integer zayavkaId) throws DaoException{
		Organization soOrg = baseDao.get(orgId);
		soOrg.getZayavki().remove(zayavkaFIDao.get(zayavkaId));
		baseDao.update(soOrg);
	}

}
