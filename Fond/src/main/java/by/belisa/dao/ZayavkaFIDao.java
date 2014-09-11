package by.belisa.dao;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import by.belisa.entity.ZayavkaFI;
@Repository
public class ZayavkaFIDao extends DaoImpl<ZayavkaFI, Integer>{

	public ZayavkaFIDao() {
		super(ZayavkaFI.class);
	}
	
	public ZayavkaFI getZayavkaFIByUserId(long userId,int konkursId){
		Session s = getSession();
		Query q = s.createQuery("FROM ZayavkaFI WHERE anketa.id=:userId and konkursy.id=:konkursId");
		q.setParameter("userId", userId);
		q.setParameter("konkursId", konkursId);
		return (ZayavkaFI) q.uniqueResult();
	}
	
	public long getActualCountAsRukByUser(Integer fizInfoId, Date startProject){
		Date today = new Date();
		Date futureDate = new Date(today.getTime() + 100l * 365l * 24l * 60l * 60l * 1000l);
		Session s = getSession();
		Query q = s.createQuery("SELECT count(*) FROM ZayavkaFI WHERE fizInfo.id=:fizInfoId and coalesce(konkursy.tipKonkursa.finRazdel.id,0)<>1 and coalesce(konkursy.stopProject,:futureDate)>=coalesce(:startProject,:today)");
		q.setParameter("fizInfoId", fizInfoId);
		q.setDate("startProject", startProject);
		q.setDate("today", today);
		q.setDate("futureDate", futureDate);
		long count = (Long) q.uniqueResult();
		return count;
	}
	
	public long getActualCountAsIspolnitelByUser(Integer fizInfoId, Date startProject){
		Date today = new Date();
		Date futureDate = new Date(today.getTime() + 100l * 365l * 24l * 60l * 60l * 1000l);
		Session s = getSession();
		Query q = s.createQuery("SELECT count(*) FROM FizInfo f join f.zayavki z WHERE f.id=:fizInfoId and coalesce(z.konkursy.tipKonkursa.finRazdel.id,0)<>1 and coalesce(z.konkursy.stopProject,:futureDate)>=coalesce(:startProject,:today)");
		q.setParameter("fizInfoId", fizInfoId);
		q.setDate("startProject", startProject);
		q.setDate("today", today);
		q.setDate("futureDate", futureDate);
		long count = (Long) q.uniqueResult();
		return count;
	}
	
	public long getActualCountByKonkursType(Integer fizInfoId, Integer tipKonkursaId, Date startProject, Integer limitCount){
		Date today = new Date();
		Date futureDate = new Date(today.getTime() + 100l * 365l * 24l * 60l * 60l * 1000l);
		Session s = getSession();
		Query q1 = s.createQuery("SELECT count(*) FROM ZayavkaFI WHERE fizInfo.id=:fizInfoId and coalesce(z.konkursy.tipKonkursa.id,0)=:tipKonkursaId and coalesce(konkursy.tipKonkursa.finRazdel.id,0)<>1 and coalesce(konkursy.stopProject,:futureDate)>=coalesce(:startProject,:today)");
		q1.setParameter("fizInfoId", fizInfoId);
		q1.setParameter("tipKonkursaId", tipKonkursaId);
		q1.setDate("startProject", startProject);
		q1.setDate("today", today);
		q1.setDate("futureDate", futureDate);
		long count = (Long) q1.uniqueResult();
		if (count<limitCount){
			Query q2 = s.createQuery("SELECT count(*) FROM FizInfo f join f.zayavki z WHERE f.id=:fizInfoId and coalesce(z.konkursy.tipKonkursa.id,0)=:tipKonkursaId and coalesce(z.konkursy.tipKonkursa.finRazdel.id,0)<>1 and coalesce(z.konkursy.stopProject,:futureDate)>=coalesce(:startProject,:today)");
			q2.setParameter("fizInfoId", fizInfoId);
			q2.setParameter("tipKonkursaId", tipKonkursaId);
			q2.setDate("startProject", startProject);
			q2.setDate("today", today);
			q2.setDate("futureDate", futureDate);
			count = count + (Long) q2.uniqueResult();
		}
		return count;
	}

}
