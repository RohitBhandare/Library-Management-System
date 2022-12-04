package com.LoginWeb;

public class BookBean {
private String name,author,publisher;
private int bookid,quantity,issued;
public BookBean() {
	super();
	// TODO Auto-generated constructor stub
}
public BookBean(String  name, String author, int quantity,int bookid) {
	super();
	this.bookid = bookid;
	this.name = name;
	this.author = author;
	//this.publisher = publisher;
	this.quantity = quantity;
}
public int getBookID() {
	return bookid;
}
public void setBookID(int bookid) {
	this.bookid = bookid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
//public String getPublisher() {
//	return publisher;
//}
//public void setPublisher(String publisher) {
//	this.publisher = publisher;
//}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getIssued() {
	return issued;
}
public void setIssued(int issued) {
	this.issued = issued;
}

}

