package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bean.ProfileBean;
import com.spring.util.User;

@Controller
@RequestMapping(value= {"/","RegController"})
public class LoginController {
	
	User user;
	
	@RequestMapping("/registerUser")
	public ModelAndView registerUser(ProfileBean profileBean) {
		user.register(profileBean);
		return new ModelAndView("login","command",new ProfileBean());
	}

}
