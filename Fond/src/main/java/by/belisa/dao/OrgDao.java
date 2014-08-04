package by.belisa.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import by.belisa.entity.Organization;
@Repository
public class OrgDao extends DaoImpl<Organization, Integer>{
	private static Logger log = Logger.getLogger(OrgDao.class);
	public OrgDao() {
		super(Organization.class);
	}

	
}
