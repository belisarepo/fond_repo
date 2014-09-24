package by.belisa.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import by.belisa.entity.Konkursy;

@Repository
public class KonkursyDao extends DaoImpl<Konkursy, Integer> {

	public KonkursyDao() {
		super(Konkursy.class);
	}
	
	public byte[] getUsloviy(int id){
		Session s = getSession();
//	    Query q = s.createQuery("SELECT uslKonkursaR FROM Konkursy where id=:id");
//	    q.setParameter("id", id);
//	    return (byte[])q.uniqueResult();
		SQLQuery q = s.createSQLQuery("select USL_KONKURSA_R as usl from KONKURSY where ID=:id");
		q.addScalar("usl", Hibernate.BINARY);
		q.setParameter("id", id);
		
	    return (byte[])q.uniqueResult();
	}
	public List<Konkursy> getActiveKonkursy(){
		Session s = getSession();
	    Query q = s.createQuery("FROM Konkursy where konkursStatus.id=:id");
	    q.setParameter("id", 4);
	    return q.list();
	}
	public List<Konkursy> getActiveKonkursy(int page){
		Session s = getSession();
	    Query q = s.createQuery("FROM Konkursy where konkursStatus.id=:id");
	    q.setParameter("id", 4);
	    q.setFirstResult((page-1)*3);
	    q.setMaxResults(3);
	    return q.list();
	}
}
