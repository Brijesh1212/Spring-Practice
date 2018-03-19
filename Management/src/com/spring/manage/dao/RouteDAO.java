package com.spring.manage.dao;

import java.util.ArrayList;

import com.spring.manage.bean.Route;

public interface RouteDAO {
	
public String addRoute(Route route);
	
	public String deleteRoute(Route route);
	
	public String updateRoute(Route route);
	
	public ArrayList<Route> getRoutes();
	
	public Route getRouteById(Route route);

}
