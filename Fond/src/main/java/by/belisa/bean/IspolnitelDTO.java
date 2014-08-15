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
	
	public IspolnitelDTO(){
		
	}
	
	
	public IspolnitelDTO(Ispolnitel entity) {
		if (entity!=null){
			this.id = entity.getId();
			this.name = entity.getName();
			this.surname = entity.getSurname();
			this.patronymic = entity.getPatronymic();
			this.birthday = entity.getBirthday()!=null ? dateFormat.format(entity.getBirthday()): null;
			this.orgId = entity.getOrg().getId();
			this.orgName = entity.getOrg().getName();
			this.uchStepeniId = entity.getUchStepeni().getId();
			this.uchStepeniName = entity.getUchStepeni().getFullName();
			this.uchZvaniyId = entity.getUchZvaniy().getId();
			this.uchZvaniyName = entity.getUchZvaniy().getFullName();
			this.post = entity.getPost();
			this.zayavkaFIId = entity.getZayavkaFI().getId();
		}
		
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
	
	

}