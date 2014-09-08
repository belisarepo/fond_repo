package by.belisa.bean;

import java.io.Serializable;

import by.belisa.entity.CalcZp;

public class CalcZpDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5957262441493682920L;
	
	private Integer id;
	private String name;
	private int salary;
	private float rate;
	private int duration;
	private int fondZp;
	private String note;

	
	public CalcZpDTO() {
	}


	public CalcZpDTO(CalcZp calcZp){
		this.id = calcZp.getId();
		this.name = calcZp.getName(); 
		this.salary = calcZp.getSalary();
		this.rate = calcZp.getRate();
		this.duration = calcZp.getDuration();
		this.fondZp = calcZp.getFondZp();
		this.note = calcZp.getNote();
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getFondZp() {
		return fondZp;
	}
	public void setFondZp(int fondZp) {
		this.fondZp = fondZp;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

}
