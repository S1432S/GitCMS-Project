<%@page import="com.project.entity.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Contact contact=(Contact)request.getAttribute("record") ;%>

<form action="update" method="post">
<input type="text" value="<%=contact.getContactId()%>" name="id" readonly="readonly" hidden="true">
<input type="text" placeholder="enter contact name" value="<%=contact.getContactName()%>" name="contactName">
<input type="text" placeholder="enter number" value="<%=contact.getCotactNumber()%>" name="contactNumber">
<input type="submit">
</form>

</body>
</html>