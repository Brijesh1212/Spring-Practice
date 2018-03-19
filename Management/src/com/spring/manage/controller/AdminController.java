package com.spring.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.manage.bean.Route;
import com.spring.manage.bean.Ship;
import com.spring.manage.service.RouteService;
import com.spring.manage.service.ShipService;

@Controller
public class AdminController {
	
	ShipService shipService;
	RouteService routeService;
	
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
	

}
