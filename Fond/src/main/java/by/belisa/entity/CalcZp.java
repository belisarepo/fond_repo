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
@Table(name="CALC_ZP")
@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "zayavkaFI"))
public class CalcZp implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5220364701701803360L;


	@Id
	@GeneratedValue(generator="gen")
	private Integer id;
	@Column
	private String name;
	@Column
	private int salary;
	@Column
	private int rate;
	@Column
	private int duration;
	@Column(name="FOND_ZP")
	private int fondZp;
	@Column
	private String note;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false)  
	@PrimaryKeyJoinColumn()
	private ZayavkaFI zayavkaFI;

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

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
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

	public ZayavkaFI getZayavkaFI() {
		return zayavkaFI;
	}

	public void setZayavkaFI(ZayavkaFI zayavkaFI) {
		this.zayavkaFI = zayavkaFI;
	}
	
	
}
