package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bean.CredentialsBean;
import com.spring.bean.ProfileBean;
import com.spring.bean.RouteBean;
import com.spring.bean.ScheduleBean;


@Controller
@RequestMapping(value= {"/Page","/"})
public class PageController {
	
	@RequestMapping(value= {"/","/login"})
	public ModelAndView login() {
		System.out.println("In Page Conteroller");
		return new ModelAndView("login","command",new ProfileBean());
	}
	
	@RequestMapping("registerCustomer")
	public ModelAndView registerCustomer(ModelMap model,HttpSession session) {
		return new ModelAndView("registerCustomer","command",new ProfileBean());
    }
	
	@RequestMapping("/abc")
	public ModelAndView abc(HttpSession session,HttpServletRequest request) {
		//System.out.println("In abc");
		try {
			if ((CredentialsBean)session.getAttribute("credentialsBean")!=null) {
				return new ModelAndView("abc","command",new ProfileBean());
			} else {
                return new ModelAndView("login","command",new CredentialsBean());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/AdminHome" , method = RequestMethod.GET)
	public ModelAndView AdminHome(ModelMap model,HttpSession session,HttpServletRequest request) {
		CredentialsBean credentialsBean ;
		session = request.getSession();
		if((credentialsBean=(CredentialsBean)session.getAttribute("credentialsBean"))!=null){
			if(credentialsBean.getUserType().equals("A")){
			if(credentialsBean.getLoginStatus()==1){
				return new ModelAndView("AdminHome", "command", new ProfileBean());
			}else{
				return new ModelAndView("login", "command", new CredentialsBean());
			}
		}else{
			return new ModelAndView("CustomerHome", "command", new CredentialsBean());
		}
		}else{
			return new ModelAndView("login", "command", new CredentialsBean());
		}
	  }
	
	@RequestMapping(value="/addShip" , method = RequestMethod.GET)
	public ModelAndView addShip(ModelMap model,HttpSession session,HttpServletRequest request) {
			CredentialsBean credentialsBean ;
			session = request.getSession();
			if((credentialsBean=(CredentialsBean)session.getAttribute("credentialsBean"))!=null && credentialsBean.getUserType().equals("A")){
				return new ModelAndView("addShip", "command", new com.spring.bean.ShipBean());
			}
				return new ModelAndView("login", "command", new CredentialsBean());

	  }
	
	@RequestMapping(value="/addRoute" , method = RequestMethod.GET)
	public ModelAndView addRoute(ModelMap model,HttpSession session,HttpServletRequest request) {
		CredentialsBean credentialsBean ;
		session = request.getSession();
		if((credentialsBean=(CredentialsBean)session.getAttribute("credentialsBean"))!=null && credentialsBean.getUserType().equals("A")){
			if(credentialsBean.getLoginStatus()==1){
				return new ModelAndView("addRoute", "command", new RouteBean());
			}else{
				return new ModelAndView("login", "command", new CredentialsBean());

			}
		}
				return new ModelAndView("CustomerHome", "command", new CredentialsBean());
	  }
	
	@RequestMapping(value="/addSchedule" , method = RequestMethod.GET)
	public ModelAndView addSchedule(ModelMap model,HttpSession session,HttpServletRequest request) {
		CredentialsBean credentialsBean ;
		
		session = request.getSession();
		if((credentialsBean=(CredentialsBean)session.getAttribute("credentialsBean"))!=null && credentialsBean.getUserType().equals("A")){
			return new ModelAndView("addSchedule", "command", new ScheduleBean());
		}
			return new ModelAndView("login", "command", new CredentialsBean());

	  }
	
	@RequestMapping(value="/reservation" , method = RequestMethod.GET)
	public ModelAndView reservation(ModelMap model,HttpSession session,HttpServletRequest request) {
		CredentialsBean credentialsBean ;
		session = request.getSession();
		if((credentialsBean=(CredentialsBean)session.getAttribute("credentialsBean"))!=null && credentialsBean.getUserType().equals("C")){
			return new ModelAndView("reservation", "command", null);
		}
			return new ModelAndView("login", "command", new CredentialsBean());
	  }
	
	@RequestMapping(value="/pdf" , method = RequestMethod.POST)
	public ModelAndView pdf(ModelMap model,HttpSession session,HttpServletRequest request) {
		CredentialsBean credentialsBean ;
		session = request.getSession();
		if((credentialsBean=(CredentialsBean)session.getAttribute("credentialsBean"))!=null && credentialsBean.getUserType().equals("C")){
				return new ModelAndView("PdfTicketSummary", "command", new CredentialsBean());
		}
			return new ModelAndView("login", "command", new CredentialsBean());
	  }

}
