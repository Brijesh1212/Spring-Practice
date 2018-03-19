<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav id="nav">
						<ul>
							<li class="current"><a href="/Management/adminHome">HOME</a></li>
							<li class="current"><a href="/Management/changePassword" target="middle">CHANGE PASSWORD</a></li>
							<li class="submenu">
								<a href="#">ADD</a>
								<ul>
									<li><a href="/Management/addShip" class="button" target="middle">SHIP</a></li>
									<li><a href="/Management/addRoute" class="button" target="middle">ROUTE</a></li>
									<li><a href="/Management/addSchedule" class="button" target="middle">SCHEDULE</a></li>
									
								</ul>
							</li>
							<li class="submenu">
								<a href="#">VIEW/MODIFY/DELETE</a>
								<ul>
									<li><a href="/Management/viewDetails" class="button" target="middle">SHIP</a></li>
									<li><a href="/Management/viewRouteDetails" class="button" target="middle">ROUTE</a></li>
									<li><a href="/Management/viewShipScheduleDetails" class="button" target="middle">SCHEDULE</a></li>
									
								</ul>
							</li>
							
							
							<li class="submenu">
								<a href="#">ABOUT</a>
								<ul>
									<li><a href="#main" class="button fit scrolly">About Us</a></li>
									<li><a href="#contact" class="button fit scrolly">Contact Us</a></li>
									
								</ul>
							</li>
							<li class="current"><a href="/Management/viewPassenger" target="middle">View Passengers</a></li>
							<li><a href="/SRS/logout" class="button special">LOGOUT</a></li>
						</ul>
					</nav>
					<div><iframe name="middle" style="width: 100%;height: 100%;border: none;"></iframe> </div>
</body>
</html>