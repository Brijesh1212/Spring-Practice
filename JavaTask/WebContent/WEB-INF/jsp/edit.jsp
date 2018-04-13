<%@page import="org.springframework.ui.Model"%>
<%@page import="com.org.java.controller.TaskController"%>
<%@page import="io.jsonwebtoken.IncorrectClaimException"%>
<%@page import="io.jsonwebtoken.MissingClaimException"%>
<%@page import="java.security.Key"%>
<%@page import="io.jsonwebtoken.Jwts"%>
<%@page import="io.jsonwebtoken.Claims"%>
<%@page import="io.jsonwebtoken.Jws"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Task</title>
<link href="<c:url value="/resources/css/elements.css" />" rel="stylesheet">
</head>
<body id="body" >
<%
Key key= (Key)session.getAttribute("key");
String userName=(String)session.getAttribute("userName");
String email=(String)session.getAttribute("email");
String compactJws=(String)session.getAttribute("jwToken");
try {
    Jws<Claims> claims = Jwts.parser()
        .requireSubject(email)
        .setSigningKey(key)
        .parseClaimsJws(compactJws);
    System.out.println(claims.getBody());
} catch (MissingClaimException e) {
	e.printStackTrace();
} catch (IncorrectClaimException e) {
	e.printStackTrace();
}
%>

<div id="popupContact">
<form action="updateTask" id="form" method="post" name="form">
<input id="name" name="id"  type="hidden" value="${task.id }">
<img id="close" src="images/3.png" onclick ="div_hide()">
<h2>Update Task</h2>
<hr>
Start Time
<input id="name" name="stime"  type="text" value="${task.startTime }"><br>
End Time
<input id="email" name="etime"  type="text" value="${task.endTime }">
<br>
Date of task
<input id="email" name="date"  type="text" value="${task.taskDate }"><br>
Status
<select name="status">
<option value="New">New</option>
<option value="Started">Started</option>
<option value="Completed">Completed</option>
</select>
Objective
<textarea id="msg" name="objective"  >${obj }</textarea>
<input type="submit" value="Update">
</form>
</div>
</body>
</html>