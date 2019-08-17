<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--This hur is important. -->
<%
	String[] workerNames = (String[]) request.getAttribute("workerNames");
	String[] ratings = (String[]) request.getAttribute("ratings");

	String name = (String) request.getAttribute("name");
	String color = (String) session.getAttribute("color"); // THIS IS AN IMPORTANT ONE. SESSION VS REQUEST

	String notes = (String) request.getAttribute("notes");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.colorable {
	background-color: <%=color%>;
}

td, th {
	border: 1px solid #ddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: <%=color%>;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th>Worker</th>
			<th>Rating</th>
		</tr>

		<% for(int i = 0; i < ratings.length; i++) { %>
		<tr>
			<td><%=workerNames[i]%></td>
			<td><%=ratings[i]%></td>
		</tr>
		<% } %>

	</table>
	<p>
		<strong>Name: </strong><%=name%>
		<strong>Color: </strong><%=color%>
		<strong>Notes: </strong><%=notes%>
	</p>
</body>
</html>