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
		 <%
		 String id=request.getParameter("id");
	     String appName=request.getParameter("name");
				 int avg=0;
				 String image=(String)session.getAttribute("image");
				 try{
					 String sql2="SELECT avg(rating) as r FROM ratings WHERE appId='"+id+"'";
			        	Connection conn2=dbConnection.getConn();
			        	PreparedStatement pstmt2=conn2.prepareStatement(sql2);
			        	ResultSet rs2=pstmt2.executeQuery();
			        	if(rs2.next()){
			        		avg=rs2.getInt(1);
			        	}
				 }catch(Exception es){
					 
				 }
		 %>
		 <div  class="banner-bottom">
		 <div style="width: 100%;height: auto;background-color: white;">
		      <div style="width: 100%;height: 60px;background-color: #4286f4">
		           <img  src="data:image/jpeg;base64, <%= image%>" onerror="this.src='app.jpg'" width="60" height="60" >
		           <h3 style="position: relative;top: -40px;left: 70px;"><%=appName %></h3>
		           <h3 style="position: relative;top: -65px;left: 370px;">Avarage Rating : <%=avg %></h3>
		      </div>
		      <br>
		      <%
		        try{
		        	String sql="SELECT * FROM reviews WHERE appId='"+id+"'";
		        	Connection conn=dbConnection.getConn();
		        	PreparedStatement pstmt=conn.prepareStatement(sql);
		        	ResultSet rs=pstmt.executeQuery();
		        	while(rs.next()){
		        		String sql1="SELECT * FROM user WHERE id='"+rs.getString("useId")+"'";
			        	Connection conn1=dbConnection.getConn();
			        	PreparedStatement pstmt1=conn1.prepareStatement(sql1);
			        	ResultSet rs1=pstmt1.executeQuery();
			        	String userName="";
			        	if(rs1.next()){
			        		userName=rs1.getString("userName");
			        	}
		        		%>
		        		<div style="padding: 10px;background-color: #6f8099;margin-left: 10px;margin-right: 10px;">
		        		<h4><%= userName%></h4> 
		                </div>
		                <div style="padding: 10px;background-color: #0b2651;margin-left: 10px;margin-right: 10px;color: white;">
		                <h4><%= rs.getString("review")%></h4><br>
		                <h5><%= rs.getString("date")%></h5>
		                </div>
		                <br>
		        		<%
		        	}
		        }catch(Exception es){
		        	es.printStackTrace();
		        	}
		      %>
		      <br>
		 </div>
		 	
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