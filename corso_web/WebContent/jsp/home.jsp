<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="
	<%=request.getContextPath()%>
	/test" method="get">
		<label for="name">Nome</label> <input type="text" name="nome" value="">
		<br> <label for="cognome">Cognome</label> <input type="text"
			name="cognome" value=""> <br>
		<button type="submit" name="invia">Invia</button>
	</form>
</body>
</html>