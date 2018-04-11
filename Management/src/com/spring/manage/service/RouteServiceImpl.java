package com.spring.manage.service;

import java.util.ArrayList;

import com.spring.manage.bean.Route;
import com.spring.manage.dao.RouteDAO;

public class RouteServiceImpl implements RouteService{
	
	RouteDAO routeDAO;


	public void setRouteDAO(RouteDAO routeDAO) {
		this.routeDAO = routeDAO;
	}

	@Override
	public String addRoute(Route route) {
		return routeDAO.addRoute(route);
	}

	@Override
	public String deleteRoute(Route route) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateRoute(Route route) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Route> getRoutes() {
		return routeDAO.getRoutes();
	}

	@Override
	public Route getRouteById(Route route) {
		return routeDAO.getRouteById(route);
	}

}
