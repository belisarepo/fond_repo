 package by.belisa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import by.belisa.validation.IValidaton;
import by.belisa.validation.ValidationResult;

@Entity
@Table(name="ANKETA")
public class Anketa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4443436266052344647L;
	
	public Anketa(){
		
	}
	public Anketa(Long id){
		this.id = id;
	}
	@Id
	@Column(name = "id")  
	@GeneratedValue(generator = "gen")  
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	private Long id;
	@Column(name="FIO", length=60)
	private String fio;
	@Column(name="FIO_FULL", length=100)
	private String fullFio;
	@Column(name="NAME")
	private String name;
	@Column(name="SURNAME")
	private String surname;
	@Column(name="PATRONYMIC")
	private String patronymic;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORG_ID")
	private Organization org;
	@Column(name="BIRTHDAY", columnDefinition="DATE")
	private Date birthday;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="UCH_STEPENI_ID")
	private UchStepeni uchStepeni;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UCH_ZVANIY_ID")
	private UchZvaniy uchZvaniy;
	@Column(name="POST")
	private String post;
	@Column(name="LAB")
	private String lab;
	@Column(name="JOB_PHONE")
	private String jobPhone;
	@Column(name="HOME_PHONE")
	private String homePhone;
	@Column(name="MOBILE_PHONE")
	private String mobilePhone;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="EMAIL")
	private String email;
	@Lob
	@Column(name="BIOGRAPHY")
	private String biography;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false)  
	@PrimaryKeyJoinColumn()
	private User user;
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public String getFullFio() {
		return fullFio;
	}
	public void setFullFio(String fullFio) {
		this.fullFio = fullFio;
	}
	public Organization getOrg() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org = org;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public UchStepeni getUchStepeni() {
		return uchStepeni;
	}
	public void setUchStepeni(UchStepeni uchStepeni) {
		this.uchStepeni = uchStepeni;
	}
	public UchZvaniy getUchZvanie() {
		return uchZvaniy;
	}
	public void setUchZvanie(UchZvaniy uchZvanie) {
		this.uchZvaniy = uchZvanie;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getLab() {
		return lab;
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	public String getJobPhone() {
		return jobPhone;
	}
	public void setJobPhone(String jobPhone) {
		this.jobPhone = jobPhone;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
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
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public String getFio() {
		return fio;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}
	public Long getId() {
		return id;
	}
	public UchZvaniy getUchZvaniy() {
		return uchZvaniy;
	}
	public void setUchZvaniy(UchZvaniy uchZvaniy) {
		this.uchZvaniy = uchZvaniy;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
