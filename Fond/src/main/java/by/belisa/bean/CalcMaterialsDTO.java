package by.belisa.bean;

import java.io.Serializable;

import by.belisa.entity.CalcMaterials;

public class CalcMaterialsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -985597745797207415L;
	
	private Integer id;
	private float pn;
	private String name;
	private String unit;
	private float count;
	private float sum;
	
	public CalcMaterialsDTO() {
	}

	public CalcMaterialsDTO(CalcMaterials calcMaterials) {
		this.id = calcMaterials.getId();
		this.pn = calcMaterials.getPn();
		this.name = calcMaterials.getName();
		this.unit = calcMaterials.getUnit();
		this.count = calcMaterials.getCount();
		this.sum = calcMaterials.getSum();
	}
	



	public CalcMaterialsDTO(Integer id, String name, String unit, float count, float sum) {
		super();
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.count = count;
		this.sum = sum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getPn() {
		return pn;
	}

	public void setPn(float pn) {
		this.pn = pn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getCount() {
		return count;
	}

	public void setCount(float count) {
		this.count = count;
	}

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}
	
	

}
