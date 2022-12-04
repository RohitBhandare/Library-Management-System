package com.LoginWeb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class StudentDao {
public static boolean authenticate(String uname,String password){
	boolean status=false;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from studentlogin where username=? and pwd=?");
		ps.setString(1,uname);
		ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			status=true;
		}
		con.close();
		
	}catch(Exception e){System.out.println(e);}
	return status;
}
}