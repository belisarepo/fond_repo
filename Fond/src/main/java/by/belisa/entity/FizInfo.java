package by.belisa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="FIZ_INFO")
@SequenceGenerator(name="PK", sequenceName="SEQ_FIZ_INFO")

public class FizInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@Column(name="SURNAME")
	private String surname;
	@Column(name="DATE_BIRTH", columnDefinition="DATE")
	private Date birthday;
	@ManyToOne
	@JoinColumn(name="ORGANIZATION_ID")
	private Organization org;
	@ManyToOne
	@JoinColumn(name="UCH_STEPENI_ID")
	private UchStepeni uchStepeni;
	@ManyToOne
	@JoinColumn(name="UCH_ZVANIY_ID")
	private UchZvaniy uchZvaniy;
	@Column(name="POST")
	private String post;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="ZAYAVKA_FI_FIZ_INFO", 
                joinColumns={@JoinColumn(name="FIZ_INFO_ID")}, 
                inverseJoinColumns={@JoinColumn(name="ZAYAVKA_FI_ID")})
	private Set<ZayavkaFI> zayavki = new HashSet<ZayavkaFI>();
	
	@OneToMany(mappedBy="fizInfo")
	private Set<ZayavkaFI> zayavkiAsRuk = new HashSet<ZayavkaFI>();
	
	public Set<ZayavkaFI> getZayavki() {
		return zayavki;
	}
	public void setZayavki(Set<ZayavkaFI> zayavki) {
		this.zayavki = zayavki;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
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
	public UchStepeni getUchStepeni() {
		return uchStepeni;
	}
	public void setUchStepeni(UchStepeni uchStepeni) {
		this.uchStepeni = uchStepeni;
	}
	public UchZvaniy getUchZvaniy() {
		return uchZvaniy;
	}
	public void setUchZvaniy(UchZvaniy uchZvaniy) {
		this.uchZvaniy = uchZvaniy;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Set<ZayavkaFI> getZayavkiAsRuk() {
		return zayavkiAsRuk;
	}
	public void setZayavkiAsRuk(Set<ZayavkaFI> zayavkiAsRuk) {
		this.zayavkiAsRuk = zayavkiAsRuk;
	}
	
	
	
	
}
