package by.belisa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="STK")
@SequenceGenerator(name="PK",sequenceName="SEQ_STK")
public class CalculationArticle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2033552655969167306L;
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@Column(name="NAME")
	private String name;
	@Column(name="KOD")
	private String code;
	@Column(name="YEAR")
	private Short year;
	@Column(name="NAME_P")
	private String fullName;
	@Column(name="STKITOG")
	private Integer stkItog;
	@Column(name="ZNAK")
	private String sign;
	@Column(name="ITOG")
	private Boolean itog;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Short getYear() {
		return year;
	}
	public void setYear(Short year) {
		this.year = year;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Integer getStkItog() {
		return stkItog;
	}
	public void setStkItog(Integer stkItog) {
		this.stkItog = stkItog;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Boolean getItog() {
		return itog;
	}
	public void setItog(Boolean itog) {
		this.itog = itog;
	}
	
	
	

}
