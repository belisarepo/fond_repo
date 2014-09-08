package by.belisa.bean;

import java.io.Serializable;

import by.belisa.entity.CalcOtherCosts;

public class CalcOtherCostsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6106974998723299801L;
	
	private Integer id;
	private int pn;
	private String name;
	private int sum;
	private String note;
	
	
	
	public CalcOtherCostsDTO() {
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
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
	
}
