package Main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse responce)throws IOException, ServletException{
		HttpSession session = request.getSession();
		String str = request.getParameter("textinput");
		session.setAttribute("inputtext", str);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/showsession.jsp");
		dispatcher.forward(request, responce);
	}
	
}
