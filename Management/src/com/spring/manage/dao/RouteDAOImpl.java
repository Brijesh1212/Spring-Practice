package com.spring.manage.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.spring.manage.bean.Route;
import com.spring.manage.util.DBUtil;

public class RouteDAOImpl implements RouteDAO{
	
	DBUtil dbUtil;

	public void setDbUtil(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}

	@Override
	public String addRoute(Route route) {
		Session session= dbUtil.getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.save(route);
		transaction.commit();
		return "SUCCESS";
	}

	@Override
	public String deleteRoute(Route route) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateRoute(Route route) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Route> getRoutes() {
		Session session= dbUtil.getSessionFactory().openSession();
		System.out.println("In route get");
		Transaction transaction=session.beginTransaction();
		ArrayList<Route> r=(ArrayList<Route>) session.createQuery("from Route").list();
		transaction.commit();
		return r;
	}

	@Override
	public Route getRouteById(Route route) {
		// TODO Auto-generated method stub
		return null;
	}

}
