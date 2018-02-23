package com.spring.dao;

//import java.util.ArrayList;

import com.spring.bean.CredentialsBean;
import com.spring.bean.ProfileBean;

public interface LoginDAO {
	String createCustomer(ProfileBean profileBean);
	//int deleteXYZ(ArrayList<String>);
	boolean updateCredential(CredentialsBean credentialsBean);
	CredentialsBean findByID(String userID);
	//ArrayList<BeanObject> findAll();
}
