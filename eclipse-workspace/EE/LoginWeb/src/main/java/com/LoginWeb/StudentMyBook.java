package com.LoginWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentMyBook
 */
@WebServlet("/StudentMyBook")
public class StudentMyBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentMyBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		request.getRequestDispatcher("navstudent.html").include(request, response);
		out.println("<style>@import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,500;1,400;1,500&display=swap</style>");
		out.println("<div class='container'>");
		int rno1=Integer.parseInt(request.getParameter("rno"));
		out.print("<style>.container{font-family: 'Poppins', sans-serif;}</style>");
		try {
		Connection con=DB.getCon();
		Statement stmt=con.createStatement();
		
		ResultSet rs1=stmt.executeQuery("select bookid from issuebook where rno=rno1");
		rs1.next();
		int bookid1=rs1.getInt(1);
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Book Id</th><th>Roll No.</th><th>Name</th><th>Mobile No.</th><th>Issue Date</th><th>Return Date</th><th>Days</th><th>Status</th><th>Fine Amount</th></tr>");
		out.print("<style>th{background-color:aqua;}</style>");
		}catch(Exception e) {};
		out.println("</table>");
		
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
	}
