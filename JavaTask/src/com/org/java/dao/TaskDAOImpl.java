package com.org.java.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.org.java.bean.Task;
import com.org.java.util.DBUtil;

public class TaskDAOImpl implements TaskDAO{
	
	private DBUtil dbUtil;
	private Session session;
	
	public void setDbUtil(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}

	@Override
	public String createNewTask(Task task) {
		String returnString=null;
		try {
		//session.clear();
		session= dbUtil.getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.save(task);
		transaction.commit();
		if(transaction.wasCommitted()) {
			returnString="SUCCESS";
		}else {
			returnString="FAILED";
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return returnString;
	}

	@Override
	public String updateTask(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTask(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getAllTask() {
		List<Task> l=null;
		try {
			//session.clear();
			session= dbUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
			l=session.createQuery("from Task").list();
			transaction.commit();
			}catch(Exception e) {
				e.printStackTrace();
			}
		return l;
	}

	@Override
	public Task getTaskById(Task task) {
		// TODO Auto-generated method stub
		return null;
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
