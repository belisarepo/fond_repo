package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="OKSM")
@SequenceGenerator(name="PK", sequenceName="SEQ_OKSM")
public class Oksm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5170263588969012320L;
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@Column(name="NAME_R")
	private String nameR;
	@Column(name="NAME_E")
	private String nameE;
	@Column(name="FULL_NAME")
	private String fullName;
	@Column(name="KOD")
	private String code;
	@Column(name="ALFA2")
	private String alfa2;
	@Column(name="ALFA3")
	private String alfa3;
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAlfa2() {
		return alfa2;
	}
	public void setAlfa2(String alfa2) {
		this.alfa2 = alfa2;
	}
	public String getAlfa3() {
		return alfa3;
	}
	public void setAlfa3(String alfa3) {
		this.alfa3 = alfa3;
	}

}
