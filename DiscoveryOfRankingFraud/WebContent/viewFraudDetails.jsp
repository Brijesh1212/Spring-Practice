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
<title>Discovery of ranking fraud for mobile apps</title>
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="Millor Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
<script src="js/jquery.min.js"> </script>
<!--start-smoth-scrolling-->
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
		</script>
<!--start-smoth-scrolling-->
<style type="text/css">
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body>
<!--header-->
<div class="banner">
	 <div class="container">
		 <div class="banner-top">		  
				<!-- <div class="logo">
					<a href="index.html">Discovery</a>
				</div> -->			  
				 <div class="top-menu">
				 	<span class="menu"> </span> 
					<ul>
						 <li><a class="hvr-shutter-out-horizontal" href="adminHome.jsp">Home</a></li>
						 <li><a class="hvr-shutter-out-horizontal" href="viewAppRequest.jsp">App Request</a></li>
						 <li><a class="active hvr-shutter-out-horizontal" href="viewFraudDetails.jsp">Fraud Details</a></li>
						 <li><a class="hvr-shutter-out-horizontal" href="viewAllApps.jsp">View All Apps</a></li>
						 <li><a class="hvr-shutter-out-horizontal" href="index.html">Logout</a></li>
					 </ul>				 
				 </div>	
				 		 <div class="clearfix"> </div>	 
				 		 		 <!-- script-for-menu -->
		 <script>
				$("span.menu").click(function(){
					$(".top-menu ul").slideToggle("slow" , function(){
					});
				});
		 </script>
		 <!-- script-for-menu -->	 
		 </div>	
		 <div  class="banner-bottom">
		 
		 <table id="customers">
  <tr>
    <th>Owner Name</th>
    <th>Email Id</th>
    <th>DOB</th>
    <th>Gender</th>
    <th>Contact Number</th>
    <th>Address</th>
    <th>IP Address</th>
    <th>MAC Address</th>
    <th>Action</th>
  </tr>
  <%
  
  try{
	  String sql="SELECT * FROM owner";
	  Connection conn=dbConnection.getConn();
	  PreparedStatement pstmt=conn.prepareStatement(sql);
	  ResultSet rs=pstmt.executeQuery();
	  while(rs.next()){
		  String sql1="SELECT * FROM user WHERE email='"+rs.getString("email")+"'";
		  PreparedStatement pstmt1=conn.prepareStatement(sql1);
		  ResultSet rs1=pstmt1.executeQuery();
		  while(rs1.next()){
			  String sql2="SELECT COUNT(userId) as c FROM ratings WHERE userId='"+rs1.getString("id")+"'";
			  PreparedStatement pstmt2=conn.prepareStatement(sql2);
			  ResultSet rs2=pstmt2.executeQuery();
			  while(rs2.next()){
				  if(rs2.getInt(1)>2){
					  String sql3="SELECT * FROM ratings WHERE userId='"+rs1.getString("id")+"'";
					  PreparedStatement pstmt3=conn.prepareStatement(sql3);
					  ResultSet rs3=pstmt3.executeQuery();
					  if(rs3.next()){
						 /*  String sql4="SELECT * FROM user WHERE id='"+rs3.getString("userId")+"'";
						  PreparedStatement pstmt4=conn.prepareStatement(sql4);
						  ResultSet rs4=pstmt4.executeQuery(); */
							  /* String sql5="SELECT * FROM ratings WHERE userId='"+rs1.getString("id")+"'";
							  PreparedStatement pstmt5=conn.prepareStatement(sql5);
							  ResultSet rs5=pstmt5.executeQuery(); */
							  if((rs3.getString("ipAddress").equals(rs.getString("ipAddress")))&&(rs3.getString("macAddess").equals(rs.getString("macAddress")))){
								  %>
								  <tr>
								    <td><%=rs.getString("userName") %></td>
								    <td><%=rs.getString("email") %></td>
								    <td><%=rs.getString("dob") %></td>
								    <td><%=rs.getString("gender") %></td>
								    <td><%=rs.getString("number") %></td>
								    <td><%=rs.getString("address") %></td>
								    <td><%=rs.getString("ipAddress") %></td>
								    <td><%=rs.getString("macAddress") %></td>
								    <td><a href="deactivateAccount.jsp?id=<%=rs.getString("id") %>" style="color: blue;text-decoration: none;">Deactivate Account</a> </td>
								  </tr><%
							  }
						  }
					  }
					  
				  }
			  }
		  }
  }catch(Exception es){
	  es.printStackTrace();
  }
  %>
  </table>
		 
		 
		 </div>
	</div>
</div>
<!--/header-->
<!--services-->

<!--Footer-->
<div style="height: 100px;background-color: gray">
</div>
<!--/Footer-->
<!--copyrights-->
<div class="copyrights">
	<div class="container"> 
		<p>Copyrights &copy; 2018 All rights reserved | Design by <a href="#">ME</a></p>
		<div class="social-icons">
			<a href="#"><span class="beh"> </span></a>
			<a href="#"><span class="face"> </span></a>
			<a href="#"><span class="pin"> </span></a>
			<a href="#"><span class="br"> </span></a>	
			<a href="#"><span class="in"> </span></a>				 
		 </div>
<div class="clearfix"> </div>
	</div>
</div>

<!--/copyrights-->

<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>
		 
</body>
</html>