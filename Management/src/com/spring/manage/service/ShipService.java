package com.spring.manage.service;

import java.util.ArrayList;

import com.spring.manage.bean.Route;
import com.spring.manage.bean.Ship;

public interface ShipService {
	
	public String addShip(Ship ship);
	
	public String UpdateShip(Ship ship);
	
	public String deleteShip(Ship ship);
	
	public ArrayList<Ship> getAllShip();
	
	public Ship getShipById(Ship ship);
	
	public String getShipByRoute(Route route);

}
