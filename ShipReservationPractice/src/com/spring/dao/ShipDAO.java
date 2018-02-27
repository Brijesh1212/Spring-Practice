package com.spring.dao;

import java.util.ArrayList;

import com.spring.bean.PassengerBean;
import com.spring.bean.ShipBean;

public interface ShipDAO {
	String createShip(ShipBean shipbean);
	int deleteShip(ArrayList<String> ShipId);
	boolean updateShip(ShipBean shipbean);
	ShipBean findByID(String ShipId);
	ArrayList<ShipBean> findAll();
	ArrayList<PassengerBean> findPasengersByShip(String scheduleid);
}
