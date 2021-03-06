package by.belisa.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="KONKURSY")
@SequenceGenerator(name="PK", sequenceName="SEQ_KONKURS")
public class Konkursy implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6944732595702266164L;
	@Id
	@GeneratedValue(generator="PK")
	private int id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TIP_KONKURSA_ID")
	private TipKonkursa tipKonkursa;
	@Column(name="DESCRIPTION_R",length=30)
	private String descriptionR;
	@Column(name="DESCRIPTION_E",length=30)
	private String descriptionE;
	@Column(name="NAME_R",length=10)
	private String nameR;
	@Column(name="NAME_E",length=10)
	private String nameE;
	@Column(name="YEAR_KONKURS",length=4)
	private String yearKonkurs;
	@Column(name="PREFIX_Z_R",length=10)
	private String prefixZR;
	@Column(name="PREFIX_Z_E",length=10)
	private String prefixZE;
	@Column(name="FORMA_Z_R",length=10)
	private String formaZR;
	@Column(name="FORMA_Z_E",length=10)
	private String formaZE;
	@Column(name="RESHENIE_NS",length=4000)
	private String reshenieNS;
//	@Lob@Basic(fetch=FetchType.LAZY)
//	@Column(name="USL_KONKURSA_R")
//	private byte[] uslKonkursaR;
//	@Lob
//	@Column(name="USL_KONKURSA_E")
//	private byte[] uslKonkursaE;
	@Column(name="STOP_KONKURS")
	private Date stopKonkurs;
	@Column(name="START_PROJECT")
	private Date startProject;
	@Column(name="STOP_PROJECT")
	private Date stopProject;
	@Column(name="COUNT_ISPOLNITEL")
	private Integer countIspolnitel;
	@Column(name="COUNT_RUKOVODITEL")
	private Integer countRukovoditel;
	@Column(name="COUNT_ISPOL_RUKOV")
	private Integer countIspolRukov;
	@Column(name="COUNT_ALL_TIME")
	private Integer countAllTime;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STATUS_KONKURS")
	private KonkursStatus konkursStatus;
	@Column(name="VID_PROJECT")
	private Boolean vidProject;
	@Column(name="NAPRAVL")
	private Boolean napravl;
	@Column(name="OTRASL_N")
	private Boolean otraslN;
	@Column(name="PRIORITET_N")
	private Boolean prioritetN;
	@ManyToOne
	@JoinColumn(name="ORGANIZATION_NR_ID")
	private OrganizationNR orgNr;
	@Column(name="COUNTRY_ID")
	private Integer countryId;
	
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public OrganizationNR getOrgNr() {
		return orgNr;
	}
	public void setOrgNr(OrganizationNR orgNr) {
		this.orgNr = orgNr;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public TipKonkursa getTipKonkursa() {
		return tipKonkursa;
	}
	public void setTipKonkursa(TipKonkursa tipKonkursa) {
		this.tipKonkursa = tipKonkursa;
	}
	public String getDescriptionR() {
		return descriptionR;
	}
	public void setDescriptionR(String descriptionR) {
		this.descriptionR = descriptionR;
	}
	public String getDescriptionE() {
		return descriptionE;
	}
	public void setDescriptionE(String descriptionE) {
		this.descriptionE = descriptionE;
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
	public String getYearKonkurs() {
		return yearKonkurs;
	}
	public void setYearKonkurs(String yearKonkurs) {
		this.yearKonkurs = yearKonkurs;
	}
	public String getPrefixZR() {
		return prefixZR;
	}
	public void setPrefixZR(String prefixZR) {
		this.prefixZR = prefixZR;
	}
	public String getPrefixZE() {
		return prefixZE;
	}
	public void setPrefixZE(String prefixZE) {
		this.prefixZE = prefixZE;
	}
	public String getFormaZR() {
		return formaZR;
	}
	public void setFormaZR(String formaZR) {
		this.formaZR = formaZR;
	}
	public String getFormaZE() {
		return formaZE;
	}
	public void setFormaZE(String formaZE) {
		this.formaZE = formaZE;
	}
	public String getReshenieNS() {
		return reshenieNS;
	}
	public void setReshenieNS(String reshenieNS) {
		this.reshenieNS = reshenieNS;
	}
	
	public Integer getCountAllTime() {
		return countAllTime;
	}
	public void setCountAllTime(Integer countAllTime) {
		this.countAllTime = countAllTime;
	}
	public KonkursStatus getKonkursStatus() {
		return konkursStatus;
	}
	public void setKonkursStatus(KonkursStatus konkursStatus) {
		this.konkursStatus = konkursStatus;
	}
	public Date getStopKonkurs() {
		return stopKonkurs;
	}
	public void setStopKonkurs(Date stopKonkurs) {
		this.stopKonkurs = stopKonkurs;
	}
	public Date getStartProject() {
		return startProject;
	}
	public void setStartProject(Date startProject) {
		this.startProject = startProject;
	}
	public Date getStopProject() {
		return stopProject;
	}
	public void setStopProject(Date stopProject) {
		this.stopProject = stopProject;
	}
	public Integer getCountIspolnitel() {
		return countIspolnitel;
	}
	public void setCountIspolnitel(Integer countIspolnitel) {
		this.countIspolnitel = countIspolnitel;
	}
	public Integer getCountRukovoditel() {
		return countRukovoditel;
	}
	public void setCountRukovoditel(Integer countRukovoditel) {
		this.countRukovoditel = countRukovoditel;
	}
	public Integer getCountIspolRukov() {
		return countIspolRukov;
	}
	public void setCountIspolRukov(Integer countIspolRukov) {
		this.countIspolRukov = countIspolRukov;
	}
	public Boolean getVidProject() {
		return vidProject;
	}
	public void setVidProject(Boolean vidProject) {
		this.vidProject = vidProject;
	}
	public Boolean getNapravl() {
		return napravl;
	}
	public void setNapravl(Boolean napravl) {
		this.napravl = napravl;
	}
	public Boolean getOtraslN() {
		return otraslN;
	}
	public void setOtraslN(Boolean otraslN) {
		this.otraslN = otraslN;
	}
	public Boolean getPrioritetN() {
		return prioritetN;
	}
	public void setPrioritetN(Boolean prioritetN) {
		this.prioritetN = prioritetN;
	}
	

}
