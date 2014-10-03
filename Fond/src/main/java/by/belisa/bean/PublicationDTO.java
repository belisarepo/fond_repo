package by.belisa.bean;

import java.io.Serializable;

import by.belisa.entity.Publication;

public class PublicationDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4123199470716392110L;
	
	private Integer id;
	private String name;
	private String edition;
	private String authors;
	private String citationIndex;
	private String database;
	
	
	public PublicationDTO(Integer id, String name, String edition, String authors, String citationIndex, String database) {
		super();
		this.id = id;
		this.name = name;
		this.edition = edition;
		this.authors = authors;
		this.citationIndex = citationIndex;
		this.database = database;
	}
	public PublicationDTO(Publication publ) {
		super();
		this.id = publ.getId();
		this.name = publ.getName();
		this.edition = publ.getEdition();
		this.authors = publ.getAuthors();
		this.citationIndex = publ.getCitationIndex();
		this.database = publ.getDatabase();
	}
	public PublicationDTO() {
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
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getCitationIndex() {
		return citationIndex;
	}
	public void setCitationIndex(String citationIndex) {
		this.citationIndex = citationIndex;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	
	

}
