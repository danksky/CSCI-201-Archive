<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="DOM.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cinemate: Results</title>
<link rel="stylesheet" type="text/css" href="standard.css">
<%
	DOMParser dp = (DOMParser) session.getAttribute("dpKey");
	session.setAttribute("dpKey", dp);
	ArrayList<String> results = (ArrayList<String>) session.getAttribute("results");
%>
</head>
<body>
	<div class="header">
		<h1>Cinemate</h1>
		<p class="sub-header">Enter a user to search for.</p>
	</div>
	<div class="main-skinny">
		<div class="main-box">
			<div id="main-box-content">
				<div id="main-box-content">
					Search for the desired user
					<form name="user-search-form" autocomplete="on" method="GET"
						action="UserSearch">
						<input name="usersearchterm" type="text" size="50" placeholder="username, first, or last name" />
						<button>Submit</button>
					</form>
					<div class="results-container">
						<div class="results-container-header"><span>Search Results</span></div>
						<div class="results-container-scrollable">
							<%for (int i = 0; i < results.size(); i++) {%>
								<div class="results-item"><span><%=results.get(i)%></span></div>
							<%}%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer"></div>
</body>
</html>