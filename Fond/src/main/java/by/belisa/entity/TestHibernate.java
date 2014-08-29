package by.belisa.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

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
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Date str = new Date();
		String url = "jdbc:oracle:thin:@192.168.11.71:1521:OraLR";
		Connection c = DriverManager.getConnection(url, "fond", "fond");
//		String url = "jdbc:oracle:thin:@192.168.11.70:1521:OraBP";
//		Connection c = DriverManager.getConnection(url, "liferay", "liferay");
		Date fin = new Date();
		long time = fin.getTime()-str.getTime();
		System.out.println("connection is open "+ c+ "time: "+ time+" ms");
		
	}

}
