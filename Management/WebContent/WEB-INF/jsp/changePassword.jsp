<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="changePasswordDetails" method="post"  >
<table>
	<tr><td><font color="#E44D4F">${message}</font><font color="#24AB85">${changed}</font></td></tr>
	<tr>
		
		<td><input type="password" placeholder="Old Password" id="opass" name="opass" required/></td>
	</tr>
	<tr><td><font color=#E44D4F><div id="error1">${error}</div></font></td></tr>
	<tr>
		<td><input  type="password" placeholder="New Password" id="npass" name="npass" maxlength="20" minlength="6" required/></td>
	</tr>
	<tr><td><font color=#E44D4F><div id="error2">${error}</div></font></td></tr>
	<tr>
		
		<td><input   type="password" placeholder="Confirm Password" id="cpass" name="cpass" maxlength="20" minlength="6" required/></td>
	</tr>
	<tr><td><font color=#E44D4F><div id="error3">${error}</div></font></td></tr>
	<tr>
		
		<td><pre>   <input  type="submit" value="Change Password" style="width:2em;" onclick="return validate()"/></pre></td>
	</tr>
</table>
</form>
</body>
</html>