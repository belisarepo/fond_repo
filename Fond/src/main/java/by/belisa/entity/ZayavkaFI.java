package by.belisa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
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
	@Column(name = "VID_PROJECT")
	private String vidProject;
	@Column(name = "VID_DOGOVOR")
	private String vidDogovor;
	@Lob
	@Column(name = "TEMA_NAME")
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
	private CalcZpSum calcZpSum;
	@OneToOne(mappedBy = "zayavkaFI", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private CalcMaterialsSum calcMaterialsSum;
	@OneToOne(mappedBy = "zayavkaFI", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private CalcTripSum calcTripSum;
	@OneToOne(mappedBy = "zayavkaFI", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private CalcOtherCostsSum calcOtherCostsSum;

	@OneToOne(mappedBy = "zayavkaFI", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private RukovoditelNR rukovoditelNr;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "FIZ_NR_INFO_ID")
	private FizNRInfo fizNrInfo;

	@ManyToOne()
	@JoinColumn(name = "FIZ_INFO_ID")
	private FizInfo fizInfo;
	@ManyToMany(mappedBy = "zayavki")
	@OrderBy("id ASC")
	private List<Organization> soOrgs = new ArrayList<Organization>();
	@OneToMany(mappedBy = "zayavkaFI")
	@OrderBy("id ASC")
	private List<Ispolnitel> ispolniteli = new ArrayList<Ispolnitel>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ZAYAVKA_ID")
	@OrderBy("id ASC")
	List<CalcZp> calcZpSet = new ArrayList<CalcZp>();
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ZAYAVKA_ID")
	@OrderBy("id ASC")
	List<CalcTrip> calcTripSet = new ArrayList<CalcTrip>();
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ZAYAVKA_ID")
	@OrderBy("id ASC")
	List<CalcMaterials> calcMaterialsSet = new ArrayList<CalcMaterials>();
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ZAYAVKA_ID")
	@OrderBy("id ASC")
	List<CalcOtherCosts> calcOtherCostsSet = new ArrayList<CalcOtherCosts>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ZAYAVKA_ID")
	@OrderBy("id ASC")
	List<Petition> petitionSet = new ArrayList<Petition>();

	// @ManyToMany(cascade=CascadeType.ALL)
	// @JoinTable(name="ZAYAVKA_FI_FIZ_INFO",
	// joinColumns={@JoinColumn(name="ZAYAVKA_FI_ID")},
	// inverseJoinColumns={@JoinColumn(name="FIZ_INFO_ID")})
	// private List<FizInfo> fizInfoSet = new ArrayList<FizInfo>();

	public String getLastingDeadline() {
		return lastingDeadline;
	}

	public FizInfo getFizInfo() {
		return fizInfo;
	}

	public void setFizInfo(FizInfo fizInfo) {
		this.fizInfo = fizInfo;
	}

	public List<CalcZp> getCalcZpSet() {
		return calcZpSet;
	}

	public void setCalcZpSet(List<CalcZp> calcZpSet) {
		this.calcZpSet = calcZpSet;
	}

	public List<CalcTrip> getCalcTripSet() {
		return calcTripSet;
	}

	public void setCalcTripSet(List<CalcTrip> calcTripSet) {
		this.calcTripSet = calcTripSet;
	}

	public List<CalcMaterials> getCalcMaterialsSet() {
		return calcMaterialsSet;
	}

	public void setCalcMaterialsSet(List<CalcMaterials> calcMaterialsSet) {
		this.calcMaterialsSet = calcMaterialsSet;
	}

	public List<CalcOtherCosts> getCalcOtherCostsSet() {
		return calcOtherCostsSet;
	}

	public void setCalcOtherCostsSet(List<CalcOtherCosts> calcOtherCostsSet) {
		this.calcOtherCostsSet = calcOtherCostsSet;
	}

	public Calculation getCalculation() {
		return calculation;
	}

	public void setCalculation(Calculation calculation) {
		this.calculation = calculation;
	}

	public List<Ispolnitel> getIspolniteli() {
		return ispolniteli;
	}

	public void setIspolniteli(List<Ispolnitel> ispolniteli) {
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

	public List<Organization> getSoOrgs() {
		return soOrgs;
	}

	public void setSoOrgs(List<Organization> soOrgs) {
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

	public List<Petition> getPetitionSet() {
		return petitionSet;
	}

	public void setPetitionSet(List<Petition> petitionSet) {
		this.petitionSet = petitionSet;
	}

	public CalcZpSum getCalcZpSum() {
		return calcZpSum;
	}

	public void setCalcZpSum(CalcZpSum calcZpSum) {
		this.calcZpSum = calcZpSum;
	}

	public CalcMaterialsSum getCalcMaterialsSum() {
		return calcMaterialsSum;
	}

	public void setCalcMaterialsSum(CalcMaterialsSum calcMaterialsSum) {
		this.calcMaterialsSum = calcMaterialsSum;
	}

	public CalcTripSum getCalcTripSum() {
		return calcTripSum;
	}

	public void setCalcTripSum(CalcTripSum calcTripSum) {
		this.calcTripSum = calcTripSum;
	}

	public CalcOtherCostsSum getCalcOtherCostsSum() {
		return calcOtherCostsSum;
	}

	public void setCalcOtherCostsSum(CalcOtherCostsSum calcOtherCostsSum) {
		this.calcOtherCostsSum = calcOtherCostsSum;
	}

	public String getVidProject() {
		return vidProject;
	}

	public void setVidProject(String vidProject) {
		this.vidProject = vidProject;
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
		// Проверка "Научное направление"
		if (this.konkursy.getNapravl() && (this.naprNauka==null || this.naprNauka.isEmpty())) {
			message = "Не заполнено научное направление" + " " + tabNameDataAboutTender;
			vr.getErrMessages().add(message);
		}
		// Проверка "Вид проекта"
		if (this.konkursy.getVidProject() && (this.vidProject==null || this.vidProject.isEmpty())) {
			message = "Не заполнено Вид проекта" + " " + tabNameDataAboutTender;
			vr.getErrMessages().add(message);
		}
		// Проверка списка "Приоритетное направление"
		if (this.konkursy.getPrioritetN() && (this.prioritetNauka == null)) {
			message = "Не выбрано приоритетное направление" + " " + tabNameDataAboutTender;
			vr.getErrMessages().add(message);
		}
		// Проверка списка "Отрасль науки"
		if (this.konkursy.getOtraslN() && this.otraslNauka == null) {
			message = "Не выбрано Отрасль науки" + " " + tabNameDataAboutTender;
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
		} else {
			// Сумма всего по проекту должны быть больше или равна чем за первый
			// год
			if (this.calculation.getAllFull() < this.calculation.getAllFirstYear()) {
				message = "Всего стоимость по проекту меньше чем за первый год " + tabNameCalc;
				vr.getErrMessages().add(message);
			}
		}
		// Проверка расчёта зп
		if (this.calcZpSet == null) {
			message = "Не заполнен расчёт заработной платы" + " " + tabNameCalcSalary;
			vr.getErrMessages().add(message);
		}
		// Проверка итоговый сумм калькуляций
		if (this.calculation != null && !this.calcZpSet.isEmpty()) {
			if (this.calculation.getZpFull() != this.calcZpSum.getSum()) {
				message = "Не совпадают суммы \"Заработная плата(основаная и дополнительная) научно-производственного персонала\" " + tabNameCalc
						+ " и \"Итого затрат\" " + tabNameCalcSalary;
				vr.getErrMessages().add(message);
			}
			if ((this.calcMaterialsSet.isEmpty() && this.calculation.getHardwareFull() != 0)
					|| (this.calcMaterialsSum!=null && this.calculation.getHardwareFull() != this.calcMaterialsSum.getSum())) {
				message = "Не совпадают суммы \"Материалы,покупные полуфабрикаты и комплектующие изделия\" " + tabNameCalc
						+ " и \"Итого затрат\" во вкладке \"Расчёт затрат на материалы\"";
				vr.getErrMessages().add(message);
			}
			if ((this.calcTripSet.isEmpty() && this.calculation.getBusinessTripFull() != 0)
					|| (this.calcTripSum!=null && this.calculation.getBusinessTripFull() != this.calcTripSum.getSum())) {
				message = "Не совпадают суммы \"Научно-производственные командировки\" " + tabNameCalc
						+ " и \"Итого затрат\" во вкладке \"Расчёт затрат на командировки\"";
				vr.getErrMessages().add(message);
			}
			if ((this.calcOtherCostsSet.isEmpty() && this.calculation.getOtherFull() != 0)
					|| (this.calcOtherCostsSum!=null && this.calculation.getOtherFull() != this.calcOtherCostsSum.getSum())) {
				message = "Не совпадают суммы \"Прочие прямые расходы\" " + tabNameCalc
						+ " и \"Итого затрат\" во вкладке \"Расчёт затрат по статье\"Прочие прямые затраты\"\"";
				vr.getErrMessages().add(message);
			}
		}
		// Проверка списка публикации
		if (this.fizInfo.getPublication() == null || this.fizInfo.getPublication().isEmpty()) {
			message = "Не заполнена вкладка \"Список публикации\"";
			vr.getErrMessages().add(message);
		}
		// Проверка кто вносит ходатайство
		if (VidFormId == BELARUS_JUNIOR_FORM_ID || VidFormId == COOPERATIVE_JUNIOR_FORM_ID) {
			if (this.petitionSet.isEmpty() || this.petitionSet == null) {
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
		if (VidFormId == COOPERATIVE_FORM_ID || VidFormId == BELARUS_FORM_ID) {
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
