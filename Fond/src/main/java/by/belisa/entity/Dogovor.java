package by.belisa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

@Entity
@Table(name="DOGOVOR")
@SequenceGenerator(name="PK", sequenceName="SEQ_DOGOVOR")
public class Dogovor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8393510865293283579L;
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ZAYAVKA_FI_ID", unique=true)
	private ZayavkaFI zayavkaFI;
	@OneToMany(mappedBy="dogovor")
	private List<JobCalendar> jobCalendarList = new ArrayList<JobCalendar>();
	@Column(name="SROKN")
	private Date srokN;
	@Column(name="SROKK")
	private Date srokK;
	@ManyToOne
	@JoinColumn(name="ORG_ISP_ID")
	private Organization org;
	@OneToMany(mappedBy="dogovor")
	@Sort(type=SortType.NATURAL)
	private SortedSet<CalculationD> calculationList = new TreeSet<CalculationD>();
	
	
	
	public SortedSet<CalculationD> getCalculationList() {
		return calculationList;
	}
	public void setCalculationList(SortedSet<CalculationD> calculationList) {
		this.calculationList = calculationList;
	}
	public Organization getOrg() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org = org;
	}
	public Date getSrokN() {
		return srokN;
	}
	public void setSrokN(Date srokN) {
		this.srokN = srokN;
	}
	public Date getSrokK() {
		return srokK;
	}
	public void setSrokK(Date srokK) {
		this.srokK = srokK;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ZayavkaFI getZayavkaFI() {
		return zayavkaFI;
	}
	public void setZayavkaFI(ZayavkaFI zayavkaFI) {
		this.zayavkaFI = zayavkaFI;
	}
	public List<JobCalendar> getJobCalendarList() {
		return jobCalendarList;
	}
	public void setJobCalendarList(List<JobCalendar> jobCalendarList) {
		this.jobCalendarList = jobCalendarList;
	}
	
	

}
