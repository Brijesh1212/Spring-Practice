<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
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
	<link rel="stylesheet" type="text/css" href="css/table.css">
	<style type="text/css">
	@import url(https://fonts.googleapis.com/css?family=Open+Sans:400,600);
html {
  background: rgb(246, 248, 248);
}
body {
  padding: 40px;
  font-family: 'Open Sans', sans-serif;
  font-size: 14px;
  font-weight: 400;  
}
.promos {
  width: 800px;
  margin: 0 auto;
  margin-top: 50px;
}
.promo {
  width: 250px;
  background: #0F1012; 
  color: #f9f9f9;
  float: left;
}
.deal {
  padding: 10px 0 0 0;
}
.deal span {
  display: block;
  text-align: center;
}
.deal span:first-of-type {
  font-size: 23px;  
}
.deal span:last-of-type {
  font-size: 13px;
}
.promo .price {
  display: block;
  width: 250px;  
  background: #292b2e;
  margin: 15px 0 10px 0;
  text-align: center;
  font-size: 23px;
  padding: 17px 0 17px 0;
}
ul {
  display: block;
  margin: 20px 0 10px 0;
  padding: 0;
  list-style-type: none;
  text-align: center;
  color: #999999;
}
li {
  display: block;
  margin: 10px 0 0 0;
}
button {
  border: none;
  border-radius: 40px;
  background: #292b2e;
  color: #f9f9f9;
  padding: 10px 37px;
  margin: 10px 0 20px 60px;
}
.scale {
  transform: scale(1.2);
  box-shadow: 0 0 4px 1px rgba(20, 20, 20, 0.8);
}
.scale button {
  background: #64AAA4;
}
.scale .price {
  color: #64AAA4;
}
	</style>
	
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
						 <li><a class="hvr-shutter-out-horizontal" href="userHome.jsp">Home</a></li>
						 <li><a class="active hvr-shutter-out-horizontal" href="viewAvailableApps.jsp">View Available App</a></li>
						 <li><a class="hvr-shutter-out-horizontal" href="viewMyApps.jsp">My Apps</a></li>
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
		 <div class="promos">
		 
                    <%
                    String getByteCode=null;
				    byte[] img=null;
                    try{
                    	String sql="SELECT * FROM apps WHERE ownerId='"+session.getAttribute("ownerId")+"'";
                    	Connection conn=dbConnection.getConn();
                    	PreparedStatement pstmt=conn.prepareStatement(sql);
                    	ResultSet rs=pstmt.executeQuery();
                    	while(rs.next()){
                    		img = rs.getBytes("image");
                    	  	 getByteCode = new Base64().encodeToString(img);
                    		System.out.println("In loop");
                    		%>
<div class="promo">
  <div class="deal">
    <span><%=rs.getString("appName") %></span>
    <span><%=rs.getString("description") %></span>
  </div>
  <span class="price"><img  src="data:image/jpeg;base64, <%=getByteCode %>" onerror="this.src='app.jpg'" width="160" height="160" ></span>
  <ul class="features">
    <li><%=rs.getString("platform") %></li>
    <li><%=rs.getString("ownerName") %></li>
    <li><a href="download.jsp?id=<%=rs.getString("id")%>" style="color: blue;">Download</a> </li>  
  </ul>
  <br>
</div>
                    		<%
                    	}
                    }catch(Exception e){
                    	e.printStackTrace();
                    }
                    
                    %>
                   
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