package by.belisa.dao;

import java.util.List;

import org.hibernate.Query;
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
	    Query q = s.createQuery("SELECT uslKonkursaR FROM Konkursy where id=:id");
	    q.setParameter("id", id);
	    return (byte[])q.uniqueResult();
	}
	public List<Konkursy> getActiveKonkursy(){
		Session s = getSession();
	    Query q = s.createQuery("FROM Konkursy where konkursStatus.id=:id");
	    q.setParameter("id", 4);
	    return q.list();
	}
}
