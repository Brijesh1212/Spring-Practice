package com.spring.manage.dao;

import java.util.ArrayList;

import com.spring.manage.bean.Schedule;

public interface ScheduleDAO {
	
public String addSchedule(Schedule schedule);
	
	public String updateSchedule(Schedule schedule);
	
	public ArrayList<Schedule> getAllSchedule();
	
	public Schedule getScheduelById(Schedule schedule);
	
}
