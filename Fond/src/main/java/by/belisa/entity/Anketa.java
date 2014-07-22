 package by.belisa.entity;

import java.io.Serializable;

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
	@Column(name="FIO")
	private String fio;
	
	@OneToOne(fetch=FetchType.LAZY, optional=false)  
	@PrimaryKeyJoinColumn()
	private User user;
	
	
	
	
	public String getFio() {
		return fio;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}
	public long getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
