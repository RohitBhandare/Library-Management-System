package com.LoginWeb;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LoginWeb.*;

@WebServlet("/ViewIssuedBook")
public class ViewIssuedBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Book</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<style>#bs-example-navbar-collapse-1{background: linear-gradient(to top left,red,blue);}</style>");
		out.println("<style>#bs-example-navbar-collapse-1{color:white);}</style>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		out.println("<style>@import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,500;1,400;1,500&display=swap</style>");
		out.println("<div class='container'>");
		out.print("<style>.container{font-family: 'Poppins', sans-serif;}</style>");
		
		List<IssueBookBean> list=BookDao.viewIssuedBooks();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Book ID</th><th>Student Id</th><th>Student Name</th><th>Student Mobile</th><th>Issued Date</th><th>Return Status</th></tr>");
		for(IssueBookBean bean:list){
			out.println("<tr><td>"+bean.getbookid()+"</td><td>"+bean.getStudentid()+"</td><td>"+bean.getStudentname()+"</td><td><font color='green'>"+bean.getStudentmobile()+"</font></td><td>"+bean.getIssueddate()+"</td><td><font color='red'>"+bean.getReturnstatus()+"</font></td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
}
