<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
<%@page import="database.*"%>
    <%@page import="java.io.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.io.File"%>
<%@ page import="org.apache.commons.io.FilenameUtils"%>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@ page import="java.sql.*"%>
<%@page import=" java.util.HashMap"%>
<%@page import="javax.swing.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%


String userName=(String)session.getAttribute("ownerUserName");
String ownerId=(String)session.getAttribute("ownerId");
String appName="";
String description="";
String platform="";
String id="";
List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
HashMap<String,String> hm= new HashMap<String,String>();
InputStream filecontent =null;
//hm.put("patientid",items.FormField("patientid"));

for (FileItem item : items) {
	//hm.put(item.getFieldName().equals(patientid),item.);
    if (item.isFormField()) {
    	hm.put(item.getFieldName(),item.getString());
    	// Process form file field (input type="text"). patient id
        String fieldname = item.getFieldName();
        //pid = item.getString();
        id =hm.get("id"); 							 //// MADE CHANGES HERE
    }
    else { // file fileds here
        // Process form file field (input type="file").
        String fieldname = item.getFieldName();
         filecontent = item.getInputStream();
        
       /*  byte dataBytes[] = new byte[(int)item.getSize()];
        filecontent.read(dataBytes);
      */
      
         PreparedStatement psmnt = null;
	      FileInputStream fis;
	      int a = 0;
	     
	     System.out.println("Id: "+id);
	    	  try{
    		      Class.forName("com.mysql.jdbc.Driver");
    		   Connection    conn = dbConnection.getConn();     
	      psmnt = conn.prepareStatement("UPDATE apps SET image=? WHERE id='"+id+"'");
	      psmnt.setBinaryStream(1, filecontent,(int)item.getSize());
	      
	      int s = psmnt.executeUpdate();
	      
	      if(s>0){
	    	  %>
	  		<script type="text/javascript">
	  		alert("App Image added");
	  		window.location="viewApps.jsp";
	  		</script>
	  		<%
	      }

	      
	      }
	  
	      catch(Exception e){
	    	  e.printStackTrace();
	    	 
	    
	}
      
      
      
      }
 
// ... (do your job here)



}
	
%>
</body>
</html>