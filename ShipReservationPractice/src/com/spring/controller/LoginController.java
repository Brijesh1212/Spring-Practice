package com.spring.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bean.CredentialsBean;
import com.spring.bean.ProfileBean;
import com.spring.bean.ShipBean;
import com.spring.service.CustomerServiceImpl;
import com.spring.util.AuthenticationImpl;
import com.spring.util.UserImpl;
import com.spring.dao.CustomerDAOImpl;

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
			 			System.out.println("In A");
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
		}else{
			model.addAttribute("invalid", "Incorrect username/password");
			return new ModelAndView("login","command",new CredentialsBean());
		}
					
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		System.out.println("In Logout");
		session = request.getSession();
		if(((CredentialsBean)session.getAttribute("credentialsBean"))!=null){	
			if(userImpl.logout(bean.getUserID())){
				session.removeAttribute("credentialsBean");
				session.invalidate();
				return new ModelAndView("login", "command", new CredentialsBean());
			}else{
				return new ModelAndView("AdminHome","command",new ShipBean());
			}
		}else{
			return new ModelAndView("login", "command", new CredentialsBean());
		}
		
	}
	
	@RequestMapping(value="/changePassword" , method = RequestMethod.GET)
	public ModelAndView changePassword(HttpSession session, HttpServletRequest request) {
		@SuppressWarnings("unused")
		CredentialsBean credentialsBean ;
		session = request.getSession();
		
		if((credentialsBean=(CredentialsBean)session.getAttribute("credentialsBean"))!=null){
			return new ModelAndView("changePassword", "command", new CredentialsBean());
		}else{
			return new ModelAndView("login", "command", new CredentialsBean());
		}
	  }
	
	@RequestMapping(value="/changePasswordDetails" , method = RequestMethod.POST)
	public ModelAndView changePasswordDetails(ModelMap model,HttpSession session, HttpServletRequest request,@RequestParam("opass")String opass,@RequestParam("npass")String npass) {
		CredentialsBean credentialsBean = (CredentialsBean)session.getAttribute("credentialsBean");
		credentialsBean.setPassword(opass);
		System.out.println(authenticationImpl.authenticate(credentialsBean));
		if(authenticationImpl.authenticate(credentialsBean)){
			@SuppressWarnings("unused")
			String firstLogin = "";
			if((firstLogin=((String)session.getAttribute("firstLogin")))!=null){
				CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
				if("SUCCESS".equals(userImpl.changePassword(credentialsBean, npass))){
					customerDAOImpl.register(credentialsBean);
					model.addAttribute("changed", "Password has been changed successfully.<br/> Please Login again.");
					return new ModelAndView("login", "command", new CredentialsBean());
				}else{
					model.addAttribute("failed", "Password could not be changed. Try again.");
					return new ModelAndView("changePassword", "command", new CredentialsBean());
				}
			}else{
				if("SUCCESS".equals(userImpl.changePassword(credentialsBean, npass))){
					model.addAttribute("changed", "Password has been changed successfully.<br/> Please Login again.");
					return new ModelAndView("changePassword", "command", new CredentialsBean());
				}else{
					model.addAttribute("failed", "Password could not be changed. Try again.");
					return new ModelAndView("changePassword", "command", new CredentialsBean());
				}
			}
			
		}else{
			model.addAttribute("failed", "Old password is incorrect");
			return new ModelAndView("changePassword", "command", new CredentialsBean());
		}
	  }
	
	
}
