package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="PUBLICATION_M")
@SequenceGenerator(name="PK",sequenceName="SEQ_PUBLICATION_M")
public class PublicationM implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7913926078472932495L;

	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	@Column(name="EDITION")
	private String edition; 
	@Column(name="PN")
	private int pn;
	@Column(name="PAGES")
	private int pages;
	@Column(name="AUTHORS")
	private String authors;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PUBLICATION_TYPE_ID")
	private PublicationType publicationType;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FIZ_INFO_ID")
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
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public int getPn() {
		return pn;
	}
	public void setPn(int pn) {
		this.pn = pn;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public PublicationType getPublicationType() {
		return publicationType;
	}
	public void setPublicationType(PublicationType publicationType) {
		this.publicationType = publicationType;
	}
	public FizInfo getFizInfo() {
		return fizInfo;
	}
	public void setFizInfo(FizInfo fizInfo) {
		this.fizInfo = fizInfo;
	}
	
}
