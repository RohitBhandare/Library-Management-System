package com.LoginWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Student Section</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		String uname=request.getParameter("uname");
		String password=request.getParameter("pwd");

		if(StudentDao.authenticate(uname, password)){
			HttpSession session=request.getSession();
			session.setAttribute("uname",uname);
			
			request.getRequestDispatcher("navstudent.html").include(request, response);
			request.getRequestDispatcher("studentbgimage.html").include(request, response);
			
		}else{
			
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("<div class='container'>");
			out.println("<h3><center><font color='red'>Please Enter correct Username or password</font></center></h3>");
			out.println("</div>");
		}
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
