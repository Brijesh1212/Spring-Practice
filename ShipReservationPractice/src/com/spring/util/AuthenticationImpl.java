package com.spring.util;


import com.spring.dao.LoginDAO;
import com.spring.dao.LoginDAOImpl;
import com.spring.bean.CredentialsBean;

public class AuthenticationImpl implements Authentication {

	@Override
	public boolean authenticate(CredentialsBean credentialsBean) {
		try {
			if(credentialsBean!=null) {
				LoginDAO dao=new LoginDAOImpl();
				CredentialsBean credentialsBean2=dao.findByID(credentialsBean.getUserID());
				if(credentialsBean.getPassword().equals(credentialsBean2.getPassword())) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String authorize(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) {
		try {
			if(credentialsBean!=null) {
				LoginDAO dao=new LoginDAOImpl();
				credentialsBean.setLoginStatus(loginStatus);
				return dao.updateCredential(credentialsBean);
			}else {
				return false;
						}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean forgotPassword(String userID, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
