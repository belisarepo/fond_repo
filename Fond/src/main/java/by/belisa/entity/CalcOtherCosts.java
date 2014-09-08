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
@Table(name="CALC_OTHER_COSTS")
@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "zayavkaFI"))
public class CalcOtherCosts implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6781622257919065147L;
	
	@Id
	@GeneratedValue(generator="gen")
	private Integer id;
	@Column
	private int pn;
	@Column
	private String name;
	@Column
	private int sum;
	@Column
	private String note;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false)  
	@PrimaryKeyJoinColumn()
	private ZayavkaFI zayavkaFI;
	

}
