<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${nation.nome} ${METHOD}</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty nation.id}">
			<h1>Crea nuova nazione</h1>
		</c:when>
		<c:otherwise>
			<h1>Modifica ${nation.nome}</h1>
		</c:otherwise>
	</c:choose>
	<form action="/World2022/" method="POST">
		<div>
			<label>ID: ${nation.id}</label> <input type="hidden"
				value="${nation.id}" name="id" />
		</div>
		<div>
			<label>CODICE:</label> <input type="text" value="${nation.codice}"
				name="codice" required="required" />
		</div>
		<div>
			<label>NOME:</label> <input type="text" value="${nation.nome}"
				name="nome" required="required" />
		</div>
		<div>
			<label>POPOLAZIONE:</label> <input type="number"
				value="${nation.population}" name="population" min="0"
				required="required" />
		</div>
		<div>
			<input type="submit" value="SALVA" />
		</div>
	</form>
	<a href="./"> INDIETRO </a>
</body>
</html>