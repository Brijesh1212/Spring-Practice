package com.spring.manage.service;

import java.util.ArrayList;

import com.spring.manage.bean.Route;

public interface RouteService {
	
	public String addRoute(Route route);
	
	public String deleteRoute(Route route);
	
	public String updateRoute(Route route);
	
	public ArrayList<Route> getRoutes();
	
	public Route getRouteById(Route route);
	

}
