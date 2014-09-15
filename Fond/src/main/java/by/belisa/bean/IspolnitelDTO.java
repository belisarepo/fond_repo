package by.belisa.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import by.belisa.entity.Ispolnitel;

public class IspolnitelDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4304052244421863032L;
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private Integer id;
	private String name;
	private String surname;
	private String patronymic;
	private String birthday;
	private Integer orgId;
	private String orgName;
	private Integer uchStepeniId;
	private String uchStepeniName;
	private Integer uchZvaniyId;
	private String uchZvaniyName;
	private String post;
	private Integer zayavkaFIId;
	private FizInfoDTO fizInfo;
	private Integer fizInfoId;
	public IspolnitelDTO(){
		
	}
	
	
	public IspolnitelDTO(Ispolnitel entity, boolean withPubl) {
		if (entity!=null){
			this.id = entity.getId();
			this.name = entity.getName();
			this.surname = entity.getSurname();
			this.patronymic = entity.getPatronymic();
			this.birthday = entity.getBirthday()!=null ? dateFormat.format(entity.getBirthday()): null;
			this.orgId = entity.getOrg()!=null ? entity.getOrg().getId() : null;
			this.orgName = entity.getOrg()!=null ? entity.getOrg().getName() : "";
			this.uchStepeniId =  entity.getUchStepeni()!=null ? entity.getUchStepeni().getId() : null;
			this.uchStepeniName = entity.getUchStepeni()!=null ? entity.getUchStepeni().getFullName() : "";
			this.uchZvaniyId = entity.getUchZvaniy()!=null ? entity.getUchZvaniy().getId() : null;
			this.uchZvaniyName = entity.getUchZvaniy()!=null ? entity.getUchZvaniy().getFullName() : "";
			this.post = entity.getPost();
			this.zayavkaFIId = entity.getZayavkaFI().getId();
			this.fizInfoId = entity.getFizInfo().getId();
			if (withPubl){
				this.fizInfo = new FizInfoDTO(entity.getFizInfo(),true);
			}
			
		}
		
	}


	public FizInfoDTO getFizInfo() {
		return fizInfo;
	}


	public void setFizInfo(FizInfoDTO fizInfo) {
		this.fizInfo = fizInfo;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Integer getUchStepeniId() {
		return uchStepeniId;
	}
	public void setUchStepeniId(Integer uchStepeniId) {
		this.uchStepeniId = uchStepeniId;
	}
	public String getUchStepeniName() {
		return uchStepeniName;
	}
	public void setUchStepeniName(String uchStepeniName) {
		this.uchStepeniName = uchStepeniName;
	}
	public Integer getUchZvaniyId() {
		return uchZvaniyId;
	}
	public void setUchZvaniyId(Integer uchZvaniyId) {
		this.uchZvaniyId = uchZvaniyId;
	}
	public String getUchZvaniyName() {
		return uchZvaniyName;
	}
	public void setUchZvaniyName(String uchZvaniyName) {
		this.uchZvaniyName = uchZvaniyName;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Integer getZayavkaFIId() {
		return zayavkaFIId;
	}
	public void setZayavkaFIId(Integer zayavkaFIId) {
		this.zayavkaFIId = zayavkaFIId;
	}


	public Integer getFizInfoId() {
		return fizInfoId;
	}


	public void setFizInfoId(Integer fizInfoId) {
		this.fizInfoId = fizInfoId;
	}
	
	

}
