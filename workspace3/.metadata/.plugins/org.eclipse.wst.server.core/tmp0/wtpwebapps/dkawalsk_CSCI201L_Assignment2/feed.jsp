<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="DOM.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cinemate: Feed</title>
<link rel="stylesheet" type="text/css" href="standard.css">
<%
	DOMParser dp = (DOMParser) session.getAttribute("dpKey");
	String username = (String) session.getAttribute("username");
	String password = (String) session.getAttribute("password");
	String inputfilename = (String) session.getAttribute("inputfilename");

	User current = dp.getUserByUsername(username);
	String name = current.fname + " " + current.lname;
	String image_src = current.url;
	String following[] = current.following;
	String followers[] = dp.getFollowersForUser(current);
%>
</head>
<body>
	<div class="header">
		<h1>Cinemate</h1>
	</div>
	<div class="main-skinny">
		<div class="profile-box">
			<img class="profile-image" src="<%=image_src%>" height="150px"></img>
			<h2><%=name%></h2>
			<h4>
				@<%=username%></h4>
		</div>
	</div>

	<div class="footer-skinny"></div>
	<div class="feed-header-box">Feed</div>
	<div class="footer">
		<%
			for (int i = 0; i < current.feed.length; i++) {
		%>
		<div class="following-item">
			<p><%=current.feed[i].toString()%></p>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>