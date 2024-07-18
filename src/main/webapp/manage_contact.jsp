<%@page import="java.util.Iterator"%>
<%@page import="com.project.entity.Contact"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<Contact> list=(List<Contact>)request.getAttribute("list"); 
Iterator<Contact> i=list.iterator();
%>
<table border="1" cellpadding="10" cellspacing="2">
<tr>
<th>Name</th>
<th>Number</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<%while(i.hasNext()) {
	Contact contact=i.next();%>
<tr>
<td><%=contact.getContactName() %></td>
<td><%=contact.getCotactNumber() %></td>
<td><a href="update_request?id=<%=contact.getContactId()%>"><button>edit</button></a></td>
<td><a href="delete_contact?id=<%=contact.getContactId()%>"><button>delete</button></a></td>
</tr>


<%} %>
</table>

</body>
</html>