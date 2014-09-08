package by.belisa.bean;

import java.io.Serializable;

import by.belisa.entity.CalcTrip;

public class CalcTripDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3453435527735998844L;
	
	private Integer id;
	private String tripGoal;
	private String tripPoint;
	private int count;
	private int duration;
	private int costs;
	
	public CalcTripDTO() {
	}

	public CalcTripDTO(CalcTrip calcTrip) {
		this.id = calcTrip.getId();
		this.tripGoal = calcTrip.getTripGoal();
		this.tripPoint = calcTrip.getTripPoint();
		this.count = calcTrip.getCount();
		this.duration = calcTrip.getDuration();
		this.costs = calcTrip.getCosts();
	}

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

	
}
