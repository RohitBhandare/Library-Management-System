package com.LoginWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudViewBooks
 */
@WebServlet("/StudViewBooks")
public class StudViewBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudViewBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		request.getRequestDispatcher("navstudent.html").include(request, response);
		out.println("<style>@import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,500;1,400;1,500&display=swap</style>");
		out.println("<div class='container'>");
		out.print("<style>.container{font-family: 'Poppins', sans-serif;}</style>");
		
		List<BookBean> list=BookDao.view();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Book Id</th><th>Name</th><th>Author</th><th>Quantity</th><th>Issued</th></tr>");
		out.print("<style>th{background-color:aqua;}</style>");
		for(BookBean bean:list){
			out.println("<tr><td>"+bean.getBookID()+"</td><td>"+bean.getName()+"</td><td>"+bean.getAuthor()+"<font color:green></td><td>"+bean.getQuantity()+"</td><td></font>"+bean.getIssued()+"</tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
	}

