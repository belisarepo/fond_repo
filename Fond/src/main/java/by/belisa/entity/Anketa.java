 package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="ANKETA")
public class Anketa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4443436266052344647L;
	@Id
	@Column(name = "id")  
	@GeneratedValue(generator = "gen")  
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	private long id;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, optional=false)  
	@PrimaryKeyJoinColumn()
	private User user;
	@Column(name = "surname")
	private String surname;
	@Column(name = "name")
	private String name;
	@Column(name = "patronymic")
	private String patronymic;
	@Column(name = "age")
	private byte age;
	
	
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
