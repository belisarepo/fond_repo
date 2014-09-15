package by.belisa.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CheckUslResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5030360974039190909L;
	
	private Map<String,String> konkursRuk = new HashMap<String,String>();
	
	
	
	public CheckUslResult() {
	}
	public boolean isAvailable() {
		return konkursRuk.isEmpty();
	}
	public Map<String, String> getKonkursRuk() {
		return konkursRuk;
	}
	public void setKonkursRuk(Map<String, String> konkursRuk) {
		this.konkursRuk = konkursRuk;
	}
	
	
	
}
