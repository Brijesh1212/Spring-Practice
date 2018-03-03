package com.spring.dao;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Query;
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
		Transaction transaction= session.beginTransaction();
		
		for (Iterator iterator = ShipId.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			ShipBean bean=new ShipBean();
			bean.setShipID(string);
			session.delete(bean);
			transaction.commit();
			System.out.println("Deleted"); 
		}
		return 1;
	}

	@Override
	public boolean updateShip(ShipBean shipbean) {
		Transaction transaction= session.beginTransaction();
		session.update(shipbean);
		transaction.commit();
		return true;
	}

	@Override
	public ShipBean findByID(String ShipId) {
		Transaction transaction= session.beginTransaction();
		ShipBean shipBean=(ShipBean)session.load(ShipBean.class, ShipId);
		transaction.commit();
		return shipBean;
	}

	@Override
	public ArrayList<ShipBean> findAll() {
		Transaction transaction= session.beginTransaction();
		Query query= session.createQuery("from ShipBean");
		transaction.commit();
		Iterator<ShipBean> iterator=query.iterate();
		ArrayList<ShipBean> arrayList=new ArrayList<ShipBean>();
		while (iterator.hasNext()) {
			ShipBean shipBean = (ShipBean) iterator.next();
			arrayList.add(shipBean);
		}
		return arrayList;
	}

	@Override
	public ArrayList<PassengerBean> findPasengersByShip(String scheduleid) {
		// TODO Auto-generated method stub
		return null;
	}

}
