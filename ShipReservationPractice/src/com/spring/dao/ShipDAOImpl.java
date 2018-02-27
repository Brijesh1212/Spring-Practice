package com.spring.dao;

import java.util.ArrayList;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.spring.bean.PassengerBean;
import com.spring.bean.ShipBean;
import com.spring.util.DBUtil;

public class ShipDAOImpl implements ShipDAO{
	
	static Session session;
	static {
		session = DBUtil.getSessionFactory().openSession();
	}

	@Override
	public String createShip(ShipBean shipbean) {
		Transaction transaction = null;

		try {
			if (shipbean != null) {
				session.clear();
				transaction = session.beginTransaction();
				String shipID = (shipbean.getShipName().substring(0,2)+Math.random()*10).substring(0, 3);
				shipbean.setShipID(shipID);
				session.save(shipbean);
				transaction.commit();
				return "SUCCESS";
			} else {
				return "FAIL";
			}
			
		}

		catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

	@Override
	public int deleteShip(ArrayList<String> ShipId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateShip(ShipBean shipbean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ShipBean findByID(String ShipId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ShipBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PassengerBean> findPasengersByShip(String scheduleid) {
		// TODO Auto-generated method stub
		return null;
	}

}
