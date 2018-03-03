package com.spring.dao;


import com.spring.bean.ReservationBean;

public interface ReservationDAO {

	public ReservationBean findByID(String ShipId );
	
}
