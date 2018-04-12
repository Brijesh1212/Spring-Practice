package com.org.java.bo;

import com.org.java.bean.User;
import com.org.java.dao.UserDAO;

public class UserBOImpl implements UserBO{

	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public String addUser(User user) {
		String returnString=null;
		try {
			returnString=userDAO.addUser(user);
			System.out.println("in user bo"+returnString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnString;
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		User user=null;
		try {
			user=userDAO.getUserByEmailAndPassword(email, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
