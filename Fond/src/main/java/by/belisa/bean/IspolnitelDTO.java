package by.belisa.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import by.belisa.entity.Ispolnitel;
import by.belisa.entity.UchStepeni;
import by.belisa.entity.UchZvaniy;

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
	private Integer[] uchStepeniIdArr;
	private String uchStepeniNames;
	private Integer[] uchZvaniyIdArr;
	private String uchZvaniyNames;
	private String post;
	private Integer zayavkaFIId;
	private FizInfoDTO fizInfo;
	private Integer fizInfoId;
	public IspolnitelDTO(){
		
	}
	
	
	public IspolnitelDTO(Integer id, String post, Integer[] uchStepenIdArr, Integer[] uchZvaniyIdArr, Integer orgId) {
		super();
		this.id = id;
		this.post = post;
		this.orgId = orgId;
		this.uchStepeniIdArr = uchStepenIdArr;
		this.uchZvaniyIdArr = uchZvaniyIdArr;
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
			
			
			this.uchStepeniIdArr = new Integer[entity.getUchStepeniList().size()];
			this.uchStepeniNames="";
			int n=0;
			for (UchStepeni i : entity.getUchStepeniList()){
				this.uchStepeniIdArr[n]=i.getId();
				this.uchStepeniNames+=i.getFullName()+"<br/>";
				n++;
			}
			
			this.uchZvaniyIdArr = new Integer[entity.getUchZvaniyList().size()];
			this.uchZvaniyNames="";
			n=0;
			for (UchZvaniy i : entity.getUchZvaniyList()){
				this.uchZvaniyIdArr[n]=i.getId();
				this.uchZvaniyNames+=i.getFullName()+"<br/>";
				n++;
			}
			
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
	
	
	public Integer[] getUchStepeniIdArr() {
		return uchStepeniIdArr;
	}


	public void setUchStepeniIdArr(Integer[] uchStepeniIdArr) {
		this.uchStepeniIdArr = uchStepeniIdArr;
	}


	public String getUchStepeniNames() {
		return uchStepeniNames;
	}


	public void setUchStepeniNames(String uchStepeniNames) {
		this.uchStepeniNames = uchStepeniNames;
	}


	public Integer[] getUchZvaniyIdArr() {
		return uchZvaniyIdArr;
	}


	public void setUchZvaniyIdArr(Integer[] uchZvaniyIdArr) {
		this.uchZvaniyIdArr = uchZvaniyIdArr;
	}


	
	public String getUchZvaniyNames() {
		return uchZvaniyNames;
	}


	public void setUchZvaniyNames(String uchZvaniyNames) {
		this.uchZvaniyNames = uchZvaniyNames;
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
