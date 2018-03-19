<%@page import="com.spring.manage.dao.ShipDAOImpl"%>
<%@page import="com.spring.manage.dao.ShipDAO"%>
<%@page import="com.spring.manage.service.RouteServiceImpl"%>
<%@page import="com.spring.manage.dao.RouteDAOImpl"%>
<%@page import="com.spring.manage.service.RouteService"%>
<%@page import="com.spring.manage.bean.Route"%>
<%@page import="com.spring.manage.bean.Ship"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.spring.manage.service.ShipServiceImpl"%>
<%@page import="com.spring.manage.service.ShipService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ShipDAO shipService=new ShipDAOImpl();
RouteDAOImpl routeService=new RouteDAOImpl();
System.out.println("Ship: "+routeService+" : "+shipService+" : "+shipService.getAllShip());
ArrayList<Ship> l=shipService.getAllShip();
ArrayList<Route> r=routeService.getRoutes();
%>
<div>${message}</div>
<form:form>
    <form:input path="id" type="hidden"/>
    <form:select path="shipId">
    <form:option value="">Select Ship</form:option>
    <%
    for(Ship s:l){
    	%>
    	    <form:option value="<%=s.getClass()%>"><%=s.getName() %></form:option>
    	<%
    }
    %>
    </form:select>
    <form:select path="routeId">
    <form:option value="">Select Route</form:option>
    <%
    for(Route ro:r){
    %>
    	    <form:option value="<%=ro.getClass()%>">S: <%=ro.getSource() %> D: <%=ro.getDestination() %></form:option>
    	<%
    	}
    	%>
    </form:select>
    <form:input path="fare" placeholder="Fare"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>