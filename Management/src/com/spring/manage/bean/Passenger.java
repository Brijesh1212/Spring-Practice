package com.spring.manage.bean;

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
public class Passenger {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn
	private Customer customerId;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=Reservation.class)
	@JoinColumn
	private Reservation reservationId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public Reservation getReservationId() {
		return reservationId;
	}

	public void setReservationId(Reservation reservationId) {
		this.reservationId = reservationId;
	}
	

}
