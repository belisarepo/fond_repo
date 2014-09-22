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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import by.belisa.validation.IValidaton;
import by.belisa.validation.ValidationResult;

@Entity
@Table(name = "ZAYAVKA_FI")
@SequenceGenerator(name = "PK", sequenceName = "SEQ_ZAYAVKA_FI")
public class ZayavkaFI implements Serializable, IValidaton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4740539220522010233L;
	@Id
	@GeneratedValue(generator = "PK")
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KONKURSY_ID")
	private Konkursy konkursy;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private Anketa anketa;
	@Column(name = "REGISTR_NUMBER_E")
	private String registrNumberE;
	@Column(name = "REGISTR_DATE_E", columnDefinition = "DATE")
	private Date registrDateE;
	@Column(name = "REGISTR_NUMBER")
	private String registrNumber;
	@Column(name = "REGISTR_DATE", columnDefinition = "DATE")
	private Date registrDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_Z_ID")
	private StatusZayavkaFI statusZayavkaFI;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SECTION_FOND_ID")
	private SectionFond sectionFond;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OTRASL_NAUKA_ID")
	private OtraslNauka otraslNauka;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRIORITET_NAUKA_ID")
	private PrioritetNauka prioritetNauka;
	@Column(name = "NAPR_NAUKA")
	private String naprNauka;
	@Column(name = "VID_DOGOVOR")
	private String vidDogovor;
	@Column(name = "TEMA_Z_NAME")
	private String temaZName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organization;
	@Column(name = "LASTING_DEADLINE")
	private String lastingDeadline;
	@Column(name = "START_DEADLINE", columnDefinition = "DATE")
	private Date startDeadline;
	@Column(name = "STOP_DEADLINE", columnDefinition = "DATE")
	private Date stopDeadline;
	@Column(name = "COST_ALL")
	private Float costAll;
	@Column(name = "COST_FIRST_YEAR")
	private Float costFirstYear;
	@Column(name = "KOD_UDK")
	private String codeUdk;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZATION_NR_ID")
	private OrganizationNR orgNR;
	@OneToOne(mappedBy = "zayavkaFI", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Annotation annotation;
	@OneToOne(mappedBy = "zayavkaFI", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Obosnovanie obosnovanie;
	@OneToOne(mappedBy = "zayavkaFI", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Rukovoditel rukovoditel;
	@OneToOne(mappedBy = "zayavkaFI", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Calculation calculation;

	@OneToOne(mappedBy = "zayavkaFI", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private RukovoditelNR rukovoditelNr;
	@ManyToOne
	@JoinColumn(name = "FIZ_NR_INFO_ID")
	private FizNRInfo fizNrInfo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FIZ_INFO_ID")
	private FizInfo fizInfo;
	@ManyToMany(mappedBy = "zayavki")
	private Set<Organization> soOrgs = new HashSet<Organization>();
	@OneToMany(mappedBy = "zayavkaFI")
	private Set<Ispolnitel> ispolniteli = new HashSet<Ispolnitel>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ZAYAVKA_ID")
	Set<CalcZp> calcZpSet = new HashSet<CalcZp>();
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ZAYAVKA_ID")
	Set<CalcTrip> calcTripSet = new HashSet<CalcTrip>();
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ZAYAVKA_ID")
	Set<CalcMaterials> calcMaterialsSet = new HashSet<CalcMaterials>();
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ZAYAVKA_ID")
	Set<CalcOtherCosts> calcOtherCostsSet = new HashSet<CalcOtherCosts>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ZAYAVKA_ID")
	Set<Petition> petitionSet = new HashSet<Petition>();

	// @ManyToMany(cascade=CascadeType.ALL)
	// @JoinTable(name="ZAYAVKA_FI_FIZ_INFO",
	// joinColumns={@JoinColumn(name="ZAYAVKA_FI_ID")},
	// inverseJoinColumns={@JoinColumn(name="FIZ_INFO_ID")})
	// private Set<FizInfo> fizInfoSet = new HashSet<FizInfo>();

	public String getLastingDeadline() {
		return lastingDeadline;
	}

	public FizInfo getFizInfo() {
		return fizInfo;
	}

	public void setFizInfo(FizInfo fizInfo) {
		this.fizInfo = fizInfo;
	}

	public Set<CalcZp> getCalcZpSet() {
		return calcZpSet;
	}

	public void setCalcZpSet(Set<CalcZp> calcZpSet) {
		this.calcZpSet = calcZpSet;
	}

	public Set<CalcTrip> getCalcTripSet() {
		return calcTripSet;
	}

	public void setCalcTripSet(Set<CalcTrip> calcTripSet) {
		this.calcTripSet = calcTripSet;
	}

	public Set<CalcMaterials> getCalcMaterialsSet() {
		return calcMaterialsSet;
	}

	public void setCalcMaterialsSet(Set<CalcMaterials> calcMaterialsSet) {
		this.calcMaterialsSet = calcMaterialsSet;
	}

	public Set<CalcOtherCosts> getCalcOtherCostsSet() {
		return calcOtherCostsSet;
	}

	public void setCalcOtherCostsSet(Set<CalcOtherCosts> calcOtherCostsSet) {
		this.calcOtherCostsSet = calcOtherCostsSet;
	}

	public Calculation getCalculation() {
		return calculation;
	}

	public void setCalculation(Calculation calculation) {
		this.calculation = calculation;
	}

	public Set<Ispolnitel> getIspolniteli() {
		return ispolniteli;
	}

	public void setIspolniteli(Set<Ispolnitel> ispolniteli) {
		this.ispolniteli = ispolniteli;
	}

	public Obosnovanie getObosnovanie() {
		return obosnovanie;
	}

	public void setObosnovanie(Obosnovanie obosnovanie) {
		this.obosnovanie = obosnovanie;
	}

	public Rukovoditel getRukovoditel() {
		return rukovoditel;
	}

	public void setRukovoditel(Rukovoditel rukovoditel) {
		this.rukovoditel = rukovoditel;
	}

	public void setLastingDeadline(String lastingDeadline) {
		this.lastingDeadline = lastingDeadline;
	}

	public Date getStartDeadline() {
		return startDeadline;
	}

	public void setStartDeadline(Date startDeadline) {
		this.startDeadline = startDeadline;
	}

	public Date getStopDeadline() {
		return stopDeadline;
	}

	public Float getCostAll() {
		return costAll;
	}

	public void setCostAll(Float costAll) {
		this.costAll = costAll;
	}

	public Float getCostFirstYear() {
		return costFirstYear;
	}

	public void setCostFirstYear(Float costFirstYear) {
		this.costFirstYear = costFirstYear;
	}

	public void setStopDeadline(Date stopDeadline) {
		this.stopDeadline = stopDeadline;
	}

	public String getCodeUdk() {
		return codeUdk;
	}

	public void setCodeUdk(String codeUdk) {
		this.codeUdk = codeUdk;
	}

	public OrganizationNR getOrgNR() {
		return orgNR;
	}

	public void setOrgNR(OrganizationNR orgNR) {
		this.orgNR = orgNR;
	}

	public Annotation getAnnotation() {
		return annotation;
	}

	public void setAnnotation(Annotation annotation) {
		this.annotation = annotation;
	}

	public FizNRInfo getFizNrInfo() {
		return fizNrInfo;
	}

	public void setFizNrInfo(FizNRInfo fizNrInfo) {
		this.fizNrInfo = fizNrInfo;
	}

	public Set<Organization> getSoOrgs() {
		return soOrgs;
	}

	public void setSoOrgs(Set<Organization> soOrgs) {
		this.soOrgs = soOrgs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public RukovoditelNR getRukovoditelNr() {
		return rukovoditelNr;
	}

	public void setRukovoditelNr(RukovoditelNR rukovoditelNr) {
		this.rukovoditelNr = rukovoditelNr;
	}

	public Set<Petition> getPetitionSet() {
		return petitionSet;
	}

	public void setPetitionSet(Set<Petition> petitionSet) {
		this.petitionSet = petitionSet;
	}

	@Override
	public ValidationResult validate() {
		final int BELARUS_FORM_ID = 1;
		final int BELARUS_JUNIOR_FORM_ID = 2;
		final int COOPERATIVE_FORM_ID = 3;
		final int COOPERATIVE_JUNIOR_FORM_ID = 4;
		ValidationResult vr = new ValidationResult();
		String message = null;
		String tabNameDataAboutTender = "во вкладке \"Данные о заявке\"";
		String tabNameOrgFromBLR = "во вкладке \"Организация-заявитель от РБ\"";
		String tabNameCalc = "во вкладке \"Калькуляция сметной стоимости проекта\"";
		String tabNameCalcSalary = "во вкладке\"Расчёт затрат на заработную плату\"";
		String tabNameOrgFromInternational = "во вкладке\"Организация-заявитель от зарубежной стороны\"";
		int VidFormId = this.konkursy.getTipKonkursa().getVidFormaZ().getId();

		// Проверка списка "Секция Научного совета БРФФИ"
		if (this.sectionFond == null) {
			message = "Не выбрана секция научного совета БРФФИ" + " " + tabNameDataAboutTender;
			vr.getErrMessages().add(message);
		}
		// Проверка списка "Научное направление"
		if (this.otraslNauka == null) {
			message = "Не выбрано научное направление" + " " + tabNameDataAboutTender;
			vr.getErrMessages().add(message);
		}
		// Проверка списка "Приоритетное направление"
		if (this.prioritetNauka == null) {
			message = "Не выбрано приоритетное направление" + " " + tabNameDataAboutTender;
			vr.getErrMessages().add(message);
		}
		// Проверка заполнения темы заявляемого проекта
		if (this.temaZName == null || this.temaZName.isEmpty()) {
			message = "Не заполнена тема заявляемого объекта" + " " + tabNameDataAboutTender;
			vr.getErrMessages().add(message);
		}
		// Проверка организации
		if (this.organization == null) {
			message = "Не выбрана органицизация заявитель" + " " + tabNameOrgFromBLR;
			vr.getErrMessages().add(message);
		}
		// Проверка калькуляции
		if (this.calculation == null || this.calculation.getAllFull() == 0) {
			message = "Не заполнена калькуляция" + " " + tabNameCalc;
			vr.getErrMessages().add(message);
		}
		// Проверка расчёта зп
		if (this.calcZpSet == null) {
			message = "Не заполнен расчёт заработной платы" + " " + tabNameCalcSalary;
			vr.getErrMessages().add(message);
		}
		// Проверка списка публикации
		if (this.fizInfo.getPublication() == null || this.fizInfo.getPublication().isEmpty()) {
			message = "Не заполнена вкладка \"Список публикации\"";
			vr.getErrMessages().add(message);
		}
		//Проверка кто вносит ходатайство 
		if(VidFormId == BELARUS_JUNIOR_FORM_ID || VidFormId == COOPERATIVE_JUNIOR_FORM_ID){
			if(this.petitionSet.isEmpty() || this.petitionSet == null){
				message = "Не заполнена вкладка \"Кто вносит ходатайство\"";
				vr.getErrMessages().add(message);
			}
		}
		// Если форма для совместных и совместных молодёжных
		if (VidFormId == COOPERATIVE_FORM_ID || VidFormId == COOPERATIVE_JUNIOR_FORM_ID) {
			// Проверка иностранных организаций
			if (this.konkursy != null) {
				final int INTERNATIONAL_ID = 4;
				int konkursVidId = this.konkursy.getTipKonkursa().getVidKonkursa().getId();
				if (INTERNATIONAL_ID == konkursVidId) {
					// Если тип конкурса международный, то должна быть указана
					// организация заявитель от зарубежной стороны
					if (this.orgNR == null) {
						message = "Не выбрана организация-заявитель от зарубуженой стороны" + " " + tabNameOrgFromInternational;
						vr.getErrMessages().add(message);
					}
					// Если тип конкурса международный, то должен быть заполнен
					// руководитель от зарубежной стороны
					if (this.rukovoditelNr == null) {
						message = "Не заполнена вкладка \"Руководитель проекта от зарубежной стороны\"";
						vr.getErrMessages().add(message);
					} else {
						vr.getErrMessages().addAll(this.rukovoditelNr.validate().getErrMessages());
					}
				}
			}
		}
		if (VidFormId ==COOPERATIVE_FORM_ID || VidFormId == BELARUS_FORM_ID) {
			// Проверка вкладки аннотация
			if (this.annotation != null) {
				vr.getErrMessages().addAll(this.annotation.validate().getErrMessages());
			} else {
				message = "Не заполнена вкладка \"Аннотация\"";
				vr.getErrMessages().add(message);
			}
		}
		// Проверка вкладки обоснование
		if (this.obosnovanie != null) {
			vr.getErrMessages().addAll(this.obosnovanie.validate().getErrMessages());
		} else {
			message = "Не заполнена вкладка \"Обоснование\"";
			vr.getErrMessages().add(message);
		}
		// Проверка руководителя
		if (this.rukovoditel != null) {
			vr.getErrMessages().addAll(this.rukovoditel.validate().getErrMessages());
		} else {
			message = "Не заполнена вкладка \"Руководитель проекта от РБ\"";
			vr.getErrMessages().add(message);
		}

		return vr;
	}

}
