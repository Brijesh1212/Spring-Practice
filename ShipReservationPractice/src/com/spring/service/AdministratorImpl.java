package com.spring.service;

import java.util.ArrayList;

import com.spring.bean.CreditCardBean;
import com.spring.bean.PassengerBean;
import com.spring.bean.ReservationBean;
import com.spring.bean.RouteBean;
import com.spring.bean.ScheduleBean;
import com.spring.bean.ShipBean;
import com.spring.dao.RouteDAO;
import com.spring.dao.RouteDAOImpl;
import com.spring.dao.ScheduleDAO;
import com.spring.dao.ScheduleDAOImpl;
import com.spring.dao.ShipDAO;
import com.spring.dao.ShipDAOImpl;
import com.spring.service.Administrator;

public class AdministratorImpl implements Administrator {

	ShipDAO shipDao=new ShipDAOImpl();
	RouteDAO routeDao=new RouteDAOImpl();
	ScheduleDAO scheduleDAO=new ScheduleDAOImpl();
	
	@Override
	public String addShip(ShipBean shipbean) {
		return shipDao.createShip(shipbean);
	}

	@Override
	public boolean modifyShip(ShipBean Shipbean) {
		return shipDao.updateShip(Shipbean);
	}

	@Override
	public int removeShip(ArrayList<String> ShipId) {
		return shipDao.deleteShip(ShipId);
	}

	@Override
	public ShipBean viewByShipId(String ShipId) {
		return shipDao.findByID(ShipId);
	}

	@Override
	public ArrayList<ShipBean> viewByAllShips() {
		return shipDao.findAll();
	}

	@Override
	public ArrayList<PassengerBean> viewPasengersByShip(String scheduleid) {
		return shipDao.findPasengersByShip(scheduleid);
	}

	@Override
	public String addSchedule(ScheduleBean schedulebean) {
		return scheduleDAO.createShipSchedule(schedulebean);
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
		return scheduleDAO.findAllSchedule();
	}

	@Override
	public ScheduleBean viewByScheduleId(String scheduleId) {
		return scheduleDAO.findByIDSchedule(scheduleId);
	}

	@Override
	public String addRoute(RouteBean routebean) {
		return routeDao.createShipRoute(routebean);
	}

	@Override
	public boolean modifyRoute(RouteBean routebean) {
		return routeDao.updateShipRoute(routebean);
	}

	@Override
	public int removeRoute(ArrayList<String> routeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RouteBean viewByRouteId(String routeId) {
		return routeDao.findByIDRoute(routeId);
	}

	@Override
	public ArrayList<RouteBean> viewByAllRoute() {
		return routeDao.findAllRoute();
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
