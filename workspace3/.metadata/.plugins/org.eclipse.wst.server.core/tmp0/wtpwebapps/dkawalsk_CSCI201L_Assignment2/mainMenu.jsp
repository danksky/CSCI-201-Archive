<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="DOM.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cinemate: Menu</title>
<link rel="stylesheet" type="text/css" href="standard.css">
<%
	String username = (String) session.getAttribute("username");
	String password = (String) session.getAttribute("password");
	String inputfilename = (String) session.getAttribute("inputfilename");
	DOMParser dp = (DOMParser) session.getAttribute("dpKey");

	session.setAttribute("username", username);
	session.setAttribute("password", password);
	session.setAttribute("inputfilename", inputfilename);
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
				<ol type="1">
					<li><a href="searchUsers.jsp">Search Users</a></li>
					<li><a href="searchMoviesMenu.jsp">Search Movies</a></li>
					<li><a href="feed.jsp">View Feed</a></li>
					<li><a href="profile.jsp">View Profile</a></li>
					<li><a href="login.jsp">Logout</a></li>
					<li><a href="entry_dkawalsk.jsp">Exit</a></li>
				</ol>
			</div>
		</div>
	</div>
	<div class="footer"></div>
</body>
</html>