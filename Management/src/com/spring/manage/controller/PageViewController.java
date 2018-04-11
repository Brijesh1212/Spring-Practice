package com.spring.manage.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.manage.bean.Customer;
import com.spring.manage.bean.Route;
import com.spring.manage.bean.Ship;

@Controller
public class PageViewController {
	
	@RequestMapping(value= {"/","/index"})
	public ModelAndView index() {
		return new ModelAndView("login","command",new Customer());
	}
	
	@RequestMapping("/registration")
	public ModelAndView registration() {
		return new ModelAndView("registration","command",new Customer());
	}
	
	@RequestMapping("/adminHome")
	public ModelAndView adminHome() {
		return new ModelAndView("adminHome");
	}
	
	@RequestMapping("/changePassword")
	public ModelAndView changePassword() {
		return new ModelAndView("changePassword");
	}
	
	@RequestMapping("/addShip")
	public ModelAndView addShip() {
		return new ModelAndView("addShip","command",new Ship());
	}
	
	@RequestMapping("/addRoute")
	public ModelAndView addRoute() {
		return new ModelAndView("addRoute","command",new Route());
	}
	
}
