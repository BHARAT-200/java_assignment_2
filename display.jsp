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
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Bharat2004");
	Statement statement = connection.createStatement();  // query execute
	ResultSet set = statement.executeQuery("SELECT * FROM user");
	while(set.next()) {
		out.println(set.getInt(1) + "  "+set.getString(2));
	}
	
}catch (Exception e) {
	e.printStackTrace();
	}
%>
</body>
</html>