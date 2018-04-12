package com.org.java.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
			//session.clear();
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

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		User user=null;
		//System.out.println("in user db "+dbUtil);
		try {
			//session.clear();
			session=dbUtil.getSessionFactory().getCurrentSession();
			@SuppressWarnings("unused")
			Transaction transaction=session.beginTransaction();
			System.out.println("in user b dao");
			Criteria crit = session.createCriteria(User.class);
			crit.add( Restrictions.eq("email", email));
			crit.add( Restrictions.eq("password",password));
			List<User> l=crit.list();
			user=l.get(0);
			System.out.println(user.getUserName()+" user name");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
