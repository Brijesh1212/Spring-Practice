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
String email=request.getParameter("email");
String password=request.getParameter("password");
String dob=request.getParameter("dob");
String gender=request.getParameter("gender");
String number=request.getParameter("number");
String address=request.getParameter("address");

try{
	String sql="INSERT INTO owner VALUES(?,?,?,?,?,?,?,?,?) ";
	Connection conn=dbConnection.getConn();
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, "0");
	pstmt.setString(2, userName);
	pstmt.setString(3, email);
	pstmt.setString(4, password);
	pstmt.setString(5, dob);
	pstmt.setString(6, gender);
	pstmt.setString(7, number);
	pstmt.setString(8, address);
	pstmt.setString(9, "0");
	
	int st=pstmt.executeUpdate();
	if(st>0){
		%>
		<script type="text/javascript">
		alert("App owner added to database");
		window.location="appOwnerLogin.jsp";
		</script>
		<%
	}
	
}catch(Exception e){
	e.printStackTrace();
	}

%>
</body>
</html>