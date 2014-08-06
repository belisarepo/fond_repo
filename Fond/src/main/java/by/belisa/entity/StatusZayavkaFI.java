package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="STATUS_ZAYAVKA_FI")
@SequenceGenerator(name="PK", sequenceName="SEQ_STATUS_ZAYAVKA_FI")
public class StatusZayavkaFI implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8155435198397457498L;
	
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
