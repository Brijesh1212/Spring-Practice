<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login / Register</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Credit Login / Register Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css" />"/>
<link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet" type="text/css" media="all">
<link href="<c:url value="/resources/css/popuo-box.css" />" rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" media="all" />
<!-- //Custom Theme files -->
<!-- web font -->
<link href="//fonts.googleapis.com/css?family=Oswald:400,700" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
</head>
<body>
<h1>Login Please</h1>
<div class="main-agileits">
<!--form-stars-here-->
		<div class="form-w3-agile">
			<h2>Login form</h2>
			<form action="loginUser" method="post">
				<div class="form-sub-w3">
					<input type="text" name="email" placeholder="Email " required="" />
				<div class="icon-w3">
					<i class="fa fa-user" aria-hidden="true"></i>
				</div>
				</div>
				<div class="form-sub-w3">
					<input type="password" name="password" placeholder="Password" required="" />
				<div class="icon-w3">
					<i class="fa fa-unlock-alt" aria-hidden="true"></i>
				</div>
				</div>
				<p class="p-bottom-w3ls">Wanna track all your task?<a class="w3_play_icon1" href="#small-dialog1">  Register here</a></p>
				
				<div class="submit-w3l">
					<input type="submit" value="Login">
				</div>
			</form>
			<div style="color: white;"> ${message}</div>
		</div>
<!--//form-ends-here-->
</div>
<div id="small-dialog1" class="mfp-hide">
					<div class="contact-form1">
										<div class="contact-w3-agileits">
										<h3>Register Form</h3>
											<form:form action="registerUser" method="post">
											    <form:hidden path="userId"/>
												<div class="form-sub-w3ls">
													<form:input path="userName" placeholder="UserName" required=""/>
													<div class="icon-agile">
														<i class="fa fa-user" aria-hidden="true"></i>
													</div>
												</div>
												<div class="form-sub-w3ls">
													<form:input placeholder="Email" class="mail" path="email" required=""/>
													<div class="icon-agile">
														<i class="fa fa-envelope-o" aria-hidden="true"></i>
													</div>
												</div>
												<div class="form-sub-w3ls">
													<form:input placeholder="Password"  path="password" required=""/>
													<div class="icon-agile">
														<i class="fa fa-unlock-alt" aria-hidden="true"></i>
													</div>
												</div>
												<div class="form-sub-w3ls">
													<form:input placeholder="Address"  path="address" required=""/>
													<div class="icon-agile">
														<i class="fa fa-unlock-alt" aria-hidden="true"></i>
													</div>
												</div>
											</div>
										<div class="submit-w3l">
											<input type="submit" value="Register"/>
										</div>
										</form:form>
					</div>	
				</div>
<!-- copyright -->
	<!-- //copyright --> 
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
	<!-- pop-up-box -->  
		<script src="<c:url value="/resources/js/jquery.magnific-popup.js" />" type="text/javascript"></script>
	<!--//pop-up-box -->
	<script>
		$(document).ready(function() {
		$('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
			type: 'inline',
			fixedContentPos: false,
			fixedBgPos: true,
			overflowY: 'auto',
			closeBtnInside: true,
			preloader: false,
			midClick: true,
			removalDelay: 300,
			mainClass: 'my-mfp-zoom-in'
		});
																		
		});
	</script>
</body>
</html>