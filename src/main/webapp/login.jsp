<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
<input type="text" placeholder="enter email" name="email" >
<input type="password" placeholder="enter password" name="password">
<input type="submit">
</form>
<% String error=(String)request.getAttribute("error");

if(error!=null){%>
<h1 style="color: red"><%=error %></h1>
<%} %>

</body>
</html>