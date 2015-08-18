<%@page import="com.sun.org.apache.bcel.internal.generic.CPInstruction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    	String nameCookie = "login";
    	Cookie[] cookies = request.getCookies();
    	Cookie cookie = null;
    	if(cookies != null){
	    	for(int i = 0; i < cookies.length; i++){
	    		String cookieName = cookies[i].getName();
	    		if(cookieName.equals(nameCookie)){
	    			cookie = cookies[i];
	    			break;
	    		}
	    	}
    	}
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if(cookie != null){
	%>
		value: <%= cookie.getValue() %>
	<%
		}else{
	%>
		Cookies not found!
	<%
		}
	%>
</body>
</html>