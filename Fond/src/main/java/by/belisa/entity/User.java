package by.belisa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_", schema="LPORTAL")
@SequenceGenerator(name="PK", sequenceName="SEQ_USER")
public class User implements Serializable{
	
	public User(){
		this.anketa = new Anketa();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -1053232165638553977L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PK")
	@Column(name="userid")
	private long id;
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Anketa anketa;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USERS_ROLES", schema="LPORTAL", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = { @JoinColumn(name = "roleid") })
	private Set<Role> roles = new HashSet<Role>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Anketa getAnketa() {
		return anketa;
	}
	public void setAnketa(Anketa anketa) {
		this.anketa = anketa;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
