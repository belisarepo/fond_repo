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
@Table(name="CALC_OTHER_COSTS_SUM")
@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "zayavkaFI"))
public class CalcOtherCostsSum implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 863460442060147874L;
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "gen")
	private Integer id;
	@Column
	private Float sum;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@PrimaryKeyJoinColumn()
	private ZayavkaFI zayavkaFI;
	
	public CalcOtherCostsSum(){
		
	}
	public CalcOtherCostsSum(ZayavkaFI zayavkaFI){
		this.zayavkaFI = zayavkaFI;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getSum() {
		return sum;
	}
	public void setSum(Float sum) {
		this.sum = sum;
	}
	public ZayavkaFI getZayavkaFI() {
		return zayavkaFI;
	}
	public void setZayavkaFI(ZayavkaFI zayavkaFI) {
		this.zayavkaFI = zayavkaFI;
	}
	
}
