package com.spring.manage.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.spring.manage.bean.Credentials;
import com.spring.manage.bean.Customer;
import com.spring.manage.util.DBUtil;

public class CustomerDAOImpl implements CustomerDAO{

	private DBUtil dbUtil;
	
	private Credentials credentials=new Credentials();
	

	public void setDbUtil(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}

	@Override
	public String registerCustomer(Customer customer) {
		if(customer!=null) {
			customer.setNumber(900838968);
			credentials.setEmail(customer.getEmail());
			credentials.setPassword(customer.getPassword());
			credentials.setStatus(0);
			credentials.setType("C");
		 Session session=dbUtil.getSessionFactory().getCurrentSession();
		 Transaction  transaction=session.beginTransaction();
		 session.save(customer);
		 session.save(credentials);
		 transaction.commit();
		 return "SUCCSSESS";
		}else {
			return "FAILED";
		}
	}

}
