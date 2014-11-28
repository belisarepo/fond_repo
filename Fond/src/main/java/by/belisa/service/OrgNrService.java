package by.belisa.service;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.OrgNrDTO;
import by.belisa.dao.Dao;
import by.belisa.dao.KonkursyDao;
import by.belisa.entity.OrganizationNR;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;

@Service
public class OrgNrService extends ServiceImpl<OrganizationNR, Integer>{

	public OrgNrService() {
		super(OrganizationNR.class);
	}

	@Autowired
	@Qualifier(value="konkursyDao")
	private KonkursyDao konkursyDao;
	
	@Override
	@Autowired
	@Qualifier(value="orgNrDao")
	protected void setBaseDao(Dao<OrganizationNR, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	public List<OrganizationNR> getAllByKonkurs(Integer konkursId) throws DaoException{
		Integer countryId = konkursyDao.get(konkursId).getCountryId();
		if (countryId==null){
			return baseDao.getAll();
		}
		return baseDao.getList(new Criterion[]{Restrictions.eq("oksm.id", countryId)});
	}

	public OrgNrDTO getOrgNrDTOById(Integer id) throws ServiceException {
		try {
			return new OrgNrDTO(baseDao.get(id));
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

}
