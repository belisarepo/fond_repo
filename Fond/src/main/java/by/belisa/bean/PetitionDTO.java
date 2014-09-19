package by.belisa.bean;

import java.io.Serializable;

import by.belisa.entity.Petition;

public class PetitionDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2375251147299664764L;
	
	private Integer id;
	private String name;
	
	public PetitionDTO(){
		
	}
	public PetitionDTO(Petition entity){
		this.id = entity.getId();
		this.name = entity.getName();
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
	

}
