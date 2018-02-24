package com.spring.dao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itextpdf.text.log.SysoCounter;
import com.spring.bean.*;
import com.spring.util.DBUtil;

public class CustomerDAOImpl implements CustomerDAO{


	static Session session;
	static {
		session = DBUtil.getSessionFactory().openSession();
	}
	@Override
	public String register(CredentialsBean credentialsBean) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, Date date) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String reserveTicket(ReservationBean reservationBean, ArrayList<PassengerBean> passengers) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String generateResId(String scheduleID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int[] getDisFare(String routeID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getReserSeat(String flightID) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean findByCardNumber(String userid, String cardnumber) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String process(CreditCardBean payment, double totalFare) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<ReservationBean, ArrayList<PassengerBean>> viewTicket(String reservationID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean cancelTicket(String reservationId) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int setCapacity(String flightID, int seatingCapacity) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Map<ReservationBean, ArrayList<PassengerBean>> printTicket(String reservationID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<ReservationBean> viewByAllReservations(String uid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<ReservationBean> findByUserID(String userID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProfileBean findCustomerByUserID(String userID) {
		session.clear();
		try {
			if(userID!=null) {
				Transaction tx=session.beginTransaction();
				 return (ProfileBean)session.get(ProfileBean.class, userID);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Integer getSeatNo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

