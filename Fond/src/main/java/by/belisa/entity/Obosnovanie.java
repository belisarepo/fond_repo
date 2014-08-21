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
@Entity
@Table(name="OBOSNOVANIE")
@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "zayavkaFI"))

public class Obosnovanie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2437192977268123834L;
	@Id
	@Column(name = "id")  
	@GeneratedValue(generator = "gen")  
	private Integer id;
	
	@Column(name="TEMA")
	private String tema;
	
	@Lob
	@Column(name="GOAL")
	private String goal;
	
	@Lob
	@Column(name="ANALIZ_RESULTS")
	private String analizResults;
	
	@Lob
	@Column(name="RESERVE_AUTHORS")
	private String reserveAuthors;
	
	@Lob
	@Column(name="EXPEDIENCY")
	private String expediency;
	
	@Lob
	@Column(name="IDEA_FORMULATION")
	private String ideaFormulation;
	
	@Lob
	@Column(name="IDEA_INNOVATION")
	private String ideaInnovation;
	
	@Lob
	@Column(name="STRUCTURE_OF_STUDY")
	private String structureOfStudy;
	
	@Lob
	@Column(name="NIR_RESULTS")
	private String resultsNir;
	
	@Lob
	@Column(name="USING_RESULTS")
	private String usingResults;
	
	@Lob
	@Column(name="TEAM_CHARACTERISTIC")
	private String teamCharacteristic;
	
	@Lob
	@Column(name="PROVISION_EQUIPMENT")
	private String provisionEquipment;
	
	@Lob
	@Column(name="PREVIOUS_KONKURS")
	private String previousKonkurs;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false)  
	@PrimaryKeyJoinColumn()
	private ZayavkaFI zayavkaFI;

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
	
	
}
