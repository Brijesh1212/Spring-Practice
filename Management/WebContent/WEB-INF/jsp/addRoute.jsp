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
<form:form action="addRouteDetails" method="Post">
   <form:hidden path="id" placeholder="id"/><br>
   <form:input path="Source" placeholder="source"/><br>
   <form:input path="Destination" placeholder="destination"/><br>
   <input type="submit" value="Save">
</form:form>
</body>
</html>