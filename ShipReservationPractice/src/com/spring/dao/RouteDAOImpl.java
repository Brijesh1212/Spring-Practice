package com.spring.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.spring.bean.RouteBean;
import com.spring.util.DBUtil;

import antlr.collections.List;

public class RouteDAOImpl implements RouteDAO {
	static Session session;
	static {
		session = DBUtil.getSessionFactory().openSession();
	}
	@Override
	public String createShipRoute(RouteBean routebean) {
		Transaction transaction= session.beginTransaction();
		System.out.println(routebean.getSource());
		session.save(routebean);
		transaction.commit();
		return "SUCCESS";
	}
	@Override
	public int deleteShipRoute(ArrayList<String> routeID) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean updateShipRoute(RouteBean routebean) {
		Transaction transaction= session.beginTransaction();
		session.update(routebean);
		return true;
	}
	@Override
	public RouteBean findByIDRoute(String routeID) {
		Transaction transaction= session.beginTransaction();
		RouteBean bean= (RouteBean)session.get(RouteBean.class, routeID);
		transaction.commit();
		return bean;
	}
	@Override
	public ArrayList<RouteBean> findAllRoute() {
		Transaction transaction= session.beginTransaction();
		Query query= session.createQuery("from RouteBean");
		transaction.commit();
		ArrayList<RouteBean> arrayList=new ArrayList<RouteBean>();
		Iterator<RouteBean> iterator=query.iterate();
		while (iterator.hasNext()) {
			RouteBean routeBean = (RouteBean) iterator.next();
			arrayList.add(routeBean);
			System.out.println(routeBean.getSource());
		}
		return arrayList;
	}
	
}
