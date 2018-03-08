package com.spring.manage.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.manage.bean.Customer;

@Controller
public class PageViewController {
	
	@RequestMapping(value= {"/","/index"})
	public ModelAndView index() {
		return new ModelAndView("index","command",new Customer());
	}
	
	@RequestMapping("/registration")
	public ModelAndView registration() {
		return new ModelAndView("registration","command",new Customer());
	}
	
}
