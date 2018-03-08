package com.spring.manage.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table
public class Schedule {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@JoinColumn(name="routeId")
	private Route routeId;
	
	@JoinColumn(name="shipId")
	private Ship shipId;
	
	private double fare;

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Route getRouteId() {
		return routeId;
	}

	public void setRouteId(Route routeId) {
		this.routeId = routeId;
	}

	public Ship getShipId() {
		return shipId;
	}

	public void setShipId(Ship shipId) {
		this.shipId = shipId;
	}

}
