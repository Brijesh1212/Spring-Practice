package com.spring.util;

import com.spring.bean.CredentialsBean;

public interface Authentication {

	
	boolean authenticate(CredentialsBean credentialsBean);
	String authorize(String userId);
	boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);
	public boolean forgotPassword(String userID, String newPassword);
}
