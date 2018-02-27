package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.service.AdministratorImpl;
import com.spring.bean.ShipBean;

@Controller
public class AdminController {
	
	public AdminController() {
		System.out.println("Admin controller created");
	}

	AdministratorImpl administratorImpl = new AdministratorImpl();
	
	@RequestMapping(value="/addShipDetails" , method = RequestMethod.POST)
	public ModelAndView addShipDetails(ModelMap model,HttpSession session,HttpServletRequest request,  ShipBean shipbea) {
		System.out.println("ship name: "+shipbea.getShipName());		
		if("SUCCESS".equals(administratorImpl.addShip(shipbea))){
					session = request.getSession();
					session.setAttribute("shipBean", shipbea);
					return new ModelAndView("viewAddedDetails","command",shipbea);
				}else{
					model.addAttribute("failed", "Ship could not be added.");
					return new ModelAndView("addShip","command",new ShipBean());
				}
					
	   }
}