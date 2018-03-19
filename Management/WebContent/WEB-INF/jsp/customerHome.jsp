<%@page import="com.spring.manage.bean.Credentials"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Credentials credentials=(Credentials)session.getAttribute("credentials");

%>
<ul>
							<li class="current"><a href="/SRS/changePassword" target="allpages">CHANGE PASSWORD</a></li>
							<li class="current"><a href="/SRS/reservation" target="allpages">RESERVATION</a></li>
							<li class="current"><a href="/SRS/cancelTicketById" target="allpages">CANCELLATION</a></li>
							<li class="current"><a href="/SRS/viewTicket" target="allpages">PRINT/SAVE TICKET</a></li>
							
							
							<li class="submenu">
								<a href="#">VIEW</a>
								<ul>
									<li><a href="/SRS/viewShipSchedule" class="button" target="allpages">SHIP/SCHEDULE</a></li>
									<li><a href="/SRS/viewTicket" class="button" target="allpages">TICKET</a></li>
									
								</ul>
							</li>
							
							<li class="submenu">
								<a href="#">ABOUT</a>
								<ul>
									<li><a href="#main" class="button fit scrolly">About Us</a></li>
									<li><a href="#contact" class="button fit scrolly">Contact Us</a></li>
									
								</ul>
							</li>
							<li><a href="/SRS/logout" class="button special">LOGOUT</a></li>
						</ul>
						
						<center><%=credentials.getEmail() %></center>
</body>
</html>