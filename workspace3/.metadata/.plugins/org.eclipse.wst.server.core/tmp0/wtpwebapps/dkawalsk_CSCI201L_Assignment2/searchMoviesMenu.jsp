<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ page import="DOM.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cinemate: Movie Menu</title>
<link rel="stylesheet" type="text/css" href="standard.css">
<%
	DOMParser dp = (DOMParser) session.getAttribute("dpKey");
	session.setAttribute("dpKey", dp);
%>
</head>
<body>
	<div class="header">
		<h1>Cinemate</h1>
		<p class="sub-header">Logged in! What would you like to do?</p>
	</div>
	<div class="main">
		<div class="main-box">
			<div id="main-box-content">
				<ul>
					<li><a href="searchMovie.jsp?id=1">Search by Actor</a></li>
					<li><a href="searchMovie.jsp?id=2">Search by Title</a></li>
					<li><a href="searchMovie.jsp?id=3">Search by Genre</a></li>
					<li><a href="mainMenu.jsp">Back to Login Menu</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="footer"></div>
</body>
</html>