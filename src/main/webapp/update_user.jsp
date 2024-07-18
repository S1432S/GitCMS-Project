<%@page import="com.project.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%User user=(User)session.getAttribute("user");
String name=user!=null?user.getUserName():"";
String email=user!=null?user.getEmail():"";
String password=user!=null?user.getPassword():"";
String error=(String)request.getAttribute("error");
%>
<form action="manage_profile" method="post">
<input type="text" placeholder="enter your name" value="<%= name%>" name="userName">
<input type="email" placeholder="enter email" value="<%=email%>" name="email">
<input type="password" placeholder="enter password" value="<%=password%>" name="password">
<input type="submit">
</form>
<%if(error!=null){ %>
<h1 style="color: red"><%=error %></h1>
<%} %>

</body>
</html>