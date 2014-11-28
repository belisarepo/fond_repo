package by.belisa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="STATUS_KONKURS")
@SequenceGenerator(name="PK", sequenceName="SEQ_STATUS_KONKURS")
public class KonkursStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5964742397766928919L;
	@Id
	@GeneratedValue(generator="PK")
	private int id;
	@Column(name="NAME")
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
