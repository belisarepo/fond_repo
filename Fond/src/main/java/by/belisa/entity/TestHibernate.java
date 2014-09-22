package by.belisa.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;

import org.apache.commons.codec.binary.Base64;

public class TestHibernate {
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException{
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
		
		
		System.out.println("<a href=\"/c/portal/logout \">Выйти</a>");
	}
	

	 
}
