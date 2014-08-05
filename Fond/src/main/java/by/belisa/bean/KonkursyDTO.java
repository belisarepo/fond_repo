package by.belisa.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import by.belisa.entity.Konkursy;


public class KonkursyDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5869839947719425834L;
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	private int id;
	private String tipKonkursaName;
	private int tipKonkursaId;
	private String descriptionR;
	private String descriptionE;
	private String nameR;
	private String nameE;
	private String yearKonkurs;
	private String prefixZR;
	private String prefixZE;
	private String formaZR;
	private String formaZE;
	private String reshenieNS;
	private String uslKonkursaR;
	private String uslKonkursaE;
	private String stopKonkurs;
	private String startProject;
	private String stopProject;
	private Integer countIspolnitel;
	private Integer countRukovoditel;
	private Integer countIspolRukov;
	
	public KonkursyDTO(){
		
	}
	
	public KonkursyDTO(Konkursy konkursy) {
		super();
		this.id = konkursy.getId();
		this.tipKonkursaName = konkursy.getTipKonkursa().getName();
		this.tipKonkursaId = konkursy.getTipKonkursa().getId();
		this.descriptionR = konkursy.getDescriptionR();
		this.descriptionE = konkursy.getDescriptionE();
		this.nameR = konkursy.getNameR();
		this.nameE = konkursy.getNameE();
		this.yearKonkurs = konkursy.getYearKonkurs();
		this.prefixZR = konkursy.getPrefixZR();
		this.prefixZE = konkursy.getPrefixZE();
		this.formaZR = konkursy.getFormaZR();
		this.formaZE = konkursy.getFormaZE();
		this.reshenieNS = konkursy.getReshenieNS();
		
		this.stopKonkurs = konkursy.getStopKonkurs()!=null ? dateFormat.format(konkursy.getStopKonkurs()): null;
		this.startProject = konkursy.getStartProject()!=null ? dateFormat.format(konkursy.getStartProject()): null;
		this.stopProject = konkursy.getStopProject()!=null ? dateFormat.format(konkursy.getStopProject()): null;
		this.countIspolnitel = konkursy.getCountIspolnitel();
		this.countRukovoditel = konkursy.getCountRukovoditel();
		this.countIspolRukov = konkursy.getCountIspolRukov();
	}

	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipKonkursaName() {
		return tipKonkursaName;
	}
	public void setTipKonkursaName(String tipKonkursaName) {
		this.tipKonkursaName = tipKonkursaName;
	}
	public int getTipKonkursaId() {
		return tipKonkursaId;
	}
	public void setTipKonkursaId(int tipKonkursaId) {
		this.tipKonkursaId = tipKonkursaId;
	}
	public String getDescriptionR() {
		return descriptionR;
	}
	public void setDescriptionR(String descriptionR) {
		this.descriptionR = descriptionR;
	}
	public String getDescriptionE() {
		return descriptionE;
	}
	public void setDescriptionE(String descriptionE) {
		this.descriptionE = descriptionE;
	}
	public String getNameR() {
		return nameR;
	}
	public void setNameR(String nameR) {
		this.nameR = nameR;
	}
	public String getNameE() {
		return nameE;
	}
	public void setNameE(String nameE) {
		this.nameE = nameE;
	}
	public String getYearKonkurs() {
		return yearKonkurs;
	}
	public void setYearKonkurs(String yearKonkurs) {
		this.yearKonkurs = yearKonkurs;
	}
	public String getPrefixZR() {
		return prefixZR;
	}
	public void setPrefixZR(String prefixZR) {
		this.prefixZR = prefixZR;
	}
	public String getPrefixZE() {
		return prefixZE;
	}
	public void setPrefixZE(String prefixZE) {
		this.prefixZE = prefixZE;
	}
	public String getFormaZR() {
		return formaZR;
	}
	public void setFormaZR(String formaZR) {
		this.formaZR = formaZR;
	}
	public String getFormaZE() {
		return formaZE;
	}
	public void setFormaZE(String formaZE) {
		this.formaZE = formaZE;
	}
	public String getReshenieNS() {
		return reshenieNS;
	}
	public void setReshenieNS(String reshenieNS) {
		this.reshenieNS = reshenieNS;
	}
	public String getUslKonkursaR() {
		return uslKonkursaR;
	}
	public void setUslKonkursaR(String uslKonkursaR) {
		this.uslKonkursaR = uslKonkursaR;
	}
	public String getUslKonkursaE() {
		return uslKonkursaE;
	}
	public void setUslKonkursaE(String uslKonkursaE) {
		this.uslKonkursaE = uslKonkursaE;
	}
	public String getStopKonkurs() {
		return stopKonkurs;
	}
	public void setStopKonkurs(String stopKonkurs) {
		this.stopKonkurs = stopKonkurs;
	}
	public String getStartProject() {
		return startProject;
	}
	public void setStartProject(String startProject) {
		this.startProject = startProject;
	}
	public String getStopProject() {
		return stopProject;
	}
	public void setStopProject(String stopProject) {
		this.stopProject = stopProject;
	}
	public Integer getCountIspolnitel() {
		return countIspolnitel;
	}
	public void setCountIspolnitel(Integer countIspolnitel) {
		this.countIspolnitel = countIspolnitel;
	}
	public Integer getCountRukovoditel() {
		return countRukovoditel;
	}
	public void setCountRukovoditel(Integer countRukovoditel) {
		this.countRukovoditel = countRukovoditel;
	}
	public Integer getCountIspolRukov() {
		return countIspolRukov;
	}
	public void setCountIspolRukov(Integer countIspolRukov) {
		this.countIspolRukov = countIspolRukov;
	}
	
	
}
