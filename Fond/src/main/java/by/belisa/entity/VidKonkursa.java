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
@Table(name="VID_KONKURSA")
@SequenceGenerator(name="PK", sequenceName="SEQ_VID_KONKURSA")
public class VidKonkursa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5706321878530530114L;
	@Id
	@GeneratedValue(generator="PK", strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="KOD_OLD")
	private String oldCode;
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
	public String getOldCode() {
		return oldCode;
	}
	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}
	

}
