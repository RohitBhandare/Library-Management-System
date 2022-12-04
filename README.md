# Library-Management-System
Login Page
 
The login page which includes:
•	Login interface for Student and Librarian. 
•	The register column for easy signing up of a user within seconds.
•	The welcome section introducing what the site is about.
•	A section showing browser compatibility.
Student Login
 ![stack Overflow](http://lmsotfy.com/so.png)
Student Registration
 
 

Student Section View
 
•	Student can view Available Books and view already gained Books.
Add Books Section (Librarian)
 
•	Feature to add a new book.

Add New Book (Librarian)
 
New Book Added Successfully.
Issue Book Section (Librarian)
 
•	Issue the books easily by just providing the Book ID of the book and Student ID, Student Name, Student Mobile No. from the database.

Issued Book Details (Librarian)
 
Issue a Book Successfully.
Return Book Section (Librarian)
 
•	Return the book by typing in the Book ID of the book and Student ID of Student to be returned.

Return Book Details (Librarian)
 
Book Returned Successfully.
Fine Section (Librarian)
 
•	Fine Amount for Late Return of Book.
•	If the book is not returned within 15 days then fine will be 10Rs. Per day. For this We used a Stored Procedure in a Code given below:

create procedure Library(in Rno1 int,bookid1 int)
	begin
		declare diff int;
		declare amt int;
		declare date date;
		declare mob1 bigint;
		declare status1 varchar(50);
		declare name1 varchar(50);

select IssueDate,status,Mon,name into date,status1,mob1,name1 from  IssueBook where Rno=Rno1 and bookid=bookid1;
		set diff=datediff(curdate(),date);
		if diff>15 then
insert into Fine  values(bookid1,Rno1,name1,mob1,date,curdate(),diff,status1,
diff*0);
		end if;
	end;//


