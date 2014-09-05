package by.belisa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="RUKOVODITEL")
@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "zayavkaFI"))
public class Rukovoditel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5586880192718189825L;

	@Id
	@Column(name = "id")  
	@GeneratedValue(generator = "gen")  
	private Integer id;
	
	@Lob
	@Column(name="BIOGRAPHY")
	private String biography;
	
	@Column(name="FIO", length=60)
	private String fio;
	@Column(name="FIO_FULL", length=100)
	private String fullFio;
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
	
	@Column(name="COUNT_PUBLICATION_SCOPUS")
	private String countPublicationScopus;
	@Column(name="COUNT_PUBLICATION_ISI")
	private String countPublicationISI;
	@Column(name="COUNT_PUBLICATION_RINC")
	private String countPublicationRINC;
	
	@Column(name="CITATION_INDEX_SCOPUS")
	private String citationIndexScopus;
	@Column(name="CITATION_INDEX_ISI")
	private String citationIndexISI;
	@Column(name="CITATION_INDEX_RINC")
	private String citationIndexRINC;
	
	@Column(name="INDEX_WITHOUT_SELF_SCOPUS")
	private String indexWithoutSelfScopus;
	@Column(name="INDEX_WITHOUT_SELF_ISI")
	private String indexWithoutSelfISI;
	@Column(name="INDEX_WITHOUT_SELF_RINC")
	private String indexWithoutSelfRINC;
	
	@Column(name="INDEX_HIRSHA_SCOPUS")
	private String indexHirshaScopus;
	@Column(name="INDEX_HIRSHA_ISI")
	private String indexHirshaISI;
	@Column(name="INDEX_HIRSHA_RINC")
	private String indexHirshaRINC;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="RUKOVODITEL_ID")
	Set<Publication> publicationSet = new HashSet<Publication>();
	
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false)  
	@PrimaryKeyJoinColumn()
	private ZayavkaFI zayavkaFI;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public String getCountPublicationScopus() {
		return countPublicationScopus;
	}


	public void setCountPublicationScopus(String countPublicationScopus) {
		this.countPublicationScopus = countPublicationScopus;
	}


	public String getCountPublicationISI() {
		return countPublicationISI;
	}


	public void setCountPublicationISI(String countPublicationISI) {
		this.countPublicationISI = countPublicationISI;
	}


	public String getCountPublicationRINC() {
		return countPublicationRINC;
	}


	public void setCountPublicationRINC(String countPublicationRINC) {
		this.countPublicationRINC = countPublicationRINC;
	}


	public String getCitationIndexScopus() {
		return citationIndexScopus;
	}


	public void setCitationIndexScopus(String citationIndexScopus) {
		this.citationIndexScopus = citationIndexScopus;
	}


	public String getCitationIndexISI() {
		return citationIndexISI;
	}


	public void setCitationIndexISI(String citationIndexISI) {
		this.citationIndexISI = citationIndexISI;
	}


	public String getCitationIndexRINC() {
		return citationIndexRINC;
	}


	public void setCitationIndexRINC(String citationIndexRINC) {
		this.citationIndexRINC = citationIndexRINC;
	}


	public String getIndexWithoutSelfScopus() {
		return indexWithoutSelfScopus;
	}


	public void setIndexWithoutSelfScopus(String indexWithoutSelfScopus) {
		this.indexWithoutSelfScopus = indexWithoutSelfScopus;
	}


	public String getIndexWithoutSelfISI() {
		return indexWithoutSelfISI;
	}


	public void setIndexWithoutSelfISI(String indexWithoutSelfISI) {
		this.indexWithoutSelfISI = indexWithoutSelfISI;
	}


	public String getIndexWithoutSelfRINC() {
		return indexWithoutSelfRINC;
	}


	public void setIndexWithoutSelfRINC(String indexWithoutSelfRINC) {
		this.indexWithoutSelfRINC = indexWithoutSelfRINC;
	}


	public String getIndexHirshaScopus() {
		return indexHirshaScopus;
	}


	public void setIndexHirshaScopus(String indexHirshaScopus) {
		this.indexHirshaScopus = indexHirshaScopus;
	}


	public String getIndexHirshaISI() {
		return indexHirshaISI;
	}


	public void setIndexHirshaISI(String indexHirshaISI) {
		this.indexHirshaISI = indexHirshaISI;
	}


	public String getIndexHirshaRINC() {
		return indexHirshaRINC;
	}


	public void setIndexHirshaRINC(String indexHirshaRINC) {
		this.indexHirshaRINC = indexHirshaRINC;
	}


	public Set<Publication> getPublicationSet() {
		return publicationSet;
	}


	public void setPublicationSet(Set<Publication> publicationSet) {
		this.publicationSet = publicationSet;
	}


	public ZayavkaFI getZayavkaFI() {
		return zayavkaFI;
	}


	public void setZayavkaFI(ZayavkaFI zayavkaFI) {
		this.zayavkaFI = zayavkaFI;
	}
	
	
}
