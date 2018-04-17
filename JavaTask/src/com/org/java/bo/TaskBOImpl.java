package com.org.java.bo;

import java.util.Date;
import java.util.List;

import com.org.java.bean.Task;
import com.org.java.dao.TaskDAO;

public class TaskBOImpl implements TaskBO{
	
	private TaskDAO taskDAO;
    
	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

	@Override
	public String addNewTask(Task task) {
		String returnString=null;
		try {
			returnString=taskDAO.createNewTask(task);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnString;
	}

	@Override
	public String updateTask(Task task) {
		return taskDAO.updateTask(task);
	}

	@Override
	public String deleteTask(Task task) {
		System.out.println("in delete bo");
		return taskDAO.deleteTask(task);
	}

	@Override
	public List<Task> getAllTask() {
		List<Task> l=null;
		try {
			 l= taskDAO.getAllTask();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public Task getTaskById(Task task) {
		Task task2=taskDAO.getTaskById(task);
		return task2;
	}

	@Override
	public Task getTaskByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task getTaskByStartTime(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task getTaskByEndTime(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeStatus(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

}
