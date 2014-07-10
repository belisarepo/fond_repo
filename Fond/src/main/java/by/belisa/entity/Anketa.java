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
