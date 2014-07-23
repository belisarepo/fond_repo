package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SECTION_FOND")
@SequenceGenerator(name="PK",sequenceName="SEQ_SECTION_FOND")
public class SectionFond implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4121232026999466626L;
	@Id
	@GeneratedValue(generator="PK")
	private int id;
	@Column(name="NAME_R", length=60)
	private String nameR;
	@Column(name="NAME_E", length=60)
	private String nameE;
	@Column(name="NAME_FOR_PRINT", length=60)
	private String nameForPrint;
	@Column(name="OBOZNACH", length=3)
	private String oboznach;
	@Column(name="KOD_OLD", length=2)
	private String oldCode;
	public int getId() {
		return id;
	}
	public String getNameR() {
		return nameR;
	}
	public void setNameR(String nameR) {
		this.nameR = nameR;
	}
	public String getNameE() {
		return nameE;
	}
	public void setNameE(String nameE) {
		this.nameE = nameE;
	}
	public String getNameForPrint() {
		return nameForPrint;
	}
	public void setNameForPrint(String nameForPrint) {
		this.nameForPrint = nameForPrint;
	}
	public String getOboznach() {
		return oboznach;
	}
	public void setOboznach(String oboznach) {
		this.oboznach = oboznach;
	}
	public String getOldCode() {
		return oldCode;
	}
	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}
	
	
}
