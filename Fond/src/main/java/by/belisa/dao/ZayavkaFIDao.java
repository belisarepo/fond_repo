package by.belisa.dao;

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
		Query q = s.createQuery("FROM ZayavkaFI where anketa.id=:userId and konkursy.id=:konkursId");
		q.setParameter("userId", userId);
		q.setParameter("konkursId", konkursId);
		return (ZayavkaFI) q.uniqueResult();
	}

}
