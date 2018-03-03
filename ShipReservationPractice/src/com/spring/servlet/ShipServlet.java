package com.spring.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.spring.bean.ShipBean;
import com.spring.service.AdministratorImpl;

/**
 * Servlet implementation class ShipServlet
 */
public class ShipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	HttpSession session;
    public ShipServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shipid = request.getParameter("shipid");
		String submit = request.getParameter("submit");
		System.out.println(submit+" SUBMIT");
		AdministratorImpl administratorImpl = new AdministratorImpl();
		
		PrintWriter out = response.getWriter();
		
		ShipBean shipBean = new ShipBean();
		if("delete".equals(submit)){
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add(shipid);
		session = request.getSession();
		
		int status = administratorImpl.removeShip(arrayList);
		System.out.println("STATUS"+status);
		if(status>0){
			out.print("1");
			session.setAttribute("remove", "SUCCESS");
		}else{
			out.print("0");
			session.setAttribute("remove", "COULD NOT REMOVE");
		}
		}
		
		if("modify".equals(submit)){
			System.out.println("modify1");
			shipBean = administratorImpl.viewByShipId(shipid);
			out.print("<td><input type='text' value='"+shipBean.getShipID()+"1m' readonly/></td><td><input type='text' value='"+shipBean.getShipName()+"' id='"+shipBean.getShipID()+"NAME' readonly/></td><td><input type='text' value='"+shipBean.getSeatingCapacity()+"' id='"+shipBean.getShipID()+"CAPACITY' maxlength='4' /></td><td><input type='text' value='"+shipBean.getReservationCapacity()+"' id='"+shipBean.getShipID()+"RESERVATION' maxlength='4'/></td><td><button id='modifydetails' onclick='return modifydetails(this.value);' value='"+shipBean.getShipID()+"'>Modify</button></td>");
		}
		
		if("modifydetails".equals(submit)){
			shipBean = administratorImpl.viewByShipId(shipid);
			System.out.println("In Modify details ");
			int reservationCapacity = Integer.parseInt(request.getParameter("reservation"));
			shipBean.setReservationCapacity(reservationCapacity);
			
			int seatingCapacity = Integer.parseInt(request.getParameter("capacity"));
			shipBean.setSeatingCapacity(seatingCapacity);
			
			shipBean.setShipName(request.getParameter("name"));
			
			
			if(administratorImpl.modifyShip(shipBean)){
				System.out.println("Details MODIFIED");
				out.print("Details modified for "+shipBean.getShipID());
			}
		}
		
		
	}

	

}
