package com.spring.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.spring.bean.RouteBean;
import com.spring.bean.ScheduleBean;
import com.spring.util.DBUtil;

public class ScheduleDAOImpl implements ScheduleDAO {
	static Session session;
	static {
		session = DBUtil.getSessionFactory().openSession();
	}
	@Override
	public String createShipSchedule(ScheduleBean schedulebean) {
		Transaction transaction = null;

		try {
			if (schedulebean != null) {
				
				session.clear();
				transaction = session.beginTransaction();
				RouteDAOImpl routeDAOImpl = new RouteDAOImpl();
				RouteBean routeBean = routeDAOImpl.findByIDRoute(schedulebean.getRouteID());
				String scheduleID = "01";
				schedulebean.setScheduleID(scheduleID);
				session.save(schedulebean);
				transaction.commit();
				return "SUCCESS";
			} else {
				return "FAIL";
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return "ERROR";
		}

		
	}
	@Override
	public int deleteShipSchedule(ArrayList<String> ScheduleID) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean updateShipSchedule(ScheduleBean schedulebean) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public ScheduleBean findByIDSchedule(String scheduleID) {
		Transaction transaction=session.beginTransaction();
		ScheduleBean bean=(ScheduleBean)session.load(ScheduleBean.class, scheduleID);
		transaction.commit();
		return bean;
	}
	@Override
	public ArrayList<ScheduleBean> findAllSchedule() {
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from ScheduleBean");
		ArrayList<ScheduleBean> list= (ArrayList<ScheduleBean>)query.list();
		
		return list;
	}

	

}
