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
<%User user=(User)session.getAttribute("user"); %>
<%String userName=user!=null?user.getUserName():"";
String email=user!=null?user.getEmail():"";
String password=user!=null?user.getPassword():"";
String error=(String)request.getAttribute("error");
%>
<h1>Profile</h1>
<p>Name:<%=userName %></p>
<p>email:<%=email %></p>
<p>password:<%=password %></p>
<a href="update_user.jsp"><button>Update</button></a>
<a href="delete_user"><button>Delete</button></a>
<%if(error!=null) {%>
<h1 style="color: red"><%=error %></h1>
<%} %>
</body>
</html>