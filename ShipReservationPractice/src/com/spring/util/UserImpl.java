package com.spring.util;

import com.spring.bean.CredentialsBean;
import com.spring.bean.ProfileBean;
import com.spring.dao.LoginDAO;
import com.spring.dao.LoginDAOImpl;
import com.spring.util.AuthenticationImpl;

public class UserImpl implements User{

	
	@Override
	public String login(CredentialsBean credentialsBean) {
		try {
			if(credentialsBean!=null) {
				LoginDAO dao=new LoginDAOImpl();
				CredentialsBean credentialsBean2=dao.findByID(credentialsBean.getUserID());
				String usertype=credentialsBean2.getUserType();
				return usertype;
			}else {
				return "Invalid";
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean logout(String userId) {
		if(userId!=null) {
			AuthenticationImpl authenticationImpl=new AuthenticationImpl();
			LoginDAOImpl impl=new LoginDAOImpl();
			CredentialsBean newcredentialsBean=impl.findByID(userId);
			 return authenticationImpl.changeLoginStatus(newcredentialsBean, 0);
			} else {
			return false;
			}
	}

	@Override
	public String changePassword(CredentialsBean credentialsBean, String newPassword) {
		if(credentialsBean!=null && newPassword!=null){
			LoginDAOImpl loginDAO_Impl=new LoginDAOImpl();
			credentialsBean.setPassword(newPassword);
			boolean value=loginDAO_Impl.updateCredential(credentialsBean);
			if(value){
				return "SUCCESS";
			} else {
				return "FAIL";
			}
			}else{
			return "INVALID";
			}
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
