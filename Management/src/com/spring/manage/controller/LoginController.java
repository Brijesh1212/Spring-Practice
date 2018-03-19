package com.spring.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.manage.bean.Credentials;
import com.spring.manage.bean.Customer;
import com.spring.manage.service.CustomerService;

@Controller
public class LoginController {
	
	CustomerService customerService;
	HttpSession session;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("customer") Credentials credentials,HttpServletRequest request,Model model) {
		String status= customerService.login(credentials);
		if(status.equalsIgnoreCase("Success")) {
			Credentials credentials2= customerService.getCredentilsByEmail(credentials.getEmail());
			if(credentials2.getType().equals("C")) {
			session=request.getSession();
			session.setAttribute("credentials", credentials2);
			return new ModelAndView("customerHome");
			}else {
				session=request.getSession();
				session.setAttribute("credentials", credentials2);
				return new ModelAndView("adminHome");
			}
		}else {
			System.out.println("In wrong");
			model.addAttribute("message","User Id or password wrong...!!!");
			return new ModelAndView("login","command",new Credentials());
		}
		
	}
	
	@RequestMapping(value="/registerCustomer",method=RequestMethod.POST)
	public ModelAndView registerCustomer(@ModelAttribute("customer") Customer customer,Model model) {
		System.out.println("In Login Controller Register User");
		System.out.println(customerService);
		String s= customerService.registerCustomer(customer);
		model.addAttribute("message", s);
		
		return new ModelAndView("login","command",new Customer());
	}
	
	@RequestMapping(value="/changePasswordDetails",method=RequestMethod.POST)
	public ModelAndView changePasswordDetails(@RequestParam("opass") String opass,@RequestParam("npass") String npass,HttpServletRequest request,Model model) {
		session=request.getSession();
		Credentials credentials=(Credentials) session.getAttribute("credentials");
		System.out.println(credentials+" :opass");
		Credentials credentials2= customerService.getCredentilsByEmail(credentials.getEmail());
		if(credentials2.getPassword().equals(opass)) {
			credentials.setPassword(npass);
		    if(customerService.updateCredentials(credentials).equals("SUCCESS")) {
		    	model.addAttribute("message", "Password Updated Please Login with new password");
		    	return new ModelAndView("login","command",new Customer());
		    }else {
		    	model.addAttribute("message", "Password Update Failed");
		    	return new ModelAndView("changePassword","command",credentials);
		    }
		}else {
			model.addAttribute("message", "Old Password did not match");
	    	return new ModelAndView("changePassword","command",credentials);
		}
		
	}

}
