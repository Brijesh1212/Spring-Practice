package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bean.CredentialsBean;
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

}
