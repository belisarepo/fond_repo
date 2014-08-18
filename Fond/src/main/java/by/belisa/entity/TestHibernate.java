package by.belisa.entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class TestHibernate {
	
	public static void main(String args[]){
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		try {
			tr.begin();
			FizInfo fi = new FizInfo();
			ZayavkaFI z = new ZayavkaFI();
			fi.getZayavki().add(z);
			s.saveOrUpdate(fi);
//			One o = new One();
//			Two t = new Two();
//			t.getOneSet().add(o);
//			s.saveOrUpdate(t);
			tr.commit();
		} catch (HibernateException e) {
			tr.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			s.close();
		}
		
		
	}

}
