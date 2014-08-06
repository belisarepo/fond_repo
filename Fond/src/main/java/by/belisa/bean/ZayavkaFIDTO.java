package by.belisa.bean;

import java.io.Serializable;

import by.belisa.entity.ZayavkaFI;

public class ZayavkaFIDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2104550708006725459L;
	
	private int id;
	private String konkursNameR;
	private int konkursId;
	private String sectionFondNameR;
	private int sectionFondId;
	private String otraslNaukaName;
	private int otraslNaukaId;
	
	public ZayavkaFIDTO(){
		
	}
	public ZayavkaFIDTO(ZayavkaFI zayavkaFI){
		if (zayavkaFI!=null){
			this.id = zayavkaFI.getId();
			this.konkursId = zayavkaFI.getKonkursy().getId();
			this.konkursNameR = zayavkaFI.getKonkursy().getNameR();
			this.sectionFondId = zayavkaFI.getSectionFond().getId();
			this.sectionFondNameR = zayavkaFI.getSectionFond().getNameR();
			this.otraslNaukaId = zayavkaFI.getOtraslNauka().getId();
			this.otraslNaukaName = zayavkaFI.getOtraslNauka().getName();
		}
		
	}
	
	
	public String getOtraslNaukaName() {
		return otraslNaukaName;
	}
	public void setOtraslNaukaName(String otraslNaukaName) {
		this.otraslNaukaName = otraslNaukaName;
	}
	public int getOtraslNaukaId() {
		return otraslNaukaId;
	}
	public void setOtraslNaukaId(int otraslNaukaId) {
		this.otraslNaukaId = otraslNaukaId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKonkursNameR() {
		return konkursNameR;
	}
	public void setKonkursNameR(String konkursNameR) {
		this.konkursNameR = konkursNameR;
	}
	public int getKonkursId() {
		return konkursId;
	}
	public void setKonkursId(int konkursId) {
		this.konkursId = konkursId;
	}
	public String getSectionFondNameR() {
		return sectionFondNameR;
	}
	public void setSectionFondNameR(String sectionFondName) {
		this.sectionFondNameR = sectionFondName;
	}
	public int getSectionFondId() {
		return sectionFondId;
	}
	public void setSectionFondId(int sectionFondId) {
		this.sectionFondId = sectionFondId;
	}
	

}
