<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="database.dbConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String userName=request.getParameter("username");
String password=request.getParameter("password");

/* try{
	String sql="SELECT * FROM owner WHERE userName='"+userName+"' AND password='"+password+"'";
	Connection conn=dbConnection.getConn();
	PreparedStatement pstmt=conn.prepareStatement(sql);
	
	ResultSet rs=pstmt.executeQuery(); */
	if(userName.equals("admin")&&password.equals("123")){
		session.setAttribute("ownerId",1);
		session.setAttribute("ownerEmail","admin");
		session.setAttribute("ownerUserName","admin");
		response.sendRedirect("adminHome.jsp");
	}else{
		%>
		<script type="text/javascript">
		alert("Username or password is wrong");
		window.location="adminLogin.jsp";
		</script>
		<%
	}
/* }catch(Exception e){
	e.printStackTrace();
	} */

%>
</body>
</html>