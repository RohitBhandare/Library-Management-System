package com.LoginWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Log")
public class Log extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		Database db=new Database();
		if(db.check(uname,pwd))
		{
			HttpSession session=request.getSession();
			session.setAttribute("uname", uname);
			response.sendRedirect("navlibrarian.html");
		}
		else
		{
			response.sendRedirect("index.html");
		}
		
	}

	
}
