package com.spring.manage.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table
public class Passenger {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@JoinColumn
	private Customer customerId;
	
	@JoinColumn
	private Reservation reservationId;
	

}
