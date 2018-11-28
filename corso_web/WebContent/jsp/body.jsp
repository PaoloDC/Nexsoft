<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Body</title>
</head>
<body>
	<h5>sono nel body</h5>
	<%
		List<String> carrello = (List<String>) request.getSession().getAttribute("carrello");

		if (null != carrello && carrello.size() > 0) {
			for (String s : carrello) {
	%>
	<h3>
		Articolo:
		<%=s%></h3>
	<%
		}
		} else
			out.println("Carrello vuoto");
	%>
</body>
</html>