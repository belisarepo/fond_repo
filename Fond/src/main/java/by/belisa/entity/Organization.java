package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORGANIZATION")
@SequenceGenerator(name="PK", sequenceName="SEQ_ORGANIZATION")
public class Organization implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1534080481178508955L;
	public Organization(){
		
	}
	public Organization(int id){
		this.id = id;
	}
	@Id
	@GeneratedValue(generator="PK")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="EMAIL")
	private String email;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	

}
