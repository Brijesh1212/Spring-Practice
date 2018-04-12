package com.org.java.dao;

import com.org.java.bean.User;

public interface UserDAO {
	
	public String addUser(User user);
	
	public User getUserByEmailAndPassword(String email,String password);

}
