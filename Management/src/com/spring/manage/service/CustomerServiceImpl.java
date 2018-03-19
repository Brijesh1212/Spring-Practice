package com.spring.manage.service;

import com.spring.manage.bean.Credentials;
import com.spring.manage.bean.Customer;
import com.spring.manage.dao.CustomerDAO;

public class CustomerServiceImpl implements CustomerService{

	CustomerDAO customerDAO;
	
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public String registerCustomer(Customer customer) {
		System.out.println("In CustomerService RegC");
		return customerDAO.registerCustomer(customer);
	}

	@Override
	public String login(Credentials credentials) {
		return customerDAO.loginCustomer(credentials);
	}

	@Override
	public Credentials getCredentilsByEmail(String email) {
		return customerDAO.getCredentialsByEmail(email);
	}

	@Override
	public String updateCredentials(Credentials credentials) {
		
		return customerDAO.updateCredentials(credentials);
	}

}
