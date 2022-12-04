package com.LoginWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewBookFine
 */
@WebServlet("/ViewBookFine")
public class ViewBookFine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBookFine() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		out.println("<p>Note: If the book is not returned within 15 days then fine will be 10 Rs. per day.</p>");
		try {
		Connection con=DB.getCon();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from fine");
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Book Id</th><th>Roll No.</th><th>Name</th><th>Mobile No.</th><th>Issue Date</th><th>Return Date</th><th>Days</th><th>Status</th><th>Fine Amount</th></tr>");
		out.print("<style>th{background-color:aqua;}</style>");
		while(rs.next()){
			//out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getInt(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+rs.getString(5)+"</td></tr>");
			out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getInt(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getLong(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getInt(7)+"</td><td><font color='green'>"+rs.getString(8)+"</font></td><td><font color='red'>"+rs.getLong(9)+"</font></td></tr>");
		}
		}catch(Exception e) {};
		out.println("</table>");
		
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
	

}
