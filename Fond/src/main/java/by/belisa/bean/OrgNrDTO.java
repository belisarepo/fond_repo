package by.belisa.bean;

import java.io.Serializable;

import by.belisa.entity.OrganizationNR;

public class OrgNrDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3862905713083944707L;
	
	private Integer id;
	private String nameR;
	private String nameE;
	private String code;
	private String fullName;
	private String oksmName;
	private Integer oksmId;
	private String city;
	private String address;
	private String email;
	private String vidOrgName;
	private Integer vidOrgId;
	
	public OrgNrDTO(){
		
	}

	public OrgNrDTO(OrganizationNR entity) {
		super();
		this.id = entity.getId();
		this.nameR = entity.getNameR();
		this.nameE = entity.getNameE();
		this.code = entity.getCode();
		this.fullName = entity.getFullName();
		this.oksmName = entity.getOksm().getNameR();
		this.oksmId = entity.getOksm().getId();
		this.city = entity.getCity();
		this.address = entity.getAddress();
		this.email = entity.getEmail();
		this.vidOrgName = entity.getVidOrg()!=null ? entity.getVidOrg().getName() : "";
		this.vidOrgId = entity.getVidOrg()!=null ? entity.getVidOrg().getId() : null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getOksmName() {
		return oksmName;
	}

	public void setOksmName(String oksmName) {
		this.oksmName = oksmName;
	}

	public Integer getOksmId() {
		return oksmId;
	}

	public void setOksmId(Integer oksmId) {
		this.oksmId = oksmId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVidOrgName() {
		return vidOrgName;
	}

	public void setVidOrgName(String vidOrgName) {
		this.vidOrgName = vidOrgName;
	}

	public Integer getVidOrgId() {
		return vidOrgId;
	}

	public void setVidOrgId(Integer vidOrgId) {
		this.vidOrgId = vidOrgId;
	}
	

}
