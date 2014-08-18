package by.belisa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="ZAYAVKA_FI")
@SequenceGenerator(name="PK",sequenceName="SEQ_ZAYAVKA_FI")
public class ZayavkaFI implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4740539220522010233L;
	@Id
	@GeneratedValue(generator="PK")
	private int id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="KONKURSY_ID")
	private Konkursy konkursy;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private Anketa anketa;
	@Column(name="REGISTR_NUMBER_E")
	private String registrNumberE;
	@Column(name="REGISTR_DATE_E", columnDefinition="DATE")
	private Date registrDateE;
	@Column(name="REGISTR_NUMBER")
	private String registrNumber;
	@Column(name="REGISTR_DATE", columnDefinition="DATE")
	private Date registrDate;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STATUS_Z_ID")
	private StatusZayavkaFI statusZayavkaFI;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SECTION_FOND_ID")
	private SectionFond sectionFond;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OTRASL_NAUKA_ID")
	private OtraslNauka otraslNauka;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PRIORITET_NAUKA_ID")
	private PrioritetNauka prioritetNauka;
	@Column(name="NAPR_NAUKA")
	private String naprNauka;
	@Column(name="VID_DOGOVOR")
	private String vidDogovor;
	@Column(name="TEMA_Z_NAME")
	private String temaZName;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORGANIZATION_ID")
	private Organization organization;
	
//	@ManyToMany(cascade=CascadeType.ALL)
//    @JoinTable(name="ZAYAVKA_FI_FIZ_INFO", 
//                joinColumns={@JoinColumn(name="ZAYAVKA_FI_ID")}, 
//                inverseJoinColumns={@JoinColumn(name="FIZ_INFO_ID")})
//	private Set<FizInfo> fizInfoSet = new HashSet<FizInfo>();
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Konkursy getKonkursy() {
		return konkursy;
	}
	public void setKonkursy(Konkursy konkursy) {
		this.konkursy = konkursy;
	}
	public Anketa getAnketa() {
		return anketa;
	}
	public void setAnketa(Anketa anketa) {
		this.anketa = anketa;
	}
	public String getRegistrNumberE() {
		return registrNumberE;
	}
	public void setRegistrNumberE(String registrNumberE) {
		this.registrNumberE = registrNumberE;
	}
	public Date getRegistrDateE() {
		return registrDateE;
	}
	public void setRegistrDateE(Date registrDateE) {
		this.registrDateE = registrDateE;
	}
	public String getRegistrNumber() {
		return registrNumber;
	}
	public void setRegistrNumber(String registrNumber) {
		this.registrNumber = registrNumber;
	}
	public Date getRegistrDate() {
		return registrDate;
	}
	public void setRegistrDate(Date registrDate) {
		this.registrDate = registrDate;
	}
	public StatusZayavkaFI getStatusZayavkaFI() {
		return statusZayavkaFI;
	}
	public void setStatusZayavkaFI(StatusZayavkaFI statusZayavkaFI) {
		this.statusZayavkaFI = statusZayavkaFI;
	}
	public SectionFond getSectionFond() {
		return sectionFond;
	}
	public void setSectionFond(SectionFond sectionFond) {
		this.sectionFond = sectionFond;
	}
	public OtraslNauka getOtraslNauka() {
		return otraslNauka;
	}
	public void setOtraslNauka(OtraslNauka otraslNauka) {
		this.otraslNauka = otraslNauka;
	}
	public PrioritetNauka getPrioritetNauka() {
		return prioritetNauka;
	}
	public void setPrioritetNauka(PrioritetNauka prioritetNauka) {
		this.prioritetNauka = prioritetNauka;
	}
	public String getNaprNauka() {
		return naprNauka;
	}
	public void setNaprNauka(String naprNauka) {
		this.naprNauka = naprNauka;
	}
	public String getVidDogovor() {
		return vidDogovor;
	}
	public void setVidDogovor(String vidDogovor) {
		this.vidDogovor = vidDogovor;
	}
	public String getTemaZName() {
		return temaZName;
	}
	public void setTemaZName(String temaZName) {
		this.temaZName = temaZName;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	

}
