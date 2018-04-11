package com.spring.manage.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.spring.manage.bean.Schedule;
import com.spring.manage.util.DBUtil;

public class ScheduleDAOImpl implements ScheduleDAO{
	
	private DBUtil dbUtil;
	

	public void setDbUtil(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}

	@Override
	public String addSchedule(Schedule schedule) {
		Session session=dbUtil.getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.save(schedule);
		transaction.commit();
		return "SUCCESS";
	}

	@Override
	public String updateSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Schedule> getAllSchedule() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Schedule getScheduelById(Schedule schedule) {
		// TODO Auto-generated method stub
		return null;
	}

}
