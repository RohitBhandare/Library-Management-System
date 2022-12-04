package com.LoginWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class IssueBookBean {
private String studentname;
private long studentmobile;
private Date issueddate;
private int bookid,studentid;
private String returnstatus;

public IssueBookBean() {}
public IssueBookBean(int bookid, int studentid, String studentname, long studentmobile) {
	super();
	this.bookid = bookid;
	this.studentid = studentid;
	this.studentname = studentname;
	this.studentmobile = studentmobile;
}

public String getReturnstatus() {
	return returnstatus;
}
public void setReturnstatus(String returnstatus) {
	this.returnstatus = returnstatus;
}
public Date getIssueddate() {
	return issueddate;
}
public void setIssueddate(Date issueddate) {
	this.issueddate = issueddate;
}
public int getbookid() {
	return bookid;
}
public void setbookid(int bookid) {
	this.bookid = bookid;
}
public int getStudentid() {
	return studentid;
}
public void setStudentid(int studentid) {
	this.studentid = studentid;
}
public String getStudentname() {
	return studentname;
}
public void setStudentname(String studentname) {
	this.studentname = studentname;
}
public long getStudentmobile() {
	return studentmobile;
}
public void setStudentmobile(long studentmobile) {
	this.studentmobile = studentmobile;
}

}
