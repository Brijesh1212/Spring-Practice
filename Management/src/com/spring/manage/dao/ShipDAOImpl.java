package com.spring.manage.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.spring.manage.bean.Route;
import com.spring.manage.bean.Ship;
import com.spring.manage.util.DBUtil;

public class ShipDAOImpl implements ShipDAO {
	
	static Session session;
	static {
		session = new DBUtil().getSessionFactory().openSession();
	}
	
	DBUtil dbUtil;
	
	public void setDbUtil(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}

	@Override
	public String addShip(Ship ship) {
		Session session= dbUtil.getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.save(ship);
		transaction.commit();
		return "SUCCESS";
	}


	@Override
	public String UpdateShip(Ship ship) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteShip(Ship ship) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Ship> getAllShip() {
		System.out.println("In Get all ship");
		//Session session= dbUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		ArrayList<Ship> l= (ArrayList<Ship>) session.createQuery("from Ship").list();
		transaction.commit();
		return l;
	}

	@Override
	public String getShipById(Ship ship) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getShipByRoute(Route route) {
		// TODO Auto-generated method stub
		return null;
	}

}
