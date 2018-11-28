<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sono nel footer</title>
</head>
<body>
	<h3>Sono nel footer</h3>

	<hr>
	<fmt:formatNumber var="numero" value="1234.5678" type="CURRENCY"
		maxFractionDigits="2" minFractionDigits="2" pattern="###.##" />

	<b> valore formattato: ${numero } </b>

	<%
		Calendar c = Calendar.getInstance();

		c.set(1992, 1, 28);
		request.setAttribute("data", c.getTime());
	%>

	<fmt:formatDate value="${requestScope.data}" pattern="d/M/y" var="data" />
	<h3>Data formattata: ${data}</h3>


</body>
</html>