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
String strUrl1 = "http://192.168.11.71:7001/xmlpserver/~administrator/fond/фундаментальных исследований/фундаментальных исследований.xdo?_xpf=&_xpt=0&_xdo=%2F~administrator%2Ffond%2F%D1%84%D1%83%D0%BD%D0%B4%D0%B0%D0%BC%D0%B5%D0%BD%D1%82%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D1%85%20%D0%B8%D1%81%D1%81%D0%BB%D0%B5%D0%B4%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B9%2F%D1%84%D1%83%D0%BD%D0%B4%D0%B0%D0%BC%D0%B5%D0%BD%D1%82%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D1%85%20%D0%B8%D1%81%D1%81%D0%BB%D0%B5%D0%B4%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B9.xdo&src=&_xt=New%20Template%201&_xf=html&_xmode=4";
String strUrl0 ="http://localhost:7080/manager/html";
String strUrl = "http://192.168.11.71:7001/xmlpserver/servlet/report?f=%2F~administrator%2Ffond";
		String name = "administrator";
		String password = "administrator";

		String authString = name + ":" + password;
		byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		String authStringEnc = new String(authEncBytes);
		URL url = new URL(strUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setDoInput (true);
//	    conn.setRequestMethod("POST");
	    conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
//	    conn.setDoOutput(true);
		
	    InputStream content = conn.getInputStream();
	    BufferedReader in = new BufferedReader(new InputStreamReader(content));
	    String line;
	    while ((line = in.readLine()) != null) {
	      System.out.println(line);
	    }
	    System.out.println("Done.");
	  }

	 
}
