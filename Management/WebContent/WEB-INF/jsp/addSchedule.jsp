<%@page import="com.spring.manage.controller.AdminController"%>
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
<div>${message}</div>
<form action="scheduleDetails" method="post">
    <select name="shipId" >
    <option value="">Select Ship</option>
    <c:forEach items="${shipList}" var="shipList">
    	    <option value="${shipList.id}">${shipList.name}</option>
    </c:forEach>
    </select><br>
    <select name="routeId">
    <option value="">Select Route</option>
    <c:forEach items="${routeList}" var="routeList">
    	    <option value="${routeList.id}">S: ${routeList.source} D: ${routeList.destination}</option>
    </c:forEach>
    </select><br>
    <input name="fare" placeholder="Fare"/><br>
    <input type="submit" value="Save">
</form>
</body>
</html>