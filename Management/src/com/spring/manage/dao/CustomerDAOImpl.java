package com.spring.manage.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.spring.manage.bean.Customer;
import com.spring.manage.util.DBUtil;

public class CustomerDAOImpl implements CustomerDAO{

	private DBUtil dbUtil;
	
	public void setDbUtil(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}

	@Override
	public String registerCustomer(Customer customer) {
		if(customer!=null) {
		 Session session=dbUtil.getSessionFactory().getCurrentSession();
		 Transaction  transaction=session.beginTransaction();
		 session.save(customer);
		 transaction.commit();
		 return "SUCCSSESS";
		}else {
			return "FAILED";
		}
	}

}
