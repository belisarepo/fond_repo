package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_", schema="LPORTAL")
public class User implements Serializable{
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userid")
	private long id;
	@OneToOne(cascade=CascadeType.ALL, mappedBy="user")
	private Anketa anketa;
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
	
}
