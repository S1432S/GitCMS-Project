<%@page import="com.project.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="contact">
<h1>Welcome Back</h1>
<%User user= (User)session.getAttribute("user");
String addcontact=user!=null?"addcontact.jsp":"login.jsp";
String managecontact=user!=null?"manage_contact":"login.jsp";
String manageprofile=user!=null?"manageprofile.jsp":"login.jsp";

 %>
<a href="<%=addcontact%>"><button>add contact</button></a>
<a href="<%=managecontact%>"><button>manage contact</button></a>
<a href="<%=manageprofile%>"><button>manage profile</button></a>

</div>



</body>
</html>