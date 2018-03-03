package com.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.service.AdministratorImpl;
import com.spring.bean.CredentialsBean;
import com.spring.bean.ScheduleBean;
import com.spring.bean.RouteBean;
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
	
	@RequestMapping(value="/addRouteDetails" , method = RequestMethod.POST)
	public ModelAndView addRouteDetails(ModelMap model,HttpSession session,HttpServletRequest request, @ModelAttribute("command")RouteBean routeBean) {
				if("SUCCESS".equals(administratorImpl.addRoute(routeBean))){
					session = request.getSession();
					session.setAttribute("routeBean", routeBean);
					return new ModelAndView("viewAddedRouteDetails","command",routeBean);
				}
					return null;
	   }
	
	@RequestMapping(value="/addScheduleDetails" , method = RequestMethod.POST)
	public ModelAndView addScheduleDetails(ModelMap model,HttpSession session,HttpServletRequest request, @ModelAttribute("command")ScheduleBean scheduleBean) {
		session = request.getSession();
		String schedulestatus = administratorImpl.addSchedule(scheduleBean);
		System.out.println("STATUS "+schedulestatus);
			if("SUCCESS".equals(schedulestatus)){
				session.setAttribute("status", "Successfully added");
					session.setAttribute("scheduleBean", scheduleBean);
					return new ModelAndView("viewAddedScheduleDetails","command",scheduleBean);
				}
					return new ModelAndView("viewAddedScheduleDetails","command",scheduleBean);

	}
	
	@RequestMapping(value="/viewDetails" , method = RequestMethod.GET)
	public ModelAndView viewDetails(ModelMap model,HttpSession session,HttpServletRequest request) {
		CredentialsBean credentialsBean;
		session = request.getSession();
		if((credentialsBean=(CredentialsBean)session.getAttribute("credentialsBean"))!=null && credentialsBean.getUserType().equals("A")){
			if(credentialsBean.getLoginStatus()==1){
				ArrayList<ShipBean> arrayList = new ArrayList<ShipBean>();
				arrayList = administratorImpl.viewByAllShips();
				session.setAttribute("list", arrayList);
				return new ModelAndView("viewDetails", "command", new ShipBean());
			}else{
				return new ModelAndView("login", "command", new CredentialsBean());

			}
		}
	
	return new ModelAndView("CustomerHome", "command", new CredentialsBean());
	
}
	
	@RequestMapping(value="/viewRouteDetails" , method = RequestMethod.GET)
	public ModelAndView viewRouteDetails(ModelMap model,HttpSession session,HttpServletRequest request) {
		CredentialsBean credentialsBean ;
		session = request.getSession();
		if((credentialsBean=(CredentialsBean)session.getAttribute("credentialsBean"))!=null && credentialsBean.getUserType().equals("A")){
			if(credentialsBean.getLoginStatus()==1){
				ArrayList<RouteBean> arrayList = new ArrayList<RouteBean>();
			
				arrayList = administratorImpl.viewByAllRoute();
				
				session.setAttribute("routeList", arrayList);
				return new ModelAndView("viewRouteDetails", "command", new RouteBean());
			}else{
				return new ModelAndView("login", "command", new CredentialsBean());

			}
		}
			return new ModelAndView("CustomerHome", "command", new CredentialsBean());
	   }
	
	@RequestMapping(value="/viewShipScheduleDetails" , method = RequestMethod.GET)
	public ModelAndView viewShipScheduleDetails(ModelMap model,HttpSession session,HttpServletRequest request) {
		CredentialsBean credentialsBean ;
		session = request.getSession();
		if((credentialsBean=(CredentialsBean)session.getAttribute("credentialsBean"))!=null && credentialsBean.getUserType().equals("A")){
			if(credentialsBean.getLoginStatus()==1){
				ArrayList<ScheduleBean> arrayList = new ArrayList<ScheduleBean>();
				arrayList = administratorImpl.viewByAllSchedule();
				session.setAttribute("scheduleList", arrayList);
				return new ModelAndView("viewShipScheduleDetails", "command", new ScheduleBean());
			}else{
				return new ModelAndView("login", "command", new CredentialsBean());

			}
		}
			return new ModelAndView("CustomerHome", "command", new CredentialsBean());
	   }
	
}