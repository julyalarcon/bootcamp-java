<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Busquedas</title>
<link rel="stylesheet" href="css/busquedaWeb.css" >
</head>
<body>
<%
	Busqueda busquedas = (Busqueda) request.getAttribute("busquedas");
%>

<h1>Busqueda "<span id="texto"> <%=busquedas.getTexto()%> </span>" encontrada <span id="coincidencia"> </span> tiempo de busqueda
"<span id="url"> <%=busquedas.getUrl()%></span>" </h1>

<a href=<%=busquedas.getUrl()%>>Ir</a>
<a href="index.html">Inicio</a>

<section id="hiddenText" hidden="true" style="color: transparent;" ><%=busquedas.getContenidoWeb() %></section>
<script src="scripts/main.js"></script>

</body>
</html>