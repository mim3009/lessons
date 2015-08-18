<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page</title>
</head>
<body>
	<%
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String enter = request.getParameter("enter");
		String register = request.getParameter("register");
	%>
	<p><font color="green">Login: <%= login %></font></p>
	<p><font color="red">Password: <%= password %></font></p>
	<p><font color="black">Enter: <%= enter %></font></p>
	<p><font color="black">Register: <%= register %></font></p>
</body>
</html>