package com.spring.manage.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Reservation {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn
	private Schedule scheduleId;
	
	private Date bookinDate;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Schedule getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Schedule scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Date getBookinDate() {
		return bookinDate;
	}

	public void setBookinDate(Date bookinDate) {
		this.bookinDate = bookinDate;
	}

	public Date getJournyDate() {
		return journyDate;
	}

	public void setJournyDate(Date journyDate) {
		this.journyDate = journyDate;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	private Date journyDate;
	
	private Integer numberOfSeats;
	
	private double totalFare;
	
	

}
