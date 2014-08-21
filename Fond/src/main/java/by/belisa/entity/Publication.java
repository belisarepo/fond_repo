package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PUBLICATION")
@SequenceGenerator(name="PK",sequenceName="SEQ_PUBLICATION")
public class Publication implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6077127533139433317L;
	
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	@Column(name="EDITION")
	private String edition;
	@Column(name="AUTHORS")
	private String authors;
	@Column(name="CITATION_INDEX")
	private String citationIndex;
	@Column(name="DATABASE")
	private String database;
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
