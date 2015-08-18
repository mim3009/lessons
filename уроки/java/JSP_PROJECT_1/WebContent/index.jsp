<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main page</title>
</head>
<body>
	<form action="startServlet" method="post">
		Login: <input type="text" name="login">
		Password: <input type="text" name="password">
		<input type="submit" name="enter" value="LogIn" >
		<input type="submit" name="register" value="Register" >
	</form>
</body>
</html>