
# Library Management System

Nowadays, in our society, computer technology is the most important advancement as people move along in this computerized world. These changes have big effects on man’s life; by making it easier and more convenient. Librarians have the responsibility not only to know how to manage a computerized library system but also to be aware that these changes will have a big help to them.
Performing library management manually is quite difficult, as is maintaining its records in order. These are the issues that the College Library Management System should address and answer.
The College Library Management System  is a program that helps librarians manage a library. Based on the needs of users, the system could provide a minimal set of functionalities, such as adding and updating members and books. This system can also handle check-in specifications, borrower's transactions and more.

# Technology used
```bash
  Backend: Java, Servlets, JSP
  Frontend: HTML, CSS, JavaScript
  Database: MySQL
  Server: Apache Tomcat Server
```
# Login Page
```bash
The login page which includes:
•	Login interface for Student and Librarian. 
•	The register column for easy signing up of a user within seconds.
•	The welcome section introducing what the site is about.
•	A section showing browser compatibility.
```

![image](https://user-images.githubusercontent.com/92716110/205496989-d16f1d3b-482f-494b-866b-7e185cfcd610.png)

# Student Login
![image](https://user-images.githubusercontent.com/92716110/205497109-5130d61a-96e4-41e3-8e4b-dbe983bf74a4.png)

# Student Section View
![image](https://user-images.githubusercontent.com/92716110/205497191-ff3ebf35-f9dc-4394-a922-d31d54506f53.png)

# Add Books Section (Librarian)
![image](https://user-images.githubusercontent.com/92716110/205497223-27f39868-d019-41b6-8aa9-11fb9c48e4d3.png)

# Add New Book (Librarian)
![image](https://user-images.githubusercontent.com/92716110/205497268-3a93267d-de6f-4e04-8248-c4772689e326.png)

# Issue Book Section (Librarian)
![image](https://user-images.githubusercontent.com/92716110/205497419-2e2b6233-5bbc-42fc-9f37-b6abf6be8c06.png)
•	Issue the books easily by just providing the Book ID of the book and Student ID, Student Name, Student Mobile No. from the database.

# Issued Book Details (Librarian)
![image](https://user-images.githubusercontent.com/92716110/205497453-909bf410-7404-44e0-b22d-fef0a18dea11.png)

# Return Book Section (Librarian)
![image](https://user-images.githubusercontent.com/92716110/205497475-c8098f92-ee0b-4685-b9f0-8e6dcfa9b148.png)
•	Return the book by typing in the Book ID of the book and Student ID of Student to be returned.

# Fine Section (Librarian)

![image](https://user-images.githubusercontent.com/92716110/205497508-8b87ef10-d6d6-4062-96ce-1164a48afad6.png)
•	Fine Amount for Late Return of Book.
•	If the book is not returned within 15 days then fine will be 10Rs. Per day. For this We used a Stored Procedure in a Code given below:

```bash
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

```


## Contributing

Contributions are always welcome!

See `contributing.md` for ways to get started.

Please adhere to this project's `code of conduct`.

