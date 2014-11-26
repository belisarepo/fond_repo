package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CALCULATION_D")
@SequenceGenerator(name="PK",sequenceName="SEQ_CALCULATION_D")
public class CalculationD implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5251897808962246392L;
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@ManyToOne
	@JoinColumn(name="STK_ID")
	private CalculationArticle calcArticle;
	@ManyToOne
	@JoinColumn(name="DOGOVOR_ID")
	private Dogovor dogovor;
	@Column(name="SUM")
	private float sum;
	@Column(name="ARCHIV")
	private Boolean archiv;
	@Column(name="YEAR")
	private Short year;
	
	public Short getYear() {
		return year;
	}
	public void setYear(Short year) {
		this.year = year;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CalculationArticle getCalcArticle() {
		return calcArticle;
	}
	public void setCalcArticle(CalculationArticle calcArticle) {
		this.calcArticle = calcArticle;
	}
	public Dogovor getDogovor() {
		return dogovor;
	}
	public void setDogovor(Dogovor dogovor) {
		this.dogovor = dogovor;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public Boolean getArchiv() {
		return archiv;
	}
	public void setArchiv(Boolean archiv) {
		this.archiv = archiv;
	}

}
