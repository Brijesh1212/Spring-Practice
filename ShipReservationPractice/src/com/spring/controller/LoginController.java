package com.spring.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bean.CredentialsBean;
import com.spring.bean.ProfileBean;
import com.spring.bean.ShipBean;
import com.spring.service.CustomerServiceImpl;
import com.spring.util.AuthenticationImpl;
import com.spring.util.UserImpl;

@Controller
public class LoginController {
	
	
	UserImpl userImpl = new UserImpl();
	AuthenticationImpl authenticationImpl = new AuthenticationImpl();
	CredentialsBean bean = new CredentialsBean();
	HttpSession session;
	
	@RequestMapping(value="/registerUser" , method = RequestMethod.POST)
	public ModelAndView registerUser(ModelMap model,@ModelAttribute("register")ProfileBean profileBean,HttpSession session,HttpServletRequest request)  {
			
			userImpl.register(profileBean);
			model.addAttribute("success", "You have been registered with userid<br />"+profileBean.getUserID());
			
			return new ModelAndView("login", "command", new CredentialsBean());
	  }
	
	
	
	@RequestMapping(value="/loginuser" , method = RequestMethod.POST)
	public ModelAndView loginUser(ModelMap model,@ModelAttribute("loginuser")CredentialsBean credentialsBean, HttpServletRequest request) {
		String userType;
		bean = credentialsBean;
		
		if(authenticationImpl.authenticate(credentialsBean)){
			 userType = userImpl.login(credentialsBean);
			 credentialsBean.setUserType(userType);
			 	if(authenticationImpl.changeLoginStatus(credentialsBean, 1)){
			 		if("A".equals(userType)){
			 			session = request.getSession();
			 			session.setAttribute("userid", credentialsBean.getUserID());
			 			session.setAttribute("credentialsBean", credentialsBean);
			 			CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
			 			if((customerServiceImpl.findProfileByUserID(credentialsBean.getUserID()))==null){
			 				session.setAttribute("firstLogin", "FIRST");
				 			return new ModelAndView("changePassword", "command", new ShipBean());
			 			}
			 			session.removeAttribute("firstLogin");
			 			return new ModelAndView("AdminHome", "command", new ShipBean());
			 		}else if("C".equals(userType)){
			 			session = request.getSession();
			 			session.setAttribute("userid", credentialsBean.getUserID());
			 			session.setAttribute("credentialsBean", credentialsBean);
			 			return new ModelAndView("CustomerHome","command",new ProfileBean());
			 		}else{
			 			session = request.getSession();
			 			session.setAttribute("userid", credentialsBean.getUserID());
			 			session.setAttribute("credentialsBean", credentialsBean);
			 			return new ModelAndView("AdminHome", "command", new ShipBean());
			 		}
			 	}else{
			 		model.addAttribute("invalid", "Already logged in");
					return new ModelAndView("login","command",new CredentialsBean());

			 	}
		}			
		else{
			model.addAttribute("invalid", "Incorrect username/password");
			return new ModelAndView("login","command",new CredentialsBean());
		}
					
	}
	
	
}
