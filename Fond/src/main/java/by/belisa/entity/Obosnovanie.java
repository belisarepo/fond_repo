package by.belisa.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import by.belisa.validation.IValidaton;
import by.belisa.validation.ValidationResult;

@Entity
@Table(name = "OBOSNOVANIE")
@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "zayavkaFI"))
public class Obosnovanie implements Serializable, IValidaton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2437192977268123834L;
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "gen")
	private Integer id;

	@Column(name = "TEMA")
	private String tema;

	@Lob
	@Column(name = "GOAL")
	private String goal;

	@Lob
	@Column(name = "ANALIZ_RESULTS")
	private String analizResults;

	@Lob
	@Column(name = "RESERVE_AUTHORS")
	private String reserveAuthors;

	@Lob
	@Column(name = "EXPEDIENCY")
	private String expediency;

	@Lob
	@Column(name = "IDEA_FORMULATION")
	private String ideaFormulation;

	@Lob
	@Column(name = "IDEA_INNOVATION")
	private String ideaInnovation;

	@Lob
	@Column(name = "STRUCTURE_OF_STUDY")
	private String structureOfStudy;

	@Lob
	@Column(name = "NIR_RESULTS")
	private String resultsNir;

	@Lob
	@Column(name = "USING_RESULTS")
	private String usingResults;

	@Lob
	@Column(name = "TEAM_CHARACTERISTIC")
	private String teamCharacteristic;

	@Lob
	@Column(name = "PROVISION_EQUIPMENT")
	private String provisionEquipment;

	@Lob
	@Column(name = "PREVIOUS_KONKURS")
	private String previousKonkurs;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@PrimaryKeyJoinColumn()
	private ZayavkaFI zayavkaFI;
	
	@Column(name="FULL_FILE")
	@Lob
	private byte[] file;
	@Column(name="FILE_NAME")
	private String fileName;

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getAnalizResults() {
		return analizResults;
	}

	public void setAnalizResults(String analizResults) {
		this.analizResults = analizResults;
	}

	public String getReserveAuthors() {
		return reserveAuthors;
	}

	public void setReserveAuthors(String reserveAuthors) {
		this.reserveAuthors = reserveAuthors;
	}

	public String getExpediency() {
		return expediency;
	}

	public void setExpediency(String expediency) {
		this.expediency = expediency;
	}

	public String getIdeaFormulation() {
		return ideaFormulation;
	}

	public void setIdeaFormulation(String ideaFormulation) {
		this.ideaFormulation = ideaFormulation;
	}

	public String getIdeaInnovation() {
		return ideaInnovation;
	}

	public void setIdeaInnovation(String ideaInnovation) {
		this.ideaInnovation = ideaInnovation;
	}

	public String getStructureOfStudy() {
		return structureOfStudy;
	}

	public void setStructureOfStudy(String structureOfStudy) {
		this.structureOfStudy = structureOfStudy;
	}

	public String getResultsNir() {
		return resultsNir;
	}

	public void setResultsNir(String resultsNir) {
		this.resultsNir = resultsNir;
	}

	public String getUsingResults() {
		return usingResults;
	}

	public void setUsingResults(String usingResults) {
		this.usingResults = usingResults;
	}

	public String getTeamCharacteristic() {
		return teamCharacteristic;
	}

	public void setTeamCharacteristic(String teamCharacteristic) {
		this.teamCharacteristic = teamCharacteristic;
	}

	public String getProvisionEquipment() {
		return provisionEquipment;
	}

	public void setProvisionEquipment(String provisionEquipment) {
		this.provisionEquipment = provisionEquipment;
	}

	public String getPreviousKonkurs() {
		return previousKonkurs;
	}

	public void setPreviousKonkurs(String previousKonkurs) {
		this.previousKonkurs = previousKonkurs;
	}

	public ZayavkaFI getZayavkaFI() {
		return zayavkaFI;
	}

	public void setZayavkaFI(ZayavkaFI zayavkaFI) {
		this.zayavkaFI = zayavkaFI;
	}

	@Override
	public ValidationResult validate() {
		final int BELARUS_FORM_ID = 1;
		final int BELARUS_JUNIOR_FORM_ID = 2;
		final int COOPERATIVE_FORM_ID = 3;
		final int COOPERATIVE_JUNIOR_FORM_ID = 4;
		ValidationResult vr = new ValidationResult();
		if (this.fileName!=null && !this.fileName.isEmpty()){
			return vr;
		}
		String message = null;
		String tabNameJustification = "во вкладке \"Обоснование\"";
		int VidFormId = this.zayavkaFI.getKonkursy().getTipKonkursa().getVidFormaZ().getId();
		// Проверка цели, задачи и её актуальности
		if (this.goal == null || this.goal.isEmpty()) {
			message = "Не заполнена цель и задачи работы" + " " + tabNameJustification;
			vr.getErrMessages().add(message);
		}
		// Проверка краткого анализа
		if (this.analizResults == null || this.analizResults.isEmpty()) {
			message = "Не заполен краткий анализ" + " " + tabNameJustification;
			vr.getErrMessages().add(message);
		}
		// Проверка научно-практического задела авторов
		if (this.reserveAuthors == null || this.reserveAuthors.isEmpty()) {
			message = "Не заполнен научно-практический задел авторов" + " " + tabNameJustification;
			vr.getErrMessages().add(message);
		}
		// Если конкурс совместный или совместный молодёжный
		if (VidFormId == COOPERATIVE_FORM_ID || VidFormId == COOPERATIVE_JUNIOR_FORM_ID) {
			// Проверка обоснования целесообразности проведения совместных
			// условий
			if (this.expediency == null || this.expediency.isEmpty()) {
				message = "Не заполнены обоснования целесообразности проведения совместных условий" + " " + tabNameJustification;
				vr.getErrMessages().add(message);
			}
		}
		// Проверка формулировки и обоснование идеи
		if (this.ideaFormulation == null || this.ideaFormulation.isEmpty()) {
			message = "Не заполнена формулировка и обоснование идеи" + " " + tabNameJustification;
			vr.getErrMessages().add(message);
		}
		// Проверка уровня новизны научной идеи (гипотезы)
		if (this.ideaInnovation == null || this.ideaInnovation.isEmpty()) {
			message = "Не заполнен уровень новизны научной идеи" + " " + tabNameJustification;
			vr.getErrMessages().add(message);
		}
		// Проверка структуры исследования
		if (this.structureOfStudy == null || this.structureOfStudy.isEmpty()) {
			message = "Не заполнена структура исследования" + " " + tabNameJustification;
			vr.getErrMessages().add(message);
		}
		// Проверка ожидаемых результатов НИР
		if (this.resultsNir == null || this.resultsNir.isEmpty()) {
			message = "Не заполнены ожидаемые результаты НИР" + " " + tabNameJustification;
			vr.getErrMessages().add(message);
		}
		// Проверка возможные области использования результатов исследования
		if (this.usingResults == null || this.usingResults.isEmpty()) {
			message = "Не заполнены возможные области использования результатов исследования" + " " + tabNameJustification;
			vr.getErrMessages().add(message);
		}
		// Проверка характеристики научного коллектива
		if (this.teamCharacteristic == null || this.teamCharacteristic.isEmpty()) {
			message = "Не заполнены характеристики научного коллектива" + " " + tabNameJustification;
			vr.getErrMessages().add(message);
		}
		// Проверка обеспеченности работы основным оборудованием, необходимым
		// для ее выполнения
		if (this.provisionEquipment == null || this.provisionEquipment.isEmpty()) {
			message = "Не заполнена обеспеченность работы основным оборудованием, необходимым для её выполнения" + " " + tabNameJustification;
			vr.getErrMessages().add(message);
		}
		// Проверка сведений об участии
		if (this.previousKonkurs == null || this.previousKonkurs.isEmpty()) {
			message = "Не заполнены сведения об участии" + " " + tabNameJustification;
			vr.getErrMessages().add(message);
		}
		return vr;
	}

}
