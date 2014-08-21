package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="ORGANIZATION_NR")
@SequenceGenerator(name="PK", sequenceName="SEQ_ORG_NR")
public class OrganizationNR implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7010469087643920983L;
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@Column(name="NAME_R")
	private String nameR;
	@Column(name="NAME_E")
	private String nameE;
	@Column(name="KOD")
	private String code;
	@Column(name="FULL_NAME")
	private String fullName;
	@ManyToOne
	@JoinColumn(name="OKSM")
	private Oksm oksm;
	@Column(name="CITY")
	private String city;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="EMAIL")
	private String email;
	@ManyToOne
	@JoinColumn(name="VID_ORG_ID")
	private VidOrg vidOrg;
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
	public Oksm getOksm() {
		return oksm;
	}
	public void setOksm(Oksm oksm) {
		this.oksm = oksm;
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
	public VidOrg getVidOrg() {
		return vidOrg;
	}
	public void setVidOrg(VidOrg vidOrg) {
		this.vidOrg = vidOrg;
	}
	
	
	

}
