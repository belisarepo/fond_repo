package by.belisa.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import by.belisa.entity.CalculationArticle;
import by.belisa.entity.CalculationD;
import by.belisa.entity.Dogovor;

public class DogovorDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5151934612979579274L;
	
	public DogovorDTO(){
		
	}
	
	public DogovorDTO(Dogovor entity) {
		if (entity!=null){
			this.id = entity.getId();
			this.orgName = entity.getOrg().getFullNameR();
			this.orgId = entity.getOrg().getId();
			if(!entity.getCalculationList().isEmpty()){
				for (CalculationD c:entity.getCalculationList()){
					if (this.calculationMap.containsKey(c.getCalcArticle())){
						this.calculationMap.get(c.getCalcArticle()).add(c);
					}else{
						this.calculationMap.put(c.getCalcArticle(), new ArrayList<CalculationD>(Arrays.asList(c)));
					}
				}
			}
		}
		
	}

	private Integer id;
	private String orgName;
	private Integer orgId;
	private Map<CalculationArticle,List<CalculationD>> calculationMap = new LinkedHashMap<CalculationArticle,List<CalculationD>>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Map<CalculationArticle, List<CalculationD>> getCalculationMap() {
		return calculationMap;
	}
	public void setCalculationMap(Map<CalculationArticle, List<CalculationD>> calculationMap) {
		this.calculationMap = calculationMap;
	}
	
}
