package com.spring.manage.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ship")
public class Ship {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String name;
	
	private Integer seats;
	
	private Integer bookingAvailabelSeats;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public Integer getBookingAvailabelSeats() {
		return bookingAvailabelSeats;
	}

	public void setBookingAvailabelSeats(Integer bookingAvailabelSeats) {
		this.bookingAvailabelSeats = bookingAvailabelSeats;
	}

}
