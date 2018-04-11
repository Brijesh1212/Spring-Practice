package com.spring.manage.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.manage.bean.Route;
import com.spring.manage.bean.Schedule;
import com.spring.manage.bean.Ship;
import com.spring.manage.service.RouteService;
import com.spring.manage.service.ScheduleService;
import com.spring.manage.service.ShipService;

@Controller
public class AdminController {
	
	ShipService shipService;
	RouteService routeService;
	ScheduleService scheduleService;
	
	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	
	public void setShipService(ShipService shipService) {
		this.shipService = shipService;
	}
	
	public void setRouteService(RouteService routeService) {
		this.routeService = routeService;
	}

	@RequestMapping("/addShipDetails")
	public ModelAndView addShip(@ModelAttribute("ship") Ship ship,Model model) {
		System.out.println("Ship: "+ship);
		String status=shipService.addShip(ship);
		if(status.equals("SUCCESS")) {
			model.addAttribute("message", "Ship Details Added Successfully with name "+ship.getName());
			return new ModelAndView("addShip","command",new Ship());
		}else {
			model.addAttribute("message", "Failed to add Ship details");
			return new ModelAndView("addShip","command",new Ship());
		}
	}
	
	@RequestMapping("/addRouteDetails")
	public ModelAndView addRouteDetails(@ModelAttribute("route") Route route,Model model) {
		System.out.println("Route: "+route);
		if(routeService.addRoute(route).equals("SUCCESS")) {
			model.addAttribute("message", "Route Details stored successfully S: "+route.getSource()+" D: "+route.getDestination());
			return new ModelAndView("addShip","command",new Ship());
		}else {
			model.addAttribute("message", "Failed to store Route please try again...");
			return new ModelAndView("addShip","command",new Ship());
		}
	}
	
	@RequestMapping("/addSchedule")
	public ModelAndView addSchedule(Model model) {
		ArrayList<Ship> shipList=shipService.getAllShip();
		ArrayList<Route> routeList=routeService.getRoutes();
		model.addAttribute("shipList", shipList);
		model.addAttribute("routeList", routeList);
		System.out.println("Sending Schedule");
		return new ModelAndView("addSchedule","command",new Schedule());
	}
	
	@RequestMapping(value="/scheduleDetails",method=RequestMethod.POST)
	public ModelAndView addScheduleDetails(@RequestParam("shipId") String shipId,@RequestParam("routeId") String routeId,@RequestParam("fare") String fare, Model model) {
		Schedule schedule=new Schedule();
		
		Ship ship=new Ship();
		ship.setId(Integer.parseInt(shipId));
		Ship ship2= shipService.getShipById(ship);
		
		Route route=new Route();
		route.setId(Integer.parseInt(routeId));
		Route route2=routeService.getRouteById(route);
		
		schedule.setRouteId(route2);
		schedule.setShipId(ship2);
		schedule.setFare(Double.parseDouble(fare));
		System.out.println("Ship :"+schedule);
		if(scheduleService.addSchedule(schedule).equalsIgnoreCase("SUCCESS")) {
		model.addAttribute("message", "Schedule Stored in database");
		return new ModelAndView("addSchedule","command",new Schedule());
		}else {
			model.addAttribute("message", "Due to some resons failed to store schedule try again..");
			return new ModelAndView("addSchedule","command",new Schedule());
		}
	}

}
