package com.spring.manage.dao;

import org.hibernate.Query;
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

	@Override
	public String loginCustomer(Credentials credentials) {
		if(credentials!=null) {
			Session session=dbUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
			Query query=session.createQuery("from Credentials where email=:email and password=:password");
			query.setParameter("email", credentials.getEmail());
			query.setParameter("password", credentials.getPassword());
			Credentials credentials2=(Credentials) query.uniqueResult();
			transaction.commit();
			if(credentials2!=null) {
				return "SUCCESS";
			}else {
				return "FAIL";
			}
		}else {
			return "FAIL";
		}
		
	}

	@Override
	public Credentials getCredentialsByEmail(String email) {
		Session session=dbUtil.getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from Credentials where email=:email");
		query.setParameter("email", email);
		Credentials credentials= (Credentials)query.uniqueResult();
		transaction.commit();
		return credentials;
	}

	@Override
	public String updateCredentials(Credentials credentials) {
		if(credentials!=null) {
		Session session=dbUtil.getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.update(credentials);
		transaction.commit();
		return "SUCCESS";
		}else {
			return "FAIL";
		}
	}

}
