<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="StyleSheets/register.css">

</head>
<body>
<h1>Register</h1>
<form action="register" class="form" method="post">
<input type="text" placeholder="enter you name" name="userName">
<input type="email" placeholder="enter your email" name="email">
<input type="password" placeholder="enter the password" name="password">
<input type="submit">
</form>
<% String fail=(String)request.getAttribute("fail");
if(fail!=null){
%>
<h2 style="color: red;"><%=fail %></h2>

<%} %>
 

</body>
</html>