package com.org.java.bo;

import com.org.java.bean.User;

public interface UserBO {
	
	public String addUser(User user);
	
	public User getUserByEmailAndPassword(String email,String password);

}
