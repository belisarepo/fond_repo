package by.belisa.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Lob;

import by.belisa.entity.FizInfo;
import by.belisa.entity.Organization;
import by.belisa.entity.ZayavkaFI;

public class ZayavkaFIDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2104550708006725459L;
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	private Integer id;
	private String konkursNameR;
	private Integer konkursId;
	private Integer tipKonkursaId;
	private String tipKonkursaName;
	private String sectionFondNameR;
	private Integer sectionFondId;
	private String otraslNaukaName;
	private Integer otraslNaukaId;
	private String prioritetNaukaName;
	private Integer prioritetNaukaId;
	private Long userId;
	private String temaName;
	private String orgName;
	private Integer orgId;
	private String orgEmail;
	private String okoguName;
	private String orgAddress;
	private String udk;
	private Set<IspolnitelDTO> ispolniteliDTO = new HashSet<IspolnitelDTO>();
	private Set<OrgDTO> soOrg = new HashSet<OrgDTO>();
	
	
	private Integer idRk;
	private String fioRk;
	private String fullFioRk;
	private String orgNameRk;
	private Integer orgIdRk;
	private String birthdayRk;
	private String uchStepenNameRk;
	private Integer uchStepenIdRk;
	private String uchZvaniyNameRk;
	private Integer uchZvaniyIdRk;
	private String postRk;
	private String labRk;
	private String jobPhoneRk;
	private String homePhoneRk;
	private String mobilePhoneRk;
	private String addressRk;
	private String emailRk;
	private String biographyRk;
	
	private Integer idRkNr;
	private String fioRkNr;
	private String fullFioRkNr;
	private String orgNameRkNr;
	private Integer orgIdRkNr;
	private String birthdayRkNr;
	private String uchStepenNameRkNr;
	private Integer uchStepenIdRkNr;
	private String uchZvaniyNameRkNr;
	private Integer uchZvaniyIdRkNr;
	private String postRkNr;
	
	private String orgNrName;
	private Integer orgNrId;
	private String orgNrEmail;
	private String orgNrAddress;
	
	private String lastingDeadline;
	private String startDeadline;
	private String stopDeadline;
	private Float costAll;
	private Float costFirstYear;
	
	private String keyWords;
	private String jobGoal;
	private String idea;
	private String results;
	
	private String goal;
	private String analizResults;
	private String reserveAuthors;
	private String expediency;
	private String ideaFormulation;
	private String ideaInnovation;
	private String structureOfStudy;
	private String resultsNir;
	private String usingResults;
	private String teamCharacteristic;
	private String provisionEquipment;
	private String previousKonkurs;
	
	
	

	public ZayavkaFIDTO() {

	}

	public ZayavkaFIDTO(ZayavkaFI zayavkaFI) {
		if (zayavkaFI != null) {
			this.id = zayavkaFI.getId();
			this.konkursId = zayavkaFI.getKonkursy() != null ? zayavkaFI.getKonkursy().getId() : null;
			this.konkursNameR = zayavkaFI.getKonkursy() != null ? zayavkaFI.getKonkursy().getNameR() : "";
			this.sectionFondId = zayavkaFI.getSectionFond() != null ? zayavkaFI.getSectionFond().getId() : 0;
			this.sectionFondNameR = zayavkaFI.getSectionFond() != null ? zayavkaFI.getSectionFond().getNameR() : "";
			this.otraslNaukaId = zayavkaFI.getOtraslNauka() != null ? zayavkaFI.getOtraslNauka().getId() : 0;
			this.otraslNaukaName = zayavkaFI.getOtraslNauka() != null ? zayavkaFI.getOtraslNauka().getName() : "";
			this.prioritetNaukaId = zayavkaFI.getPrioritetNauka() != null ? zayavkaFI.getPrioritetNauka().getId() : 0;
			this.prioritetNaukaName = zayavkaFI.getPrioritetNauka() != null ? zayavkaFI.getPrioritetNauka().getName() : "";
			this.userId = zayavkaFI.getAnketa() !=null ? zayavkaFI.getAnketa().getId() : null;
			this.temaName = zayavkaFI.getTemaZName();
			this.tipKonkursaId = zayavkaFI.getKonkursy().getTipKonkursa()!=null ? zayavkaFI.getKonkursy().getTipKonkursa().getId() : null;
			this.tipKonkursaName = zayavkaFI.getKonkursy().getTipKonkursa()!=null ? zayavkaFI.getKonkursy().getTipKonkursa().getName() : "";
			this.udk = zayavkaFI.getCodeUdk();
			this.lastingDeadline = zayavkaFI.getLastingDeadline();
			this.startDeadline = zayavkaFI.getStartDeadline()!=null ? dateFormat.format(zayavkaFI.getStartDeadline()): null;
			this.stopDeadline = zayavkaFI.getStopDeadline()!=null ? dateFormat.format(zayavkaFI.getStopDeadline()): null;
			this.costAll = zayavkaFI.getCostAll();
			this.costFirstYear = zayavkaFI.getCostFirstYear();
			
			if (zayavkaFI.getOrganization() == null){
				if (zayavkaFI.getAnketa() != null && zayavkaFI.getAnketa().getOrg()!=null){
					this.orgId = zayavkaFI.getAnketa().getOrg().getId();
					this.orgName = zayavkaFI.getAnketa().getOrg().getName();
					this.orgEmail = zayavkaFI.getAnketa().getOrg().getEmail();
					this.okoguName = zayavkaFI.getAnketa().getOrg().getOkogu().getName();
					this.orgAddress = zayavkaFI.getAnketa().getOrg().getAddress();
				}
			}else{
				this.orgId = zayavkaFI.getOrganization().getId();
				this.orgName = zayavkaFI.getOrganization().getName();
				this.orgEmail = zayavkaFI.getOrganization().getEmail();
				this.okoguName = zayavkaFI.getOrganization().getOkogu().getName();
				this.orgAddress = zayavkaFI.getOrganization().getAddress();
			}
			
			
			if (zayavkaFI.getRukovoditel()!=null){
				this.addressRk = zayavkaFI.getRukovoditel().getAddress();
				this.biographyRk = zayavkaFI.getRukovoditel().getBiography();
				this.birthdayRk = zayavkaFI.getRukovoditel().getBirthday()!=null ? dateFormat.format(zayavkaFI.getRukovoditel().getBirthday()): null;
				this.emailRk = zayavkaFI.getRukovoditel().getEmail();
				this.fioRk = zayavkaFI.getRukovoditel().getFio();
				this.fullFioRk = zayavkaFI.getRukovoditel().getFullFio();
				this.homePhoneRk = zayavkaFI.getRukovoditel().getHomePhone();
				this.idRk = zayavkaFI.getRukovoditel().getId();
				this.jobPhoneRk = zayavkaFI.getRukovoditel().getJobPhone();
				this.labRk = zayavkaFI.getRukovoditel().getLab();
				this.mobilePhoneRk = zayavkaFI.getRukovoditel().getMobilePhone();
				this.orgIdRk = zayavkaFI.getRukovoditel().getOrg()!=null ? zayavkaFI.getRukovoditel().getOrg().getId() : null;
				this.orgNameRk = zayavkaFI.getRukovoditel().getOrg()!=null ? zayavkaFI.getRukovoditel().getOrg().getName() : "";
				this.postRk = zayavkaFI.getRukovoditel().getPost();
				this.uchStepenIdRk = zayavkaFI.getRukovoditel().getUchStepeni()!=null ? zayavkaFI.getRukovoditel().getUchStepeni().getId() : null;
				this.uchStepenNameRk = zayavkaFI.getRukovoditel().getUchStepeni()!=null ? zayavkaFI.getRukovoditel().getUchStepeni().getName() : "";
				this.uchZvaniyIdRk = zayavkaFI.getRukovoditel().getUchZvaniy()!=null ? zayavkaFI.getRukovoditel().getUchZvaniy().getId() : null;
				this.uchZvaniyNameRk = zayavkaFI.getRukovoditel().getUchZvaniy()!=null ? zayavkaFI.getRukovoditel().getUchZvaniy().getName() : "";
			}else{
				this.addressRk = zayavkaFI.getAnketa().getAddress();
				this.biographyRk = zayavkaFI.getAnketa().getBiography();
				this.birthdayRk = zayavkaFI.getAnketa().getBirthday()!=null ? dateFormat.format(zayavkaFI.getAnketa().getBirthday()): null;
				this.emailRk = zayavkaFI.getAnketa().getEmail();
				this.fioRk = zayavkaFI.getAnketa().getFio();
				this.fullFioRk = zayavkaFI.getAnketa().getFullFio();
				this.homePhoneRk = zayavkaFI.getAnketa().getHomePhone();
				this.jobPhoneRk = zayavkaFI.getAnketa().getJobPhone();
				this.labRk = zayavkaFI.getAnketa().getLab();
				this.mobilePhoneRk = zayavkaFI.getAnketa().getMobilePhone();
				this.orgIdRk = zayavkaFI.getAnketa().getOrg()!=null ? zayavkaFI.getAnketa().getOrg().getId() : null;
				this.orgNameRk = zayavkaFI.getAnketa().getOrg()!=null ? zayavkaFI.getAnketa().getOrg().getName() : "";
				this.postRk = zayavkaFI.getAnketa().getPost();
				this.uchStepenIdRk = zayavkaFI.getAnketa().getUchStepeni()!=null ? zayavkaFI.getAnketa().getUchStepeni().getId() : null;
				this.uchStepenNameRk = zayavkaFI.getAnketa().getUchStepeni()!=null ? zayavkaFI.getAnketa().getUchStepeni().getName() : "";
				this.uchZvaniyIdRk = zayavkaFI.getAnketa().getUchZvaniy()!=null ? zayavkaFI.getAnketa().getUchZvaniy().getId() : null;
				this.uchZvaniyNameRk = zayavkaFI.getAnketa().getUchZvaniy()!=null ? zayavkaFI.getAnketa().getUchZvaniy().getName() : "";
			}
			
			if (zayavkaFI.getRukovoditelNr()!=null){
				this.fioRkNr= zayavkaFI.getRukovoditelNr().getFio();
				this.fullFioRkNr= zayavkaFI.getRukovoditelNr().getFullFio();
				this.uchStepenIdRkNr= zayavkaFI.getRukovoditelNr().getUchStepeni()!=null ? zayavkaFI.getRukovoditelNr().getUchStepeni().getId() : null;
				this.uchStepenNameRkNr= zayavkaFI.getRukovoditelNr().getUchStepeni()!=null ? zayavkaFI.getRukovoditelNr().getUchStepeni().getName() : "";
				this.uchZvaniyIdRkNr= zayavkaFI.getRukovoditelNr().getUchZvaniy()!=null ? zayavkaFI.getRukovoditelNr().getUchZvaniy().getId() : null;
				this.uchZvaniyNameRkNr= zayavkaFI.getRukovoditelNr().getUchZvaniy()!=null ? zayavkaFI.getRukovoditelNr().getUchZvaniy().getName() : "";
				this.birthdayRkNr= zayavkaFI.getRukovoditelNr().getBirthday()!=null ? dateFormat.format(zayavkaFI.getRukovoditelNr().getBirthday()): null;
				this.postRkNr= zayavkaFI.getRukovoditelNr().getPost();
			}
			if (zayavkaFI.getOrgNR()!=null){
				this.orgNrId=zayavkaFI.getOrgNR().getId();
				this.orgNrName=zayavkaFI.getOrgNR().getNameR();
				this.orgNrAddress=zayavkaFI.getOrgNR().getAddress();
				this.orgNrEmail=zayavkaFI.getOrgNR().getEmail();
			}
			if (!zayavkaFI.getSoOrgs().isEmpty()){
				for (Organization org : zayavkaFI.getSoOrgs()){
					this.soOrg.add(new OrgDTO(org));
				}
			}
			if (zayavkaFI.getAnnotation()!=null){
				this.keyWords = zayavkaFI.getAnnotation().getKeyWords();
				this.jobGoal = zayavkaFI.getAnnotation().getJobGoal();
				this.idea = zayavkaFI.getAnnotation().getIdea();
				this.results = zayavkaFI.getAnnotation().getResults();
			}
			if (zayavkaFI.getObosnovanie()!=null){
				this.goal=zayavkaFI.getObosnovanie().getGoal();
				this.analizResults=zayavkaFI.getObosnovanie().getAnalizResults();
				this.reserveAuthors=zayavkaFI.getObosnovanie().getReserveAuthors();
				this.expediency=zayavkaFI.getObosnovanie().getExpediency();
				this.ideaFormulation=zayavkaFI.getObosnovanie().getIdeaFormulation();
				this.ideaInnovation=zayavkaFI.getObosnovanie().getIdeaInnovation();
				this.structureOfStudy=zayavkaFI.getObosnovanie().getStructureOfStudy();
				this.resultsNir=zayavkaFI.getObosnovanie().getResultsNir();
				this.usingResults=zayavkaFI.getObosnovanie().getUsingResults();
				this.teamCharacteristic=zayavkaFI.getObosnovanie().getTeamCharacteristic();
				this.provisionEquipment=zayavkaFI.getObosnovanie().getProvisionEquipment();
				this.previousKonkurs=zayavkaFI.getObosnovanie().getPreviousKonkurs();		
							
			}
			
		}

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

	public String getJobGoal() {
		return jobGoal;
	}

	public void setJobGoal(String jobGoal) {
		this.jobGoal = jobGoal;
	}

	public String getIdea() {
		return idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getLastingDeadline() {
		return lastingDeadline;
	}

	public void setLastingDeadline(String lastingDeadline) {
		this.lastingDeadline = lastingDeadline;
	}

	public String getStartDeadline() {
		return startDeadline;
	}

	public void setStartDeadline(String startDeadline) {
		this.startDeadline = startDeadline;
	}

	public String getStopDeadline() {
		return stopDeadline;
	}

	public void setStopDeadline(String stopDeadline) {
		this.stopDeadline = stopDeadline;
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

	public Set<OrgDTO> getSoOrg() {
		return soOrg;
	}

	public void setSoOrg(Set<OrgDTO> soOrg) {
		this.soOrg = soOrg;
	}

	public String getOrgNrName() {
		return orgNrName;
	}

	public void setOrgNrName(String orgNrName) {
		this.orgNrName = orgNrName;
	}

	public Integer getOrgNrId() {
		return orgNrId;
	}

	public void setOrgNrId(Integer orgNrId) {
		this.orgNrId = orgNrId;
	}

	public String getOrgNrEmail() {
		return orgNrEmail;
	}

	public void setOrgNrEmail(String orgNrEmail) {
		this.orgNrEmail = orgNrEmail;
	}

	public String getOrgNrAddress() {
		return orgNrAddress;
	}

	public void setOrgNrAddress(String orgNrAddress) {
		this.orgNrAddress = orgNrAddress;
	}

	public Integer getIdRkNr() {
		return idRkNr;
	}

	public void setIdRkNr(Integer idRkNr) {
		this.idRkNr = idRkNr;
	}

	public String getFioRkNr() {
		return fioRkNr;
	}

	public void setFioRkNr(String fioRkNr) {
		this.fioRkNr = fioRkNr;
	}

	public String getFullFioRkNr() {
		return fullFioRkNr;
	}

	public void setFullFioRkNr(String fullFioRkNr) {
		this.fullFioRkNr = fullFioRkNr;
	}

	public String getOrgNameRkNr() {
		return orgNameRkNr;
	}

	public void setOrgNameRkNr(String orgNameRkNr) {
		this.orgNameRkNr = orgNameRkNr;
	}

	public Integer getOrgIdRkNr() {
		return orgIdRkNr;
	}

	public void setOrgIdRkNr(Integer orgIdRkNr) {
		this.orgIdRkNr = orgIdRkNr;
	}

	public String getBirthdayRkNr() {
		return birthdayRkNr;
	}

	public void setBirthdayRkNr(String birthdayRkNr) {
		this.birthdayRkNr = birthdayRkNr;
	}

	public String getUchStepenNameRkNr() {
		return uchStepenNameRkNr;
	}

	public void setUchStepenNameRkNr(String uchStepenNameRkNr) {
		this.uchStepenNameRkNr = uchStepenNameRkNr;
	}

	public Integer getUchStepenIdRkNr() {
		return uchStepenIdRkNr;
	}

	public void setUchStepenIdRkNr(Integer uchStepenIdRkNr) {
		this.uchStepenIdRkNr = uchStepenIdRkNr;
	}

	public String getUchZvaniyNameRkNr() {
		return uchZvaniyNameRkNr;
	}

	public void setUchZvaniyNameRkNr(String uchZvaniyNameRkNr) {
		this.uchZvaniyNameRkNr = uchZvaniyNameRkNr;
	}

	public Integer getUchZvaniyIdRkNr() {
		return uchZvaniyIdRkNr;
	}

	public void setUchZvaniyIdRkNr(Integer uchZvaniyIdRkNr) {
		this.uchZvaniyIdRkNr = uchZvaniyIdRkNr;
	}

	public String getPostRkNr() {
		return postRkNr;
	}

	public void setPostRkNr(String postRkNr) {
		this.postRkNr = postRkNr;
	}

	public String getOkoguName() {
		return okoguName;
	}

	public void setOkoguName(String okoguName) {
		this.okoguName = okoguName;
	}

	public String getOrgAddress() {
		return orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	public String getOrgEmail() {
		return orgEmail;
	}

	public void setOrgEmail(String orgEmail) {
		this.orgEmail = orgEmail;
	}

	public Integer getTipKonkursaId() {
		return tipKonkursaId;
	}

	public void setTipKonkursaId(Integer tipKonkursaId) {
		this.tipKonkursaId = tipKonkursaId;
	}

	public String getTipKonkursaName() {
		return tipKonkursaName;
	}

	public void setTipKonkursaName(String tipKonkursaName) {
		this.tipKonkursaName = tipKonkursaName;
	}

	public String getUdk() {
		return udk;
	}

	public void setUdk(String udk) {
		this.udk = udk;
	}

	public Set<IspolnitelDTO> getIspolniteliDTO() {
		return ispolniteliDTO;
	}

	public void setIspolniteliDTO(Set<IspolnitelDTO> ispolniteliDTO) {
		this.ispolniteliDTO = ispolniteliDTO;
	}

	public Integer getIdRk() {
		return idRk;
	}

	public void setIdRk(Integer idRk) {
		this.idRk = idRk;
	}

	public String getFioRk() {
		return fioRk;
	}

	public void setFioRk(String fioRk) {
		this.fioRk = fioRk;
	}

	public String getFullFioRk() {
		return fullFioRk;
	}

	public void setFullFioRk(String fullFioRk) {
		this.fullFioRk = fullFioRk;
	}

	public String getOrgNameRk() {
		return orgNameRk;
	}

	public void setOrgNameRk(String orgNameRk) {
		this.orgNameRk = orgNameRk;
	}

	public Integer getOrgIdRk() {
		return orgIdRk;
	}

	public void setOrgIdRk(Integer orgIdRk) {
		this.orgIdRk = orgIdRk;
	}

	public String getBirthdayRk() {
		return birthdayRk;
	}

	public void setBirthdayRk(String birthdayRk) {
		this.birthdayRk = birthdayRk;
	}

	public String getUchStepenNameRk() {
		return uchStepenNameRk;
	}

	public void setUchStepenNameRk(String uchStepenNameRk) {
		this.uchStepenNameRk = uchStepenNameRk;
	}

	public Integer getUchStepenIdRk() {
		return uchStepenIdRk;
	}

	public void setUchStepenIdRk(Integer uchStepenIdRk) {
		this.uchStepenIdRk = uchStepenIdRk;
	}

	public String getUchZvaniyNameRk() {
		return uchZvaniyNameRk;
	}

	public void setUchZvaniyNameRk(String uchZvaniyNameRk) {
		this.uchZvaniyNameRk = uchZvaniyNameRk;
	}

	public Integer getUchZvaniyIdRk() {
		return uchZvaniyIdRk;
	}

	public void setUchZvaniyIdRk(Integer uchZvaniyIdRk) {
		this.uchZvaniyIdRk = uchZvaniyIdRk;
	}

	public String getPostRk() {
		return postRk;
	}

	public void setPostRk(String postRk) {
		this.postRk = postRk;
	}

	public String getLabRk() {
		return labRk;
	}

	public void setLabRk(String labRk) {
		this.labRk = labRk;
	}

	public String getJobPhoneRk() {
		return jobPhoneRk;
	}

	public void setJobPhoneRk(String jobPhoneRk) {
		this.jobPhoneRk = jobPhoneRk;
	}

	public String getHomePhoneRk() {
		return homePhoneRk;
	}

	public void setHomePhoneRk(String homePhoneRk) {
		this.homePhoneRk = homePhoneRk;
	}

	public String getMobilePhoneRk() {
		return mobilePhoneRk;
	}

	public void setMobilePhoneRk(String mobilePhoneRk) {
		this.mobilePhoneRk = mobilePhoneRk;
	}

	public String getAddressRk() {
		return addressRk;
	}

	public void setAddressRk(String addressRk) {
		this.addressRk = addressRk;
	}

	public String getEmailRk() {
		return emailRk;
	}

	public void setEmailRk(String emailRk) {
		this.emailRk = emailRk;
	}

	public String getBiographyRk() {
		return biographyRk;
	}

	public void setBiographyRk(String biographyRk) {
		this.biographyRk = biographyRk;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getTemaName() {
		return temaName;
	}

	public void setTemaName(String temaName) {
		this.temaName = temaName;
	}

	public String getPrioritetNaukaName() {
		return prioritetNaukaName;
	}

	public void setPrioritetNaukaName(String prioritetNaukaName) {
		this.prioritetNaukaName = prioritetNaukaName;
	}

	public Integer getPrioritetNaukaId() {
		return prioritetNaukaId;
	}

	public void setPrioritetNaukaId(Integer prioritetNaukaId) {
		this.prioritetNaukaId = prioritetNaukaId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOtraslNaukaName() {
		return otraslNaukaName;
	}

	public void setOtraslNaukaName(String otraslNaukaName) {
		this.otraslNaukaName = otraslNaukaName;
	}

	public Integer getOtraslNaukaId() {
		return otraslNaukaId;
	}

	public void setOtraslNaukaId(Integer otraslNaukaId) {
		this.otraslNaukaId = otraslNaukaId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKonkursNameR() {
		return konkursNameR;
	}

	public void setKonkursNameR(String konkursNameR) {
		this.konkursNameR = konkursNameR;
	}

	public Integer getKonkursId() {
		return konkursId;
	}

	public void setKonkursId(Integer konkursId) {
		this.konkursId = konkursId;
	}

	public String getSectionFondNameR() {
		return sectionFondNameR;
	}

	public void setSectionFondNameR(String sectionFondName) {
		this.sectionFondNameR = sectionFondName;
	}

	public Integer getSectionFondId() {
		return sectionFondId;
	}

	public void setSectionFondId(Integer sectionFondId) {
		this.sectionFondId = sectionFondId;
	}

}
