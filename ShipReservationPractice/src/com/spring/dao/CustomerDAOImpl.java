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
import com.spring.bean.PassengerBean;
import com.spring.bean.ReservationBean;
import com.spring.bean.ShipBean;
import com.spring.bean.CreditCardBean;
import com.spring.bean.RouteBean;
import com.spring.bean.ScheduleBean;

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
	public ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, Date date)
	 {
		 System.out.println(date);
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		 Calendar c = Calendar.getInstance();
		 c.setTime(date); 
		 
		 String output1 = sdf.format(c.getTime());
		 System.out.println("Out put 1: "+output1);
		 c.add(Calendar.DATE, 7); 
		 String output = sdf.format(c.getTime());
		 System.out.println("Out put : "+output);
		 
        ArrayList<ScheduleBean> slist= new ArrayList<ScheduleBean>();

        session.beginTransaction();
        String SQL_QUERY ="from RouteBean where source=:source and destination=:destination";
        Query query = session.createQuery(SQL_QUERY);
        query.setParameter("source",source);    
        query.setParameter("destination",destination);
        ArrayList<RouteBean> rlist=  (ArrayList<RouteBean>) query.list();
        if(rlist.isEmpty()){
       	 return null;
        }
        else{
        String routeID=rlist.get(0).getRouteID();
        String SQL_QUERY1 ="from ScheduleBean where routeID=? and ( startDate >= ? and startDate < ? )";
        Query query1 = session.createQuery(SQL_QUERY1);
        query1.setParameter(0, routeID);
        query1.setParameter(1, new Date(output1));
        query1.setParameter(2, new Date(output));
        Iterator<ScheduleBean> itr = query1.iterate();
        while(itr.hasNext()){
       	 ScheduleBean scheduleBean = (ScheduleBean)itr.next();
       	 slist.add(scheduleBean);
       	 System.out.println(slist.get(0).getScheduleID());
        }
        if(slist.isEmpty()){
       	 return null;
        }
        }
        session.getTransaction().commit();
        return slist;
        
	 }
	@Override
	public String reserveTicket(ReservationBean reservationBean, ArrayList<PassengerBean> passengers) {
		session.clear();
		Transaction transaction = session.beginTransaction();
	    session.save(reservationBean);
	    transaction.commit();
	   
		for(int i=0;i<passengers.size();i++)
		{
				session.clear();
				Transaction tx = session.beginTransaction();
				session.save(passengers.get(i));
				tx.commit();
		
		}
		
			
			return "SUCCESS";
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
	public int getReserSeat(String shipID) {
		session.clear();
		Transaction tx = session.beginTransaction();
        String SQL_QUERY ="from ShipBean where ShipID=:ShipID";
        Query query = session.createQuery(SQL_QUERY);
        query.setParameter("ShipID",shipID);
        ShipBean shipBean=(ShipBean)query.uniqueResult();
        shipBean.getReservationCapacity();
        tx.commit();
        return shipBean.getReservationCapacity();
	}
	@Override
	public boolean findByCardNumber(String userid, String cardnumber) {
		session.beginTransaction();
        SQLQuery q=session.createSQLQuery("select creditcardnumber from srs_tbl_creditcard where userid=? and creditcardnumber=?");
        q.setParameter(0, userid);
        q.setParameter(1, cardnumber);
        String cdno=(String)q.uniqueResult();
        session.getTransaction().commit();
        
        if(cdno!=null)
        {
        	return true;
        }
        else
        {
        	return false;
        }
	}
	@Override
	public String process(CreditCardBean payment, double totalFare) {
		session.beginTransaction();
		String userID=payment.getUserID();
		String creditCardNumber=payment.getCreditCardNumber();
		String hql_query="from CreditCardBean where userID=:userid and creditCardNumber=:creditCardNumber";
		Query query=session.createQuery(hql_query);
		query.setParameter("userid",userID);
		query.setParameter("creditCardNumber",creditCardNumber);
		CreditCardBean pay=(CreditCardBean)query.uniqueResult();
		double balance=0;
		double bal=0;
		

		

		if (pay != null) 
        {
			String dateFrom[] = pay.getValidFrom().split("-");
			String jspDateFrom[] = payment.getValidFrom().split("-");
			String dateTo[] = pay.getValidTo().split("-");
			String jspDateTo[] = payment.getValidTo().split("-");
			String todaysDate[] = String.valueOf(new Date()).split(" ");
			
			System.out.println(Arrays.toString(dateTo)+" : "+Arrays.toString(jspDateTo)+" : "+todaysDate[5]);
     	    balance=pay.getBalance();
     	    if(dateFrom[0].equals(jspDateFrom[0]) && dateFrom[1].equals(jspDateFrom[1])){
     	    	if(dateTo[0].equals(jspDateTo[0]) && dateTo[1].equals(jspDateTo[1])){
     	    		System.out.println("::::"+dateTo[1]+":::"+jspDateTo[0]);
     	    		if(Integer.parseInt(todaysDate[5])<=Integer.parseInt(dateTo[0])){
     	    			if(balance>totalFare){
     	    	     		 bal=balance-totalFare;   
     	    	     	   }
     	    	     	   else
     	    	     		   return "Insufficient Credit Balance";   
     	    		}else{
     	    			return "Credit Card Expired";
     	    		}
     	    	}else{
     	    		return "Valid To date is incorrect";
     	    	}
     	    }else{
     	    	return "Valid from date is incorrect";
     	    }
     	   
     	
        }else{
			return "FAIL";
		}
		String hql_query1="Update CreditCardBean set balance=:creditBalance where userID=:userID and creditCardNumber=:creditCardNumber";
		Query query1=session.createQuery(hql_query1);
		query1.setParameter("creditBalance",bal);
		query1.setParameter("userID",userID);
		query1.setParameter("creditCardNumber",creditCardNumber);
		int f=query1.executeUpdate();
		session.getTransaction().commit();
		if(f==1)
		return "SUCCESS";
		else
			return "FAIL";
	}
	@Override
	public Map<ReservationBean, ArrayList<PassengerBean>> viewTicket(String reservationID) {
		session.clear();
		Transaction tx = session.beginTransaction();
		String sql="from ReservationBean where reservationID=?";
		Query q=session.createQuery(sql);
		q.setParameter(0,reservationID);
		
		
		
		ReservationBean reservationBean=(ReservationBean)q.uniqueResult();
		
		String sql2="from PassengerBean where reservationID=?";
		Query q4=session.createQuery(sql2);
		q4.setParameter(0,reservationID);
		@SuppressWarnings("unchecked")
		Iterator<PassengerBean> itr = q4.iterate();
		ArrayList<PassengerBean> beans = new ArrayList<PassengerBean>();
		while(itr.hasNext()){
			PassengerBean passengerBean = (PassengerBean)itr.next();
			beans.add(passengerBean);
			System.out.println("P Name: "+passengerBean.getName());
		}
		if(reservationBean==null || beans==null){
			return null;
		}

		Map<ReservationBean,ArrayList<PassengerBean>> map=new HashMap<ReservationBean,ArrayList<PassengerBean>>();
		map.put(reservationBean,beans);	
		tx.commit();
		return map;
	}
	@Override
	public boolean cancelTicket(String reservationID) {
		session.clear();
		Transaction tx = session.beginTransaction();
		 
		Query rquery2=session.createQuery("from ReservationBean where reservationID=?");
		rquery2.setParameter(0, reservationID);
		ReservationBean l=(ReservationBean)rquery2.uniqueResult();
		String uid=l.getUserID();
		double fare=l.getTotalFare();
		
		Query rquery3=session.createQuery("from CreditCardBean where userID=?");
		rquery3.setParameter(0, uid);
		CreditCardBean p=(CreditCardBean)rquery3.uniqueResult();
		double remBalance=p.getBalance();
		double balance=remBalance+fare;
		
		Query rquery4=session.createQuery("Update CreditCardBean set balance=? where userID=?");
		rquery4.setParameter(0, balance);
		rquery4.setParameter(1, uid);
		rquery4.executeUpdate();
		
		System.out.println("Balance : "+balance);
		
		Query rquery=session.createQuery("Delete from ReservationBean where reservationID=?");
		rquery.setParameter(0, reservationID);
		rquery.executeUpdate();
		
		Query rquery1=session.createQuery("Delete from PassengerBean where reservationID=?");
		rquery1.setParameter(0, reservationID);
		rquery1.executeUpdate();
		
		
		tx.commit();
		return true;
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
		try {
			session.clear();
			
			Transaction transaction=null;
			transaction = session.beginTransaction();
			/*System.out.println(scheduleId);*/
			ReservationBean reservationBean=new ReservationBean();
			Query query = session.createQuery("from ReservationBean as get where get.userID=?");
			query.setString(0, userID);
			@SuppressWarnings("unchecked")
			Iterator<ReservationBean> iterator=query.iterate();
			
			ArrayList<ReservationBean> arrayList=new ArrayList<ReservationBean>();
			while(iterator.hasNext()){
				
				 reservationBean=(ReservationBean)iterator.next();
				 arrayList.add(reservationBean);
				
			}
			transaction.commit();
			return arrayList;
			
			
			
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			
		}
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
		try {
			session.clear();
			
			Transaction transaction=null;
			transaction = session.beginTransaction();
			String hql= "select max(seats) from PassengerBean"; 
			List list = session.createQuery(hql).list(); 
			int maxID = ( (Integer)list.get(0) ).intValue(); 
			transaction.commit();
			return maxID;
			}catch(Exception exception){
			
				exception.printStackTrace();
				return 0;
			}
	}
	
}

