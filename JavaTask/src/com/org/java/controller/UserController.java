package com.org.java.controller;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.java.bean.Task;
import com.org.java.bean.User;
import com.org.java.bo.TaskBO;
import com.org.java.bo.UserBO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

@Controller
public class UserController {
	
	private UserBO userBO;
	private TaskBO taskBO;
	
	public void setTaskBO(TaskBO taskBO) {
		this.taskBO = taskBO;
	}
	
	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}


	@RequestMapping("/registerUser")
	public ModelAndView addUser(@ModelAttribute("user") User user,Model model) {
		String message="";
		System.out.println(user.getUserName()+" : "+userBO);
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
	
	@RequestMapping("/loginUser")
	public ModelAndView loginUser(@RequestParam("email")String email,@RequestParam("password") String password,HttpSession session,Model model) {
		User user=userBO.getUserByEmailAndPassword(email, password);
		
		Key key = MacProvider.generateKey();

		 String compactJws = Jwts.builder()
		  .setSubject(email)
		  .signWith(SignatureAlgorithm.HS512, key)
		  .compact();
		 //System.out.println(user.getUserName()+" User Name");
		 if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
			 session.setAttribute("jwToken", compactJws);
			 session.setAttribute("userName", user.getUserName());
			 session.setAttribute("email", user.getEmail());
			 session.setAttribute("userAddress", user.getAddress());
			 session.setAttribute("key", key);
			 List<Task> l=taskBO.getAllTask();
			 ArrayList<Task> al=new ArrayList<>();
				for (Task task2 : l) {
					al.add(task2);
				}
			 model.addAttribute("l", al);
			 return new ModelAndView("index");
		 }else {
			 model.addAttribute("message", "User name or password is wrong");
			 return new ModelAndView("login");
		 }
	}

}
