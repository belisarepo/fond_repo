package by.belisa.dao;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import by.belisa.entity.Obosnovanie;

@Repository
public class ObosnovanieDao extends DaoImpl<Obosnovanie, Integer>{

	public ObosnovanieDao() {
		super(Obosnovanie.class);
	}
	public byte[] getFile(int id){
		Session s = getSession();
		SQLQuery q = s.createSQLQuery("select FULL_FILE as f from OBOSNOVANIE where ID=:id");
		q.addScalar("f", Hibernate.BINARY);
		q.setParameter("id", id);
		
	    return (byte[])q.uniqueResult();
	}

	public void deleteFile(Integer zayavkaId) {
		Session s = getSession();
		SQLQuery q = s.createSQLQuery("update OBOSNOVANIE set FILE_NAME='',FULL_FILE=null where ID=:id");
		q.setParameter("id", zayavkaId);
		q.executeUpdate();
		
	}

}
