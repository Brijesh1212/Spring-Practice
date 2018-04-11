package com.org.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.java.bean.User;

@Controller
public class UserController {
	
	@RequestMapping("/registerUser")
	public ModelAndView addUser(@ModelAttribute("user") User user,Model model) {
		return new ModelAndView("login","command",new User());
	}

}
