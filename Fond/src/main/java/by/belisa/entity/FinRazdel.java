package by.belisa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FIN_RAZDEL")
@SequenceGenerator(name="PK", sequenceName="SEQ_FIN_RAZDEL")
public class FinRazdel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8717196025744790476L;
	@Id
	@GeneratedValue(generator="PK", strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="NAME")
	private int name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	
}
