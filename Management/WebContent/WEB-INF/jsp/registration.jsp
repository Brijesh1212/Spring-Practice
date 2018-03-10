<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
<form:form method="POST" action="registerCustomer"  >
   <form:input path="firstName" placeholder="f-name" /><br>
    <form:input path="lastName" placeholder="l-name" /><br>
    <form:input path="email" placeholder="email" /><br>
    <form:input path="password" placeholder="password" /><br>
    <form:input path="address" placeholder="address" /><br>
   <input class="form-control" type="submit" value="Login" onclick="return validate()"/>
</form:form>
</body>
</html>