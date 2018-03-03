package com.spring.dao;

import java.util.ArrayList;

import com.spring.bean.RouteBean;

public interface RouteDAO {
	String createShipRoute(RouteBean routebean);
	int deleteShipRoute(ArrayList<String> routeID);
	boolean updateShipRoute(RouteBean routebean);
	RouteBean findByIDRoute(String routeID);
	ArrayList<RouteBean> findAllRoute();

}
