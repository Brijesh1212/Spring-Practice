package com.spring.manage.service;

import com.spring.manage.bean.Customer;

public interface CustomerService {

	public String registerCustomer(Customer customer);
	
	public void login(Customer customer);
	
}
