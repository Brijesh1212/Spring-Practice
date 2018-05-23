<%@page import="database.dbConnection"%>
<%@page import="java.sql.*"%>
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


String id=request.getParameter("id");

	     
	     System.out.println("Id: "+id);
	    	  try{
    		      Class.forName("com.mysql.jdbc.Driver");
    		   Connection    conn = dbConnection.getConn();     
	     PreparedStatement psmnt = conn.prepareStatement("UPDATE apps SET ststus=1 WHERE id='"+id+"'");
	      
	      int s = psmnt.executeUpdate();
	      
	      if(s>0){
	    	  %>
	  		<script type="text/javascript">
	  		alert("App is now visible to Public");
	  		window.location="viewAppRequest.jsp";
	  		</script>
	  		<%

	      
	      }
	  
	    	  }catch(Exception e){
	    	  e.printStackTrace();
	    	 
	    
	}
	
%>
</body>
</html>