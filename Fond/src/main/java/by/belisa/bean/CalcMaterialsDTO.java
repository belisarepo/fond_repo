package by.belisa.bean;

import java.io.Serializable;

import by.belisa.entity.CalcMaterials;

public class CalcMaterialsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -985597745797207415L;
	
	private Integer id;
	private int pn;
	private String name;
	private String unit;
	private int count;
	private int sum;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPn() {
		return pn;
	}

	public void setPn(int pn) {
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	

}
