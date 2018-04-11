package com.org.java.bo;

import java.util.Date;
import java.util.List;

import com.org.java.bean.Task;

public interface TaskBO {
    
	public String addNewTask(Task task);
	
	public String updateTask(Task task);
	
	public String deleteTask(Task task);
	
	public List<Task> getAllTask();
	
	public Task getTaskById(Task task);
	
	public Task getTaskByDate(Date date);
	
	public Task getTaskByStartTime(Date date);
	
	public Task getTaskByEndTime(Date date);
	
	public String changeStatus(Task task);

}