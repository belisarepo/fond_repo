package by.belisa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="ISPOLNITELI")
@GenericGenerator(name="PK",strategy = "foreign", parameters = @Parameter(name = "property", value = "fizInfo"))
public class Ispolnitel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3916782444397278516L;
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@Column(name="NAME")
	private String name;
	@Column(name="SURNAME")
	private String surname;
	@Column(name="PATRONYMIC")
	private String patronymic;
	@Column(name="BIRTHDAY",columnDefinition="DATE")
	private Date birthday;
	@ManyToOne
	@JoinColumn(name="ORG_ID")
	private Organization org;
	@ManyToMany
	@JoinTable(name="ISPOLNITEL_UCH_STEPENI")
	private List<UchStepeni> uchStepeniList = new ArrayList<UchStepeni>();
	@ManyToMany
	@JoinTable(name="ISPOLNITEL_UCH_ZVANIY")
	private List<UchZvaniy> uchZvaniyList = new ArrayList<UchZvaniy>();
	@Column(name="POST")
	private String post;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ZAYAVKA_FI_ID")
	private ZayavkaFI zayavkaFI;
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	@PrimaryKeyJoinColumn()
	private FizInfo fizInfo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Organization getOrg() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org = org;
	}
	
	public List<UchStepeni> getUchStepeniList() {
		return uchStepeniList;
	}
	public void setUchStepeniList(List<UchStepeni> uchStepeniList) {
		this.uchStepeniList = uchStepeniList;
	}
	public List<UchZvaniy> getUchZvaniyList() {
		return uchZvaniyList;
	}
	public void setUchZvaniyList(List<UchZvaniy> uchZvaniyList) {
		this.uchZvaniyList = uchZvaniyList;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public ZayavkaFI getZayavkaFI() {
		return zayavkaFI;
	}
	public void setZayavkaFI(ZayavkaFI zayavkaFI) {
		this.zayavkaFI = zayavkaFI;
	}
	public FizInfo getFizInfo() {
		return fizInfo;
	}
	public void setFizInfo(FizInfo fizInfo) {
		this.fizInfo = fizInfo;
	}
	
	

}
