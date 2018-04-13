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
<script src="<c:url value="/resources/js/my_js.js" />"></script>
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
<div id="abc">

<!-- Popup Div Starts Here -->
<div id="popupContact">
<!-- Contact Us Form -->
<form action="addTask" id="form" method="post" name="form">
<img id="close" src="images/3.png" onclick ="div_hide()">
<h2>Add Task</h2>
<hr>
Start Time
<input id="name" name="stime" placeholder="Name" type="time"><br>
End Time
<input id="email" name="etime" placeholder="Email" type="time">
<br>
Date of task
<input id="email" name="date" placeholder="Email" type="date">
<textarea id="msg" name="objective" placeholder="Objective of task"></textarea>
<a href="javascript:%20check_empty()" id="submit">Send</a>
</form>
</div>
<!-- Popup Div Ends Here -->
</div>
<button id="logout"> <a href="/JavaTask/logout" >Logout</a></button>

<div><input type="text" placeholder="Filter" id="filter"></div>

<div id="taskDetails">
<div>
      <div style="color: white;">${message}</div> 
  <c:forEach items="${l}" var="l">
 <div style="background-color: gray;"> 
  <div style="padding: 5px; ">
    	   <div ><div style="font-weight: bold;background-color: white;padding: 5px">objective of task</div> <div style="background-color: green;padding: 15px"> ${l.objectiveOfTheTask}</div> </div>
    	    <div><div style="font-weight: bold;background-color: white;padding: 5px"> Start of task</div> <div style="background-color: green;padding: 15px">${l.startTime}</div></div>
    	    <div><div style="font-weight: bold;background-color: white;padding: 5px">End of task </div><div style="background-color: green;padding: 15px">${l.endTime}</div></div>
    	  <div><div style="font-weight: bold;background-color: white;padding: 5px">Status  </div><div style="background-color: green;padding: 15px"> ${l.status}</div></div>
    	  <div><a href="/JavaTask/editTask?id=${l.id }" style="text-decoration: none;">Edit</a></div>
    	  <div><a href="/JavaTask/deleteTask?id=${l.id }" style="text-decoration: none;">Delete</a></div> 
    </div>
    </div><br><br><br>
    </c:forEach>
</div>
</div>

<!-- user details -->
<div id="userDetails">
<div><h3 >User Details</h3></div>
<div id="user">
<div><%=userName %></div>
<div><%=email %></div>
<div><%=session.getAttribute("userAddress") %></div>
</div>
<br>
</div>
<button id="popup" onclick="div_show()">Create New</button>
</body>
</html>