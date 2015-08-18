<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    	String login = request.getParameter("login");
    	Cookie cookie = new Cookie("login", login);
    	cookie.setMaxAge(365*24*60*60);
    	response.addCookie(cookie);
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="showcookies.jsp">show cookie</a>
</body>
</html>