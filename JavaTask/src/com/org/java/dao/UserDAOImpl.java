package com.org.java.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.org.java.bean.User;
import com.org.java.util.DBUtil;

public class UserDAOImpl implements UserDAO{

	
	private DBUtil dbUtil;
	private Session session;
	
	public void setDbUtil(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}

	@Override
	public String addUser(User user) {
		String returnSrting=null;
		try {
			session.clear();
			session=dbUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
			session.save(user);
			transaction.commit();
			if(transaction.wasCommitted()){
				returnSrting="SUCCESS";
			}else{
				returnSrting="FAILED";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnSrting;
	}

}
