package com.spring.util;

import com.spring.bean.CredentialsBean;
import com.spring.bean.ProfileBean;

public interface User {

	String login(CredentialsBean credentialsBean);
	boolean logout(String userId);
	String changePassword(CredentialsBean credentialsBean, String newPassword);
	String register(ProfileBean profileBean);
}
