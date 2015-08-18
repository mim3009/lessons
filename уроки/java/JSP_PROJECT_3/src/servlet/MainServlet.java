package servlet;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.WebApplicationContextUtils;

import connection.I1Impl;
import connection.IService;

public class MainServlet extends HttpServlet{

	private IService is;
	
	@Override
	public void init() throws ServletException{
		is = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext()).getBean(IService.class);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException{
		String item = is.getItem();
		req.getSession().setAttribute("item", item);
		resp.sendRedirect("show.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException{
		doGet(req, resp);
	}
	
}
