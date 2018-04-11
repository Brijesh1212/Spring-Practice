package com.org.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.java.bean.User;
import com.org.java.bo.UserBO;

@Controller
public class UserController {
	
	private UserBO userBO;
	
	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}


	@RequestMapping("/registerUser")
	public ModelAndView addUser(@ModelAttribute("user") User user,Model model) {
		String message=null;
		System.out.println(user.getUserName());
		try {
			String returnString=userBO.addUser(user);
			if(returnString.equals("SUCCESS")){
				message="User added";
			}else{
				message="Failed to added user please try again";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", message);
		return new ModelAndView("login","command",new User());
	}

}
