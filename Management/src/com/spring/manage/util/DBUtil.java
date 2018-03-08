package com.spring.manage.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class DBUtil {
	
private   SessionFactory sessionFactory;
	
	public  SessionFactory getSessionFactory()
	{
		try{
			sessionFactory =new AnnotationConfiguration().configure().buildSessionFactory();
		}catch(Throwable ex)
		{
			System.out.println("Initial Session factory creation failed "+ex );
			throw new ExceptionInInitializerError(ex);
		}

		return sessionFactory;
	}

}
