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
	int id = (int) session.getAttribute("id");
	ArrayList<String> results = (ArrayList<String>) session.getAttribute("results");
	/* ArrayList<String> results = new ArrayList<>();
	for (int i = 0; i < 20; i++) {
		results.add("Item: " + i + i + i);
	} */
	System.out.println("id: " + id);
	String placeholder = "", searchDirective = "";
	session.setAttribute("dpKey", dp);
	session.setAttribute("id", id);
	switch (id) {
	case 1:
		placeholder = "placeholder='Actor name?'";
		searchDirective =  "Search by actor below.";
		break;
	case 2:
		placeholder = "placeholder='Movie title?'";
		searchDirective =  "Search by movie title below.";
		break;
	case 3:
		placeholder = "placeholder='Movie genre?'";
		searchDirective =  "Search by movie genre below.";
		break;
	}
%>
</head>
<body>
	<div class="header">
		<h1>Cinemate</h1>
		<p class="sub-header">Enter a movie to search for.</p>
	</div>
	<div class="main-skinny">
		<div class="main-box">
			<div id="main-box-content">
				<div id="main-box-content">
					<form name="movie-search-form" autocomplete="on" method="GET"
						action="MovieSearch">
						<%=searchDirective%>
						<input name="movieterminput" type="text" size="50"
							<%=placeholder%> />
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
		<div class="footer"></div>
</body>
</html>