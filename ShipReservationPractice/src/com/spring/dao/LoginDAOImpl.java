package com.spring.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.spring.bean.CredentialsBean;
import com.spring.bean.ProfileBean;
import com.spring.util.DBUtil;

public class LoginDAOImpl implements LoginDAO {
	
	static Session session;
	static {
		session = DBUtil.getSessionFactory().openSession();
	}

	@Override
	public String createCustomer(ProfileBean profileBean) {
		try{
			if (profileBean != null) {

				session.clear();
				Transaction tx = session.beginTransaction();
				String customerID = (Double.toString(Math.random())+profileBean.getCity().charAt(2)).substring(2, 4) ;
				System.out.println(customerID+" : iD");
				profileBean.setUserID(customerID);
				
				CredentialsBean credentialsBean = new CredentialsBean();
				credentialsBean.setUserID(profileBean.getUserID());
				credentialsBean.setLoginStatus(0);
				credentialsBean.setPassword(profileBean.getPassword());
				credentialsBean.setUserType("C");
				
				session.saveOrUpdate(credentialsBean);
				session.saveOrUpdate(profileBean);
				tx.commit();
				System.out.println("Status: "+tx.wasCommitted());
				
			return profileBean.getUserID();
			} else {
				return "FAIL";

			}
			}catch (NullPointerException eNPExc){
				return "FAIL";
			}
	}

	@Override
	public boolean updateCredential(CredentialsBean credentialsBean) {
        try {
        	if(credentialsBean!=null) {
        		session.clear();
        		Transaction tx=session.beginTransaction();
        		session.update(credentialsBean);
        		tx.commit();
        		return tx.wasCommitted();
        	}else {
        		return false;
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        	return false;
        }
	}

	@Override
	public CredentialsBean findByID(String userID) {
		try {
			if(userID!= null) {
		session.clear();
		Transaction tx = session.beginTransaction();
		CredentialsBean bean=(CredentialsBean)session.get(CredentialsBean.class, userID);
		
		return bean;
			}else {
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
