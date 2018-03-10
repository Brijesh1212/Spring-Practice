package com.spring.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.manage.bean.Credentials;
import com.spring.manage.bean.Customer;
import com.spring.manage.service.CustomerService;

@Controller
public class LoginController {
	
	CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("customer") Customer customer,Model model) {
		customerService.login(customer);
		return new ModelAndView("customerHome");
	}
	
	@RequestMapping(value="/registerCustomer",method=RequestMethod.POST)
	public ModelAndView registerCustomer(@ModelAttribute("customer") Customer customer,Model model) {
		System.out.println("In Login Controller Register User");
		System.out.println(customerService);
		String s= customerService.registerCustomer(customer);
		model.addAttribute("message", s);
		
		return new ModelAndView("login","command",new Customer());
	}

}
