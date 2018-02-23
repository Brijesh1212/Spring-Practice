package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bean.ProfileBean;


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

}
