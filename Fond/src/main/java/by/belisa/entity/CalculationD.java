package by.belisa.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CALCULATION_D")
@SequenceGenerator(name="PK",sequenceName="SEQ_CALCULATION_D")
public class CalculationD implements Serializable,Comparable<CalculationD>{

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
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
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
	@Override
	public int compareTo(CalculationD o) {
		String code1 = this.calcArticle.getCode();
		String code2 = o.calcArticle.getCode();
		int year1 = this.year;
		int year2 = o.year;
		if (code1.compareTo(code2)>0){
			return 1;
		}else if (code1.compareTo(code2)<0){
			return -1;
		}else{
			if (year1>year2){
				return 1;
			}else if (year1<year2){
				return -1;
			}else{
				return 0;
			}
		}
	}

}
