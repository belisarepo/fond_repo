package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.OrganizationNR;

@Repository
public class OrgNrDao extends DaoImpl<OrganizationNR, Integer>{

	public OrgNrDao() {
		super(OrganizationNR.class);
	}

}
