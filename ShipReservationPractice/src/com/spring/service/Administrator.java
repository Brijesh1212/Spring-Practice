package com.spring.service;

import java.util.ArrayList;

import com.spring.bean.CreditCardBean;
import com.spring.bean.PassengerBean;
import com.spring.bean.ReservationBean;
import com.spring.bean.RouteBean;
import com.spring.bean.ScheduleBean;
import com.spring.bean.ShipBean;

public interface Administrator {
	String addShip(ShipBean shipbean);
	boolean modifyShip(ShipBean Shipbean);
	int removeShip(ArrayList<String> ShipId);
	ShipBean viewByShipId(String ShipId);
	ArrayList<ShipBean> viewByAllShips();
	ArrayList<PassengerBean> viewPasengersByShip(String scheduleid);
	
	String addSchedule(ScheduleBean schedulebean);
	boolean modifySchedule(ScheduleBean schedulebean);
	int removeSchedule(ArrayList<String> scheduleId);
	ArrayList<ScheduleBean> viewByAllSchedule();
	ScheduleBean viewByScheduleId(String scheduleId);
	
	String addRoute(RouteBean routebean);
	boolean modifyRoute(RouteBean routebean);
	int removeRoute(ArrayList<String> routeId);
	RouteBean viewByRouteId(String routeId);
	ArrayList<RouteBean> viewByAllRoute();
	
	ReservationBean viewByReservationId(String reservationId);

	CreditCardBean viewByCreditCardNumber(String creditCardNumber);
	
}
