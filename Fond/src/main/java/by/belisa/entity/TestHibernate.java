package by.belisa.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import by.belisa.validation.ValidationResult;

public class TestHibernate {
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
//		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
//		Session s = sf.openSession();
//		Transaction tr = s.getTransaction();
//		try {
//			tr.begin();
//			FizInfo fi = new FizInfo();
//			ZayavkaFI z = new ZayavkaFI();
//			fi.getZayavki().add(z);
//			s.saveOrUpdate(fi);
////			One o = new One();
////			Two t = new Two();
////			t.getOneSet().add(o);
////			s.saveOrUpdate(t);
//			tr.commit();
//		} catch (HibernateException e) {
//			tr.rollback();
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally{
//			s.close();
//		}
//		
		ValidationResult vr=null;
		vr.getErrMessages();
		String str=null;
		System.out.println(str);
		
	}

}
