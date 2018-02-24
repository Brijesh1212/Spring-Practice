<%@page import="com.spring.service.CustomerServiceImpl"%>
<%@page import="com.spring.bean.ProfileBean"%>
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
if(session!=null){
String userid = (String)session.getAttribute("userid");
ProfileBean profileBean ;
CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
if((profileBean = customerServiceImpl.findProfileByUserID(userid))!=null){
	

%>
<center><h2>Welcome, <b><%=profileBean.getFirstName() %></b></h2></center>

<% }else{

%><center><h2>Welcome, <b><%=userid %></b></h2></center>
	
	
<% }
}else{

	response.sendRedirect("/SRS/login");
}
%>
</body>
</html>