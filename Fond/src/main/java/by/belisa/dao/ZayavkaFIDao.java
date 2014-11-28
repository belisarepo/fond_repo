package by.belisa.dao;

import java.util.Date;
import java.util.List;
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
	
	public List<ZayavkaFI> getActualAsRukByUser(Integer fizInfoId, Date startProject){
		Date today = new Date();
		Date futureDate = new Date(today.getTime() + 100l * 365l * 24l * 60l * 60l * 1000l);
		Session s = getSession();
		Query q = s.createQuery("FROM ZayavkaFI WHERE fizInfo.id=:fizInfoId and coalesce(konkursy.countIspolRukov,0)<>0 and coalesce(konkursy.stopProject,:futureDate)>=coalesce(:startProject,:today)");
		q.setParameter("fizInfoId", fizInfoId);
		q.setDate("startProject", startProject);
		q.setDate("today", today);
		q.setDate("futureDate", futureDate);
		List<ZayavkaFI> list = (List<ZayavkaFI>) q.list();
		return list;
	}
	
	public List<ZayavkaFI> getActualAsIspolnitelByUser(Integer fizInfoId, Date startProject){
		Date today = new Date();
		Date futureDate = new Date(today.getTime() + 100l * 365l * 24l * 60l * 60l * 1000l);
		Session s = getSession();
		Query q = s.createQuery("SELECT z FROM FizInfo f join f.zayavki z WHERE f.id=:fizInfoId and coalesce(z.konkursy.countIspolRukov,0)<>0 and coalesce(z.konkursy.stopProject,:futureDate)>=coalesce(:startProject,:today)");
		q.setParameter("fizInfoId", fizInfoId);
		q.setDate("startProject", startProject);
		q.setDate("today", today);
		q.setDate("futureDate", futureDate);
		List<ZayavkaFI> list = (List<ZayavkaFI>) q.list();
		return list;
	}
	
	public List<ZayavkaFI> getActualByKonkursType(Integer fizInfoId, Integer tipKonkursaId, Date startProject){
		Date today = new Date();
		Date futureDate = new Date(today.getTime() + 100l * 365l * 24l * 60l * 60l * 1000l);
		Session s = getSession();
		Query q1 = s.createQuery("FROM ZayavkaFI WHERE fizInfo.id=:fizInfoId and coalesce(konkursy.tipKonkursa.id,0)=:tipKonkursaId and coalesce(konkursy.stopProject,:futureDate)>=coalesce(:startProject,:today)");
		q1.setParameter("fizInfoId", fizInfoId);
		q1.setParameter("tipKonkursaId", tipKonkursaId);
		q1.setDate("startProject", startProject);
		q1.setDate("today", today);
		q1.setDate("futureDate", futureDate);
		List<ZayavkaFI> list = (List<ZayavkaFI>) q1.list();
		
		Query q2 = s.createQuery("SELECT z FROM FizInfo f join f.zayavki z WHERE f.id=:fizInfoId and coalesce(z.konkursy.tipKonkursa.id,0)=:tipKonkursaId and coalesce(z.konkursy.stopProject,:futureDate)>=coalesce(:startProject,:today)");
		q2.setParameter("fizInfoId", fizInfoId);
		q2.setParameter("tipKonkursaId", tipKonkursaId);
		q2.setDate("startProject", startProject);
		q2.setDate("today", today);
		q2.setDate("futureDate", futureDate);
		list.addAll((List<ZayavkaFI>)q2.list());
			
		return list;
	}
	
	public List<ZayavkaFI> getAllTimeByKonkursType(Integer fizInfoId, Integer tipKonkursaId){
		Session s = getSession();
		Query q = s.createQuery("FROM ZayavkaFI WHERE fizInfo.id=:fizInfoId and coalesce(konkursy.tipKonkursa.id,0)=:tipKonkursaId");
		q.setParameter("fizInfoId", fizInfoId);
		q.setParameter("tipKonkursaId", tipKonkursaId);
		List<ZayavkaFI> list = (List<ZayavkaFI>)q.list();
		
		return list;
	}

	public List<Object[]> getUserZayavki(Long userId) {
		Session s = getSession();
		Query q = s.createQuery("SELECT id, konkursy.nameR,statusZayavkaFI.name FROM ZayavkaFI WHERE anketa.id=:userId");
		q.setParameter("userId", userId);
		List<Object[]> list = q.list();
		return list;
	}
	
	public List<ZayavkaFI> getAllByKonkursId(int id){
		Session s = getSession();
		Query q = s.createQuery("FROM ZayavkaFI WHERE konkursy.id=:konkursId");
		q.setParameter("konkursId", id);
		return q.list();
	}

}
