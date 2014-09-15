package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="CALC_OTHER_COSTS")
@SequenceGenerator(name="PK", sequenceName="SEQ_CALC_OTHER_COSTS")
public class CalcOtherCosts implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6781622257919065147L;
	
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@Column
	private float pn;
	@Column
	private String name;
	@Column
	private float sum;
	@Column
	private String note;
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
