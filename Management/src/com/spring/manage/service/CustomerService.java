package com.spring.manage.service;

import com.spring.manage.bean.Credentials;
import com.spring.manage.bean.Customer;

public interface CustomerService {

	public String registerCustomer(Customer customer);
	
	public String login(Credentials credentials);
	
	public Credentials getCredentilsByEmail(String email);
	
	public String updateCredentials(Credentials credentials);
	
}
