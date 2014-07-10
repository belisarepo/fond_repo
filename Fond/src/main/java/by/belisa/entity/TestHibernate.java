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
		Transaction tr = null;
		try {
			tr = s.beginTransaction();
			User u = new User();
			Anketa a = new Anketa();
			a.setUser(u);
			u.setAnketa(a);
			s.save(u);
			System.out.println(((User)s.get(User.class, 200l)));
			
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
