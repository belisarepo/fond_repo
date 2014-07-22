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
//			User u = new User();
//			Anketa a = new Anketa();
//			a.setUser(u);
//			u.setAnketa(a);
//			s.save(a);
//			System.out.println(((Anketa)s.get(Anketa.class, 4050l)));
			
			
//			TipKonkursa t = new TipKonkursa();
//			t.setDescription("texttexttexttexttextetxtetxtetxtextetxtetxtetxte");
//			t.setFinRazdel((FinRazdel)s.get(FinRazdel.class, 1));
//			t.setName("name");
//			t.setOldCode("00");
//			t.setVidKonkursa((VidKonkursa)s.get(VidKonkursa.class, 1));
//			s.save(t);
//			System.out.println(((TipKonkursa)s.get(TipKonkursa.class, 50)).getVidKonkursa());
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
