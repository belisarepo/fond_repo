package by.belisa.bean;

import java.io.Serializable;

import by.belisa.entity.PublicationM;

public class PublicationMDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7756808625910069027L;
	
	private Integer id;
	private String name;
	private String edition; 
	private int pn;
	private int pages;
	private String authors;
	private String publicationTypeName;
	private Integer publicationTypeId;
	private Integer fizInfoId;
	
	public PublicationMDTO(){
		
	}
	
	
	public PublicationMDTO(PublicationM publM) {
		this.id = publM.getId();
		this.name = publM.getName();
		this.edition = publM.getEdition();
		this.pn = publM.getPn();
		this.pages = publM.getPages();
		this.authors = publM.getAuthors();
		this.publicationTypeName = publM.getPublicationType().getName();
		this.publicationTypeId = publM.getPublicationType().getId();
		this.fizInfoId = publM.getFizInfo().getId();
	}


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
	public String getPublicationTypeName() {
		return publicationTypeName;
	}
	public void setPublicationTypeName(String publicationTypeName) {
		this.publicationTypeName = publicationTypeName;
	}
	public Integer getPublicationTypeId() {
		return publicationTypeId;
	}
	public void setPublicationTypeId(Integer publicationTypeId) {
		this.publicationTypeId = publicationTypeId;
	}


	public Integer getFizInfoId() {
		return fizInfoId;
	}


	public void setFizInfoId(Integer fizInfoId) {
		this.fizInfoId = fizInfoId;
	}
	
	

}
