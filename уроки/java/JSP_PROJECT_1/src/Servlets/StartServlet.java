package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartServlet extends DispatcherServlet{
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse responce)throws IOException, ServletException{
		if(request.getParameter("enter") != null){
			super.forward("/myServlet", request, responce);
		}else if(request.getParameter("register") != null){
			super.forward("/registration.jsp", request, responce);
		}
	}

}