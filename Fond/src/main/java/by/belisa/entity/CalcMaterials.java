package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="CALC_MATERIALS")
@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "zayavkaFI"))
public class CalcMaterials implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1623793837731319139L;
	
	@Id
	@GeneratedValue(generator="gen")
	private Integer id;
	@Column
	private int pn;
	@Column
	private String name;
	@Column
	private String unit;
	@Column
	private int count;
	@Column
	private int sum;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false)  
	@PrimaryKeyJoinColumn()
	private ZayavkaFI zayavkaFI;

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

	public ZayavkaFI getZayavkaFI() {
		return zayavkaFI;
	}

	public void setZayavkaFI(ZayavkaFI zayavkaFI) {
		this.zayavkaFI = zayavkaFI;
	}

	
	
}
