<%@page import="com.protalento.utilidades.Fechas"%>
<%@page import="com.protalento.entidades.Busqueda"%>
<%@page import="java.util.List"%>
<%@page import="com.protalento.jdbc.implementaciones.BusquedaImplementacion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/tablas.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/botones.css">
</head>

<body>

<%
BusquedaImplementacion busquedaImplementacion = new BusquedaImplementacion();
List<Busqueda> busquedaLista = (List<Busqueda>) busquedaImplementacion.listar();
%>

<nav>
	<button id="inicioBusquedaCompleto" class="button"> 
	
	<a id="inicioBusqueda" class="button" href="index.html">Inicio</a>
	</button>
</nav>

<section>
	<h1>Historial de Busquedas</h1>
	<table>
		<thead>
			<tr>
				<th>Texto</th>
				<th>Url</th>
				<th>Fecha</th>
			</tr>
		</thead>
		<tbody>
		<%
			for(Busqueda busquedas : busquedaLista){
		%>
			<tr>
				<td><%=busquedas.getTexto()%></td>
				<%String url = busquedas.getUrl();%>
				<td>
					<a id="busquedaLink" href="<%=url%>"><%=url %></a>	
				</td>
				<td><%=Fechas.getLocalDateTimeString(busquedas.getFecha(), Fechas.PATRON_FECHA_HORA)%> </td>
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
</section>

</body>
</html>