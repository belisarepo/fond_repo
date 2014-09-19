package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PETITION")
@SequenceGenerator(name="PK",sequenceName="SEQ_PETITION")
public class Petition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1907466966840434943L;

	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	public Petition(){
		
	}
	public Petition(String name){
		this.name=name;
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
	
}
