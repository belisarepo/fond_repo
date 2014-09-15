package by.belisa.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import by.belisa.entity.FizInfo;
import by.belisa.entity.PublicationM;

public class FizInfoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4274075506976791875L;
	private Integer id;
	private List<PublicationMDTO> publications = new ArrayList<PublicationMDTO>();
	
	public FizInfoDTO(){
		
	}
	public FizInfoDTO(FizInfo fizInfo, boolean isMolod){
		this.id = fizInfo.getId();
		for (PublicationM publM : fizInfo.getPublication()){
			if (!isMolod){
				int type = publM.getPublicationType().getId();
				if (type==4 || type==5){
					continue;
				}
			}
			this.publications.add(new PublicationMDTO(publM));
		}
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<PublicationMDTO> getPublications() {
		return publications;
	}
	public void setPublications(List<PublicationMDTO> publications) {
		this.publications = publications;
	}
	
}
