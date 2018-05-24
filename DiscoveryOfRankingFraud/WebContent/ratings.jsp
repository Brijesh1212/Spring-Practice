<%@page import="java.net.SocketException"%>
<%@page import="java.net.UnknownHostException"%>
<%@page import="java.net.NetworkInterface"%>
<%@page import="java.net.InetAddress"%>
<%@page import="database.dbConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.io.OutputStream"%>
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
String id = request.getParameter("id");
String rating = request.getParameter("rating");

String ipAddress="";
String macAddress="";
InetAddress ip;
try {
		
	ip = InetAddress.getLocalHost();
	System.out.println("Current IP address : " + ip.getHostAddress());
	ipAddress=ip.getHostAddress();
	NetworkInterface network = NetworkInterface.getByInetAddress(ip);
		
	byte[] mac = network.getHardwareAddress();
		
	System.out.print("Current MAC address : ");
		
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < mac.length; i++) {
		sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
	}
	macAddress=sb.toString();
	System.out.println(sb.toString());
		
} catch (UnknownHostException e) {
	
	e.printStackTrace();
	
} catch (SocketException e){
		
	e.printStackTrace();
		
}

try
{
 Connection con = dbConnection.getConn();
	 PreparedStatement pstmt1 = con.prepareStatement("INSERT INTO ratings VALUES(?,?,?,?,?,?)");
	 pstmt1.setString(1, "0");
	 pstmt1.setString(2, id);
	 pstmt1.setString(3, rating);
	 pstmt1.setString(4, (String)session.getAttribute("userId"));
	 pstmt1.setString(5, ipAddress);
	 pstmt1.setString(6, macAddress);
	 int st = pstmt1.executeUpdate();
	 if(st>0){
		 %>
			<script type="text/javascript">
			alert("Thaks for rating app");
			window.location="viewMyApps.jsp";
			</script>
			<%
	 }
	 
}
catch(Exception es)
{
	es.printStackTrace();
}

%>
</body>
</html>