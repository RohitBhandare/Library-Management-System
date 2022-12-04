package com.LoginWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int roll=Integer.parseInt(request.getParameter("rno"));
		String name=request.getParameter("name");
		String branch=request.getParameter("branch");
		String year=request.getParameter("year");
		String address=request.getParameter("address");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String phone=request.getParameter("ph");
		String uname=request.getParameter("usr");
		BookDao bd=new BookDao();
		bd.insertStudent(roll,name,branch,year,address,pwd,email,phone,uname);
		request.getRequestDispatcher("index.html").include(request, response);

	}

}
