package com.LoginWeb;

import javax.servlet.http.HttpServlet;

import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

	public static int save(BookBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into BOOKS values(?,?,?,?,?)");
			ps.setInt(1,bean.getBookID());
			ps.setString(2,bean.getName());
			ps.setString(3,bean.getAuthor());
			ps.setInt(4,bean.getQuantity());
			ps.setInt(5,0);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<BookBean> view(){
		List<BookBean> list=new ArrayList<BookBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from BOOKS");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				BookBean bean=new BookBean();
				bean.setBookID(rs.getInt("BOOkID"));
				bean.setName(rs.getString("NAME"));
				bean.setAuthor(rs.getString("AUTHOR"));
				bean.setQuantity(rs.getInt("QUANTITY"));
				bean.setIssued(rs.getInt("ISSUED"));
				
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	
	public static int delete(String bookid){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from BOOKS where BOOkID=?");
			ps.setString(1,bookid);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int getIssued(int bookid){
		int issued=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from BOOKS where BOOkID=?");
			ps.setInt(1,bookid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				issued=rs.getInt("issued");
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return issued;
	}
	public static boolean checkIssue(int bookid){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from BOOKS where BOOkID=? and quantity>issued");
			ps.setInt(1,bookid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static void insertStudent(int roll,String name,String branch,String year,String address,String pwd,String email,String phone,String uname){
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into studentlogin values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,roll);
			ps.setString(2,name);
			ps.setString(3,branch);
			ps.setString(4,year);
			ps.setString(5,address);
			ps.setString(6,pwd);
			ps.setString(7,email);
			ps.setString(8,phone);
			ps.setString(9,uname);
			ps.executeUpdate();
			System.out.println("Data inserted....");
			
			
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
	}
	
	
	public static int issueBook(IssueBookBean bean){
		int bookid=bean.getbookid();
		boolean checkstatus=checkIssue(bookid);
		System.out.println("Check status: "+checkstatus);
		if(checkstatus){
			int status=0;
			try{
				Connection con=DB.getCon();
				PreparedStatement ps=con.prepareStatement("insert into IssueBook values(?,?,?,?,?,?)");
				ps.setInt(1,bean.getbookid());
				ps.setInt(2,bean.getStudentid());
				ps.setString(3,bean.getStudentname());
				ps.setLong(4,bean.getStudentmobile());
				java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
				ps.setDate(5,currentDate);
				ps.setString(6,"Not Return");
				
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps2=con.prepareStatement("update BOOKS set issued=? where BOOkID=?");
					ps2.setInt(1,getIssued(bookid)+1);
					ps2.setInt(2,bookid);
					status=ps2.executeUpdate();
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
		}else{
			return 0;
		}
	}
	public static void BookFine(int bookid,int studentid)
	{
		try{
			Connection con=DB.getCon();
			
			CallableStatement ps5=con.prepareCall("{call Library(?,?)}");
			ps5.setInt(1,studentid);
			ps5.setInt(2,bookid);
			
			ps5.execute();
			con.close();
			
		}catch(Exception e){System.out.println(e);
		
		}
	}
	public static int returnBook(int bookid,int studentid){
		int status=0;
			try{
				Connection con=DB.getCon();
				PreparedStatement ps=con.prepareStatement("update IssueBook set status='Return' where bookid=? and rno=?");
				
				ps.setInt(1,bookid);
				ps.setInt(2,studentid);
				
				status=ps.executeUpdate();
				CallableStatement ps5=con.prepareCall("{call Library(?,?)}");
				ps5.setInt(1,studentid);
				ps5.setInt(2,bookid);
				
				ps5.execute();
				
				if(status>0){
					PreparedStatement ps2=con.prepareStatement("update BOOKS set issued=? where bookid=?");
					ps2.setInt(1,getIssued(bookid)-1);
					ps2.setInt(2,bookid);
					status=ps2.executeUpdate();
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
	}
	public static List<IssueBookBean> viewIssuedBooks(){
		List<IssueBookBean> list=new ArrayList<IssueBookBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from IssueBook order by issuedate desc");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				IssueBookBean bean=new IssueBookBean();
				bean.setbookid(rs.getInt("bookid"));
				bean.setStudentid(rs.getInt("rno"));
				bean.setStudentname(rs.getString("name"));
				bean.setStudentmobile(rs.getLong("mon"));
				bean.setIssueddate(rs.getDate("issuedate"));
				bean.setReturnstatus(rs.getString("status"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static int update(LibrarianBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update Librarian set name=?,email=?,password=?,mobile=? where id=?");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getEmail());
			ps.setString(3,bean.getPassword());
			ps.setLong(4,bean.getMobile());
			ps.setInt(5,bean.getId());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static LibrarianBean viewById(int id){
		LibrarianBean bean=new LibrarianBean();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Librarian where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobile(rs.getLong(5));
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}
	
	
}
