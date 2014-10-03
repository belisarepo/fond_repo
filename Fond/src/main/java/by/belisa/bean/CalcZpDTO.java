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
	private float salary;
	private float rate;
	private float duration;
	private float fondZp;
	private String note;

	
	public CalcZpDTO() {
	}


	
	public CalcZpDTO(Integer id, String name, float salary, float rate, float duration, float fondZp, String note) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.rate = rate;
		this.duration = duration;
		this.fondZp = fondZp;
		this.note = note;
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
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getDuration() {
		return duration;
	}
	public void setDuration(float duration) {
		this.duration = duration;
	}
	public float getFondZp() {
		return fondZp;
	}
	public void setFondZp(float fondZp) {
		this.fondZp = fondZp;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

}
