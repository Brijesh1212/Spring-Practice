package com.spring.manage.service;

import java.util.ArrayList;

import com.spring.manage.bean.Schedule;
import com.spring.manage.dao.ScheduleDAO;

public class ScheduleServiceImpl implements ScheduleService{

	private ScheduleDAO scheduleDAO;
	

	public void setScheduleDAO(ScheduleDAO scheduleDAO) {
		this.scheduleDAO = scheduleDAO;
	}

	@Override
	public String addSchedule(Schedule schedule) {
		return scheduleDAO.addSchedule(schedule);
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

	@Override
	public String deleteSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return null;
	}

}
