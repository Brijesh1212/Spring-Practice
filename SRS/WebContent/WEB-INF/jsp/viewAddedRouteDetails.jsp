<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.wipro.srs.bean.RouteBean"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/table.css"/>" />
		
		<!--[if IE]>
  		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<title>Details Added</title>

<style>
.shadow {
    background-color: #fff;
    background-color: rgba(0,0,0,0.2);
	width:auto;
	height:auto;
	display:inline-block;
	padding: 2em 3em 2em 2em;
	color: white;
}

h1{
letter-spacing: 2px;
}
th{
text-align: center;
}
td{
text-align: center;
color: grey;
}
</style>
</head>
<body>
<%
	session = request.getSession();
	RouteBean bean = (RouteBean)session.getAttribute("routeBean");
	
%>
<center>
<div class="shadow" align="center">
<h1>Route has been added</h1>
<table style="margin: 0px; width: 100%;">
	<tr>
		<th>Route ID</th>
		<th>Source</th>
		<th>Destination</th>
		<th>Travel Duration</th>
		<th>Fare</th>
	</tr>
	<tr>
		<td><%=bean.getRouteID() %></td>
		<td><%=bean.getSource() %></td>
		<td><%=bean.getDestination() %></td>
		<td><%=bean.getTravelDuration() %></td>
		<td>$ <%=bean.getFare() %></td>
	</tr>
</table>
</div>

</center>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-throttle-debounce/1.1/jquery.ba-throttle-debounce.min.js"></script>
		<script src="<c:url value="/resources/js/jquery.stickyheader.js"/>" ></script>
</body>
</html>