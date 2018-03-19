package com.spring.manage.dao;

import java.util.ArrayList;

import com.spring.manage.bean.Route;
import com.spring.manage.bean.Ship;

public interface ShipDAO {
	
public String addShip(Ship ship);
	
	public String UpdateShip(Ship ship);
	
	public String deleteShip(Ship ship);
	
	public ArrayList<Ship> getAllShip();
	
	public String getShipById(Ship ship);
	
	public String getShipByRoute(Route route);

}
