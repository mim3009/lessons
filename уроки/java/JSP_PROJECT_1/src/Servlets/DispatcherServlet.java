package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{

	public void forward(String to, HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(to);
		dispatcher.forward(request, responce);
	}
	
}
