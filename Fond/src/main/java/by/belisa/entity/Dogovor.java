package by.belisa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
