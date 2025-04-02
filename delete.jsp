<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id=request.getParameter("t1");
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Bharat2004");
	Statement statement = connection.createStatement();  // query execute
	
	String querydel= "DELETE FROM `user` WHERE (`id` = '"+id+"');";
	
	int i = 0;
	i = statement.executeUpdate(querydel);
	if(i!=0) {
		response.sendRedirect("displaydata.html");
	}
	else{
		response.sendRedirect("delete.html");
	}
	
}catch (Exception e) {
	e.printStackTrace();
	}
%>
</body>
</html>