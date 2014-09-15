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
@Table(name="CALC_MATERIALS")
@SequenceGenerator(name="PK", sequenceName="SEQ_CALC_MATERIALS")
public class CalcMaterials implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1623793837731319139L;
	
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@Column
	private float pn;
	@Column
	private String name;
	@Column
	private String unit;
	@Column
	private float count;
	@Column
	private float sum;
	
	
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
