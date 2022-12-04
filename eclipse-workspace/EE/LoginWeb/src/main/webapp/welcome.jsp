<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control","no-cache,no-store,must-revavlidate");
		if(session.getAttribute("uname")==null)
		{
			response.sendRedirect("index.html");
		}
	
	%>
	<h1>Welcome ${uname }</h1>
	<form action="Logout">
	<input type="submit" value="Logout">
	</form>
</body>
</html>