package by.belisa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TWO")
@SequenceGenerator(name="PK", sequenceName="SEQ_TWO")
public class Two implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1360796683379043861L;
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@Column
	private String name;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="ONE_TWO",joinColumns={@JoinColumn(name="TWO_ID")},inverseJoinColumns={@JoinColumn(name="ONE_ID")})
	private Set<One> oneSet = new HashSet<One>();
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
	public Set<One> getOneSet() {
		return oneSet;
	}
	public void setOneSet(Set<One> oneSet) {
		this.oneSet = oneSet;
	}
	

}
