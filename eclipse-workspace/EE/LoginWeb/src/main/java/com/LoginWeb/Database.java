package com.LoginWeb;
import java.sql.*;
public class Database {

	public boolean check(String uname,String pwd) {
		String sql="select * from Login where uname=? and pwd=?";
		
		try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Servlet","root","root");  
		//here students is database name, root is username and password 
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1, uname);
		stmt.setString(2, pwd);
		ResultSet rs=stmt.executeQuery();
		if(rs.next())
		{
			return true;
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;

	}

}
