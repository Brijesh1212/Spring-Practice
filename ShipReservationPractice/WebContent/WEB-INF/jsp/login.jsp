<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="POST" action="loginuser"  >
   <table align="center">
    <tr ><td colspan="2" align="center"><font color="#E44D4F">${failed}</font><font color="#24AB85">${changed}${success}</font></td></tr>
    <tr><td></td><td align="center" colspan="2" ><font color="#E44D4F">${invalid}${loginagain}</font></td></tr>
    <tr>
        <td><b><form:label path="userID" style="position:relative;margin-top:10px; margin-left:-45px;font-size:20px;">User ID</form:label></b></td>
        <td><form:input class="form-control" path="userID" style="text-align:center;" placeholder="User ID" id="userID" required="required"/></td>
    </tr>
    <tr><td></td><td><font color=#E44D4F><div id="error1">${error}</div></font></td></tr>
    <tr>
        <td><b><form:label path="password" style="position:absolute;margin-top:5px; margin-left:-73px;font-size:20px;">Password</form:label></b></td>
        <td><form:password class="form-control" path="password" style="text-align:center;" placeholder="Password" id="password" required="required"/></td>
    </tr>
    <tr><td></td><td><font color=#E44D4F><div id="error2">${error}</div></font></td></tr>
	<tr>	
		<td></td>
        <td>
            <input class="form-control" type="submit" value="Login" onclick="return validate()"/>
        </td>
    </tr>
</table>  
</form:form>
<center><a  href="registerCustomer">Register</a></center>
</body>
</html>