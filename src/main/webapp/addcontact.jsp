<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String error=(String)request.getAttribute("error");%>
<h1>Add Contact</h1>
<form action="addcontact" method="post">
<input name="contactName" placeholder="enter contact name" type="text">
<input name="contactNumber" placeholder="enter contact number" type="text">
<input type="submit">
</form>
<%if(error!=null){%>

<h1 style="color: red"><%=error %></h1>
<%} %>
</body>
</html>