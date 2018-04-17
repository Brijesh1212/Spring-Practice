package com.org.java.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
		String returnString=null;
		try {
		//session.clear();
		session= dbUtil.getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.update(task);
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
	public String deleteTask(Task task) {
		String returnString=null;
		System.out.println("in delete dao");
		try {
		Session session1= dbUtil.getSessionFactory().openSession();
		Transaction transaction=session1.beginTransaction();
		Query qry = session1.createQuery("delete from Task t where t.id=:i and t.status !=:s");
				         qry.setParameter("i",task.getId());
				         qry.setParameter("s", "completed");
				         int i = qry.executeUpdate();
		System.out.println("in delete dao q");
		if(i>0) {
			returnString="SUCCESS";
		}else {
			returnString="FAILED";
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return returnString;
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
		Task task2=null;
		try {
			//session.clear();
			Session se= dbUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=se.beginTransaction();
			task2=(Task)se.get(Task.class, task.getId());
			transaction.commit();
			}catch(Exception e) {
				e.printStackTrace();
			}
		// System.out.println("Task : "+task2.getObjectiveOfTheTask()+" "+task2.getStartTime()+" "+task2.getEndTime()+" "+task2.getStatus()+" "+task2.getTaskDate()+" "+task2.getId());
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
