<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
  function validate() {
	var email=document.getElementById("email").value;
	var password=document.getElementById("password").value;
	
	if(email.length==0){
		document.getElementById("error1").innerHTML="Email must be entered";
		return false;
	}
	if(password.length==0){
		document.getElementById("error2").innerHTML="Password must be entered";
		return false;
	}
}
</script>
</head>
<body>
<form:form action="login" >
<div>${message}</div>
   <form:hidden path="id"/>
   <form:input path="email" id="email"/>
   <div id="error1" style="color: red"></div>
   <form:input path="password" id="password"/>
   <div id="error2" style="color: red"></div>
   <input type="submit" value="Login" onclick="return validate()">
</form:form>
Need an account? <a href="/Management/registration">Click Here</a>
</body>
</html>