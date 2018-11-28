<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sono nell'header</title>
</head>
<body>
	<header>
		<p>Sono nell'header</p>
		<c:out value="prova di configurazione"></c:out>
		<c:out value="<%=request.getParameter(\"test\")%>"
			default="Mi aspetto null"></c:out>


		<c:out value="${param.test2}"></c:out>
		<c:set var="test2" value="1234" scope="request"></c:set>
		<c:out value="${test2}" default="PROVA"></c:out>

		<c:if test="${param.test == null}">
			<h1>La variabile test è null</h1>
		</c:if>

		<!-- switch case -->
		<c:choose>
			<c:when test="${param.test == null}">
				<h5>La variabile test è null</h5>
			</c:when>
			<c:when test="${param.test == 1234}">
				<h5>La variabile test è 1234</h5>
			</c:when>
			<c:otherwise>
				Nessuna condizione verificata
			</c:otherwise>
		</c:choose>
		<br> <br>
		<hr>
		<%
			List<String> lista = new ArrayList<>();
			lista.add("1");
			lista.add("2");
			lista.add("3");
			lista.add("4");
			lista.add("5");

			for (String s : lista)
				out.println(s);

			request.setAttribute("lista", lista);
			/*
				requestScope.NOMEATTRIBUTO
				sessioneScope.NOMEATTRIBUTO
				param.NOMEATTRIBUTO
			*/
		%>


		<c:forEach items="${requestScope.lista}" var="elemento"
			varStatus="contatore">
			${elemento} : ${contatore.count}<br>
		</c:forEach>

<c:forTokens items="1,2,3,4,5" delims="," var="numero" varStatus="contatore"></c:forTokens>
		${numero}
	</header>
</body>
</html>