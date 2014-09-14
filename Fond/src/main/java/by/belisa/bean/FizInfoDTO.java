package by.belisa.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import by.belisa.entity.FizInfo;
import by.belisa.entity.PublicationM;

public class FizInfoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4274075506976791875L;
	private Integer id;
	private Set<PublicationMDTO> publications = new HashSet<PublicationMDTO>();
	
	public FizInfoDTO(){
		
	}
	public FizInfoDTO(FizInfo fizInfo){
		this.id = fizInfo.getId();
		for (PublicationM publM : fizInfo.getPublication()){
			this.publications.add(new PublicationMDTO(publM));
		}
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<PublicationMDTO> getPublications() {
		return publications;
	}
	public void setPublications(Set<PublicationMDTO> publications) {
		this.publications = publications;
	}
	
}
