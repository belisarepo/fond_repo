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
@Table(name="VID_FORMA_Z")
@SequenceGenerator(name="PK", sequenceName="SEQ_VID_FORMA_Z")
public class VidFormaZ implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8319504016296259152L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PK")
	@Column(name="id")
	private long id;
	@Column(name="name")
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
