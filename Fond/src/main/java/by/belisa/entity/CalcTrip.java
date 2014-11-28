package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CALC_TRIP")
@SequenceGenerator(name="PK", sequenceName="SEQ_CALC_TRIP")
public class CalcTrip implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7915419068263962850L;
	
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@Column(name="TRIP_GOAL")
	private String tripGoal;
	@Column(name="TRIP_POINT")
	private String tripPoint;
	@Column
	private float count;
	@Column
	private float duration;
	@Column
	private float costs;
	
	
	
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


	public float getCount() {
		return count;
	}


	public void setCount(float count) {
		this.count = count;
	}


	public float getDuration() {
		return duration;
	}


	public void setDuration(float duration) {
		this.duration = duration;
	}


	public float getCosts() {
		return costs;
	}


	public void setCosts(float costs) {
		this.costs = costs;
	}

}
