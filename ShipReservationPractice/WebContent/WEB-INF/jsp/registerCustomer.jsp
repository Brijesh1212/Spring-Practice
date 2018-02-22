<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="POST" action="registerUser" >
   <table align="center">
    
   <form:label path="userID"></form:label>
   <form:hidden path="userID"/>

    <tr>
        <td><form:label path="firstName">First Name</form:label></td>
        <td><form:input path="firstName" id="firstName" placeholder="Firstname" required="required" maxlength="20"/></td>
         <td><form:label path="lastName" >Last Name</form:label></td>
         <td><form:input path="lastName" id="lastName"  placeholder="Lastname" required="required" maxlength="20"/></td>
    </tr>
    <tr><td></td><td><font color=#E44D4F><div id="error1">${error}</div></font></td><td></td><td><font color=#E44D4F><div id="error2">${error}</div></font></td></tr>
	<tr>
        <td><form:label path="dateOfBirth">Date Of Birth</form:label></td>
        <td><form:input path="dateOfBirth" id="dateOfBirth" placeholder="dd-mm-yyyy" required="required"/></td>
         <td><form:label path="gender">Gender</form:label></td>
        <td><form:radiobutton path="gender" value="Male" id="gender1" />Male 
		<form:radiobutton path="gender" value="Female" id="gender2"/>Female</td>
    </tr>
	<tr><td></td><td><font color=#E44D4F><div id="error3">${error}</div></font></td><td></td><td><font color=#E44D4F><div id="error12">${error}</div></font></td></tr>
	<tr>
        <td><form:label path="street">Street</form:label></td>
        <td><form:input path="street" id="street"  placeholder="Street" required="required" maxlength="30"/></td>
         <td><form:label path="location">Location</form:label></td>
        <td><form:input path="location" id="location"  placeholder="Location" required="required" maxlength="20"/></td>
    </tr>
	<tr><td></td><td><font color=#E44D4F><div id="error4">${error}</div></font></td><td></td><td><font color=#E44D4F><div id="error5">${error}</div></font></td></tr>
	 <tr>
        <td><form:label path="city">City</form:label></td>
        <td><form:input path="city" id="city"  placeholder="City" required="required" maxlength="20"/></td>
         <td><form:label path="state">State</form:label></td>
        <td><form:input path="state" id="state"  placeholder="State" required="required" maxlength="20"/></td>
    </tr>
	 <tr><td></td><td><font color=#E44D4F><div id="error6">${error}</div></font></td><td></td><td><font color=#E44D4F><div id="error7">${error}</div></font></td></tr>
	<tr>
        <td><form:label path="pincode">Pincode</form:label></td>
        <td><form:input path="pincode" id="pincode"  maxlength="6" minlength="6"  placeholder="Pincode" required="required"/></td>
        <td><form:label path="mobileNo">Phone</form:label></td>
        <td><form:input path="mobileNo" id="mobileNo"  placeholder="Mobile Number" required="required" maxlength="10"/></td>
    </tr> 
	<tr><td></td><td><font color=#E44D4F><div id="error8">${error}</div></font></td><td></td><td><font color=#E44D4F><div id="error9">${error}</div></font></td></tr>
	
    <tr>
        <td><form:label path="emailID">Email ID</form:label></td>
        <td><form:input path="emailID" id="emailID"  placeholder="abc@abc.com" required="required" maxlength="30"/></td>
         <td><form:label path="password">Password</form:label></td>
        <td><form:password path="password" id="password"  placeholder="Password" maxlength="20" minlength="6" required="required"/></td>
    </tr>
	<tr><td></td><td><font color=#E44D4F><div id="error10">${error}</div></font></td><td></td><td><font color=#E44D4F><div id="error11">${error}</div></font></td></tr>
	
	<tr>	
        <td colspan="4" align="center">
            <center><input type="submit" value="REGISTER" onclick="return validate()"/></center>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>