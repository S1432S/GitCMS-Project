<%@page import="com.project.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="StyleSheets/navbar.css"> -->
</head>
<body>
<%User user1=(User) session.getAttribute("user"); %>
<nav class="navbar">
<div class="logo">Contact Management System</div>
<% if(user1==null){%>
<div class="register"><a href="register.jsp"><button>Register</button></a></div>
<div class="login"><a href="login.jsp"><button>Login</button></a></div>
<%}else{%>
<div class="login"><a href="#"><button>Logout</button></a></div>
<%} %>
</nav>

</body>
</html>