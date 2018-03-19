package com.spring.manage.dao;

import com.spring.manage.bean.Credentials;
import com.spring.manage.bean.Customer;

public interface CustomerDAO {
	
	public String registerCustomer(Customer customer);
	
	public String loginCustomer(Credentials credentials);
	
	public Credentials getCredentialsByEmail(String email);
	
	public String updateCredentials(Credentials credentials);

}
