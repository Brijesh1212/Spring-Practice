package com.spring.util;

import com.spring.bean.CredentialsBean;
import com.spring.bean.ProfileBean;
import com.spring.dao.LoginDAO;
import com.spring.dao.LoginDAOImpl;

public class UserImpl implements User{

	
	@Override
	public String login(CredentialsBean credentialsBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean logout(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String changePassword(CredentialsBean credentialsBean, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String register(ProfileBean profileBean) {
		if(profileBean!=null) {
			System.out.println("in UserImpl");
			LoginDAO impl=new LoginDAOImpl();
			System.out.println("s");
			return impl.createCustomer(profileBean);
		} else {
			System.out.println("f");
		return "FAIL";
		}
	}

}
