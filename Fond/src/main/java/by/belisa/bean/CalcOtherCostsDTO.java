package by.belisa.bean;

import java.io.Serializable;

import by.belisa.entity.CalcOtherCosts;

public class CalcOtherCostsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6106974998723299801L;
	
	private Integer id;
	private float pn;
	private String name;
	private float sum;
	private String note;
	
	
	
	public CalcOtherCostsDTO() {
	}
	
	public CalcOtherCostsDTO(Integer id, String name, float sum, String note) {
		super();
		this.id = id;
		this.name = name;
		this.sum = sum;
		this.note = note;
	}

	public CalcOtherCostsDTO(CalcOtherCosts calcOtherCosts) {
		this.id = calcOtherCosts.getId();
		this.pn = calcOtherCosts.getPn();
		this.name = calcOtherCosts.getName();
		this.sum = calcOtherCosts.getSum();
		this.note = calcOtherCosts.getNote();
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
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
	
}
