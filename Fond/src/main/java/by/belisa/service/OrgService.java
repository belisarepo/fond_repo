package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.Organization;
@Service
public class OrgService extends ServiceImpl<Organization, Integer>{

	public OrgService() {
		super(Organization.class);
	}
	
	@Override
	@Autowired
	@Qualifier("orgDao")
	protected void setBaseDao(Dao<Organization, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

}
