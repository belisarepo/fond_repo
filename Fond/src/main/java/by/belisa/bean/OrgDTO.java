package by.belisa.bean;

import java.io.Serializable;

import by.belisa.entity.Organization;

public class OrgDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3962334779407152977L;
	
	private Integer id;
	private String name;
	private String okoguName;
	private String address;
	private String email;
	
	public OrgDTO(){
		
	}
	
	public OrgDTO(Organization org){
		this.id=org.getId();
		this.address=org.getAddress();
		this.email=org.getEmail();
		this.name=org.getName();
		this.okoguName=org.getOkogu().getName();
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
	
	public String getOkoguName() {
		return okoguName;
	}

	public void setOkoguName(String okoguName) {
		this.okoguName = okoguName;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
