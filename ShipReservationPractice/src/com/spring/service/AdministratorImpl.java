package com.spring.service;

import java.util.ArrayList;

import com.spring.bean.CreditCardBean;
import com.spring.bean.PassengerBean;
import com.spring.bean.ReservationBean;
import com.spring.bean.RouteBean;
import com.spring.bean.ScheduleBean;
import com.spring.bean.ShipBean;
import com.spring.dao.ShipDAO;
import com.spring.dao.ShipDAOImpl;
import com.spring.service.Administrator;

public class AdministratorImpl implements Administrator {

	ShipDAO shipDao=new ShipDAOImpl();
	@Override
	public String addShip(ShipBean shipbean) {
		return shipDao.createShip(shipbean);
	}

	@Override
	public boolean modifyShip(ShipBean Shipbean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int removeShip(ArrayList<String> ShipId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShipBean viewByShipId(String ShipId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ShipBean> viewByAllShips() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PassengerBean> viewPasengersByShip(String scheduleid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addSchedule(ScheduleBean schedulebean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifySchedule(ScheduleBean schedulebean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int removeSchedule(ArrayList<String> scheduleId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ScheduleBean> viewByAllSchedule() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScheduleBean viewByScheduleId(String scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addRoute(RouteBean routebean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyRoute(RouteBean routebean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int removeRoute(ArrayList<String> routeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RouteBean viewByRouteId(String routeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RouteBean> viewByAllRoute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReservationBean viewByReservationId(String reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreditCardBean viewByCreditCardNumber(String creditCardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
