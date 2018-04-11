package com.spring.manage.service;

import java.util.ArrayList;

import com.spring.manage.bean.Schedule;

public interface ScheduleService {
	
	public String addSchedule(Schedule schedule);
	
	public String updateSchedule(Schedule schedule);
	
	public ArrayList<Schedule> getAllSchedule();
	
	public Schedule getScheduelById(Schedule schedule);
	
	public String deleteSchedule(Schedule schedule);

}
