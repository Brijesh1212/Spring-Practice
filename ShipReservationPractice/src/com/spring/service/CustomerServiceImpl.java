package com.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;


import com.spring.bean.CredentialsBean;
import com.spring.bean.PassengerBean;

import com.spring.bean.CreditCardBean;
import com.spring.bean.ProfileBean;
import com.spring.bean.ReservationBean;
import com.spring.bean.ScheduleBean;
import com.spring.dao.CustomerDAOImpl;
import com.spring.dao.LoginDAO;
import com.spring.dao.LoginDAOImpl;


public class CustomerServiceImpl implements CustomerService{
	
	

	CustomerDAOImpl customerDAO = new CustomerDAOImpl();

    
	public String register(CredentialsBean credentialsBean) {
		
		return this.customerDAO.register(credentialsBean);

	}


	@Override
	public ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, Date date) {
		return customerDAO.viewScheduleByRoute(source, destination, date);
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
		return customerDAO.getReserSeat(flightID);
	}


	@Override
	public boolean findByCardNumber(String userid, String cardnumber) {
		
		return customerDAO.findByCardNumber(userid, cardnumber);
	}


	@Override
	public String process(CreditCardBean payment, double totalFare) {
		return customerDAO.process(payment, totalFare);
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
	public ProfileBean findProfileByUserID(String userID) {
		if(userID!=null) {
			return customerDAO.findCustomerByUserID(userID);
		}else {
			return null;
			}
	}

	
}
