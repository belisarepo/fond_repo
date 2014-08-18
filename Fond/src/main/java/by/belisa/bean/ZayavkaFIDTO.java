package by.belisa.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import by.belisa.entity.FizInfo;
import by.belisa.entity.ZayavkaFI;

public class ZayavkaFIDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2104550708006725459L;

	private Integer id;
	private String konkursNameR;
	private int konkursId;
	private String sectionFondNameR;
	private int sectionFondId;
	private String otraslNaukaName;
	private int otraslNaukaId;
	private String prioritetNaukaName;
	private int prioritetNaukaId;
	private Long userId;
	private String temaName;
	private String orgName;
	private Integer orgId;
	private Set<IspolnitelDTO> ispolniteliDTO = new HashSet<IspolnitelDTO>();

	public ZayavkaFIDTO() {

	}

	public ZayavkaFIDTO(ZayavkaFI zayavkaFI) {
		if (zayavkaFI != null) {
			this.id = zayavkaFI.getId();
			this.konkursId = zayavkaFI.getKonkursy() != null ? zayavkaFI.getKonkursy().getId() : 0;
			this.konkursNameR = zayavkaFI.getKonkursy() != null ? zayavkaFI.getKonkursy().getNameR() : "";
			this.sectionFondId = zayavkaFI.getSectionFond() != null ? zayavkaFI.getSectionFond().getId() : 0;
			this.sectionFondNameR = zayavkaFI.getSectionFond() != null ? zayavkaFI.getSectionFond().getNameR() : "";
			this.otraslNaukaId = zayavkaFI.getOtraslNauka() != null ? zayavkaFI.getOtraslNauka().getId() : 0;
			this.otraslNaukaName = zayavkaFI.getOtraslNauka() != null ? zayavkaFI.getOtraslNauka().getName() : "";
			this.prioritetNaukaId = zayavkaFI.getPrioritetNauka() != null ? zayavkaFI.getPrioritetNauka().getId() : 0;
			this.prioritetNaukaName = zayavkaFI.getPrioritetNauka() != null ? zayavkaFI.getPrioritetNauka().getName() : "";
			this.userId = zayavkaFI.getAnketa() !=null ? zayavkaFI.getAnketa().getId() : null;
			this.temaName = zayavkaFI.getTemaZName();
			this.orgId = zayavkaFI.getOrganization() != null ? zayavkaFI.getOrganization().getId() : null;
			this.orgName = zayavkaFI.getOrganization() != null ? zayavkaFI.getOrganization().getName() : "";
		}

	}

	

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getTemaName() {
		return temaName;
	}

	public void setTemaName(String temaName) {
		this.temaName = temaName;
	}

	public String getPrioritetNaukaName() {
		return prioritetNaukaName;
	}

	public void setPrioritetNaukaName(String prioritetNaukaName) {
		this.prioritetNaukaName = prioritetNaukaName;
	}

	public int getPrioritetNaukaId() {
		return prioritetNaukaId;
	}

	public void setPrioritetNaukaId(int prioritetNaukaId) {
		this.prioritetNaukaId = prioritetNaukaId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
