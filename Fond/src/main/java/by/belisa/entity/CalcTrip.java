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
@Table(name="CALC_TRIP")
@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "zayavkaFI"))
public class CalcTrip implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7915419068263962850L;
	
	@Id
	@GeneratedValue(generator="gen")
	private Integer id;
	@Column(name="TRIP_GOAL")
	private String tripGoal;
	@Column(name="TRIP_POINT")
	private String tripPoint;
	@Column
	private int count;
	@Column
	private int duration;
	@Column
	private int costs;
	
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false)  
	@PrimaryKeyJoinColumn()
	private ZayavkaFI zayavkaFI;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTripGoal() {
		return tripGoal;
	}


	public void setTripGoal(String tripGoal) {
		this.tripGoal = tripGoal;
	}


	public String getTripPoint() {
		return tripPoint;
	}


	public void setTripPoint(String tripPoint) {
		this.tripPoint = tripPoint;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public int getCosts() {
		return costs;
	}


	public void setCosts(int costs) {
		this.costs = costs;
	}


	public ZayavkaFI getZayavkaFI() {
		return zayavkaFI;
	}


	public void setZayavkaFI(ZayavkaFI zayavkaFI) {
		this.zayavkaFI = zayavkaFI;
	}
	
	

}
