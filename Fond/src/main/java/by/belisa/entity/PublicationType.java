package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PUBLICATION_TYPE")
@SequenceGenerator(name="PK",sequenceName="SEQ_PUBLICATION_TYPE")
public class PublicationType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7532697158820464660L;

	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	
	@Column(name="NAME")
	private String name;

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

}
