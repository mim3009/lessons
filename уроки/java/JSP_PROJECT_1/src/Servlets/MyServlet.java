package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse responce)throws IOException, ServletException{
		responce.setContentType("text/html");
		responce.setStatus(HttpServletResponse.SC_OK);
		PrintWriter out = responce.getWriter();
		out.write("<h1>Success!</h1>");
		out.flush();
		out.close();
	}
	
}
