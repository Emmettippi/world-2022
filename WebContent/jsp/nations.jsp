<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mondo</title>
</head>
<body>
	<h1>Lista Nazioni</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>CODICE</th>
			<th>NOME</th>
		</tr>
		<c:forEach items="${nations}" var="nation">
			<tr>
				<td>${nation.id}</td>
				<td>${nation.codice}</td>
				<td>${nation.nome}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>