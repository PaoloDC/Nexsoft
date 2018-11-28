<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		Object s = null;
		s.equals("");
	%>

	<%@include file="header.jsp"%>

	<jsp:useBean id="articoloSelezionato"
		class="it.corso.web.bean.Articolo" scope="request"></jsp:useBean>
	<jsp:setProperty name="articoloSelezionato" property="prezzo"
		value="600" />
	<%
		articoloSelezionato.setNome("CIAOOOO");
	%>

	<h3>
		Articolo:
		<%=articoloSelezionato.toString()%></h3>


	
	<%@include file="footer.jsp"%>
</body>
</html>