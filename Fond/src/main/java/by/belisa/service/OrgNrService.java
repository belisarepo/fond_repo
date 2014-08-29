package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.OrganizationNR;

@Service
public class OrgNrService extends ServiceImpl<OrganizationNR, Integer>{

	public OrgNrService() {
		super(OrganizationNR.class);
	}

	@Override
	@Autowired
	@Qualifier(value="orgNrDao")
	protected void setBaseDao(Dao<OrganizationNR, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

}
