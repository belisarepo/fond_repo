package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="PRIORITET_NAUKA")
@SequenceGenerator(name="PK", sequenceName="SEQ_PRIORITET_NAUKA")
public class PrioritetNauka implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7433538192740212763L;
	@Id
	@GeneratedValue(generator="PK")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="KOD")
	private String kod;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SECTION_FOND_ID")
	private SectionFond sectionFond;
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
	public String getKod() {
		return kod;
	}
	public void setKod(String kod) {
		this.kod = kod;
	}
	public SectionFond getSectionFond() {
		return sectionFond;
	}
	public void setSectionFond(SectionFond sectionFond) {
		this.sectionFond = sectionFond;
	}
	

}
