package by.belisa.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="JOB_CALENDAR")
@SequenceGenerator(name="PK", sequenceName="SEQ_JOB_CALENDAR")
public class JobCalendar implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3521061970710205337L;
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="DOGOVOR_ID")
	private Dogovor dogovor;
	@Column(name="ETAP_NUMBER")
	private Integer etapNumber;
	@Column(name="ETAP_NAME")
	private String etapName;
	@Column(name="START_ETAP",columnDefinition="DATE")
	private Date startEtap;
	@Column(name="FINISH_ETAP",columnDefinition="DATE")
	private Date finishEtap;
	@Column(name="COST_ETAP")
	private Long costEtap;
	@Column(name="OTCHET")
	private String otchet;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Dogovor getDogovor() {
		return dogovor;
	}
	public void setDogovor(Dogovor dogovor) {
		this.dogovor = dogovor;
	}
	public Integer getEtapNumber() {
		return etapNumber;
	}
	public void setEtapNumber(Integer etapNumber) {
		this.etapNumber = etapNumber;
	}
	public String getEtapName() {
		return etapName;
	}
	public void setEtapName(String etapName) {
		this.etapName = etapName;
	}
	public Date getStartEtap() {
		return startEtap;
	}
	public void setStartEtap(Date startEtap) {
		this.startEtap = startEtap;
	}
	public Date getFinishEtap() {
		return finishEtap;
	}
	public void setFinishEtap(Date finishEtap) {
		this.finishEtap = finishEtap;
	}
	public Long getCostEtap() {
		return costEtap;
	}
	public void setCostEtap(Long costEtap) {
		this.costEtap = costEtap;
	}
	public String getOtchet() {
		return otchet;
	}
	public void setOtchet(String otchet) {
		this.otchet = otchet;
	}
	
}
