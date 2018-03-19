package com.spring.manage.service;

import java.util.ArrayList;

import com.spring.manage.bean.Route;
import com.spring.manage.bean.Ship;
import com.spring.manage.dao.ShipDAO;

public class ShipServiceImpl implements ShipService {

	private ShipDAO shipDAO;
	
	public void setShipDAO(ShipDAO shipDAO) {
		this.shipDAO = shipDAO;
	}

	@Override
	public String addShip(Ship ship) {
		return shipDAO.addShip(ship);
	}

	@Override
	public String UpdateShip(Ship ship) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteShip(Ship ship) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Ship> getAllShip() {
		System.out.println("In servce getship : ");
		return new ArrayList<>();
	}

	@Override
	public String getShipById(Ship ship) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getShipByRoute(Route route) {
		// TODO Auto-generated method stub
		return null;
	}

}
