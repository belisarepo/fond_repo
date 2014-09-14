package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="TIP_KONKURSA")
@SequenceGenerator(name="PK",sequenceName="SEQ_TIP_KONKURSA")
public class TipKonkursa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1088067671838565643L;
	
	@Id
	@GeneratedValue(generator="PK", strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="NAME",length=30)
	private String name;
	@Column(name="KOD_OLD",length=2)
	private String oldCode;
	@Column(name="DESCRIPTION",length=4000)
	private String description;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FIN_RAZDEL_ID")
	private FinRazdel finRazdel;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VID_KONKURSA_ID")
	private VidKonkursa vidKonkursa;
	
	@Column(name="M",nullable=false)
	private boolean isMolod;
	public int getId() {
		return id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public FinRazdel getFinRazdel() {
		return finRazdel;
	}
	public void setFinRazdel(FinRazdel finRazdel) {
		this.finRazdel = finRazdel;
	}
	public VidKonkursa getVidKonkursa() {
		return vidKonkursa;
	}
	public void setVidKonkursa(VidKonkursa vidKonkursa) {
		this.vidKonkursa = vidKonkursa;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public boolean isMolod() {
		return isMolod;
	}
	public void setMolod(boolean isMolod) {
		this.isMolod = isMolod;
	}
	
	
	

}
