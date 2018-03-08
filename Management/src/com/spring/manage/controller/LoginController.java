package com.spring.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.manage.bean.Customer;
import com.spring.manage.service.CustomerService;

@Controller
public class LoginController {
	
	CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute("customer") Customer customer,Model model) {
		return customerService.login(customer);
	}
	
	@RequestMapping("/registerCustomer")
	public ModelAndView registerCustomer(@ModelAttribute("customer") Customer customer,Model model) {
		String s= customerService.registerCustomer(customer);
		model.addAttribute("message", s);
		return new ModelAndView("login","command",new Customer());
	}

}
