<%@page import="com.protalento.utilidades.FechasEmpleados"%>
<%@page import="com.protalento.entidades.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="com.protalento.jdbc.implementaciones.EmpleadoImplementacion"%>
<%@page import="com.protalento.enumerados.Alertas"%>
<%@page import="com.protalento.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="imagenes/lupa.png" />
<link rel="stylesheet" href="css/botones.css">
<link rel="stylesheet" href="css/alert.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/tabla.css">
<meta charset="ISO-8859-1">
<title>Inicio (Practica - JSP)</title>
</head>
<body>

	<%
	Usuario usuario = (Usuario) session.getAttribute("usuario");
	if (null == usuario) {
		response.sendRedirect("login.jsp");
	} else {

		Alertas alerta = (Alertas) request.getAttribute("alerta");
		if (!(null == alerta)) {
	%>
	<div id="alert">
		<a class="alert <%=alerta.getClaseCSS()%>" href="#alert"><%=alerta.getMensaje()%></a>
	</div>

	<%
	}
	%>

	<div>
		<header>
			<h1>Practica - <%=session.getAttribute("VERSION") %></h1>
			<h2>
				Bienvenido
				<%=usuario.getCorreo()%></h2>
			<!-- Imagen -->
		</header>
	</div>
	<nav>
		<a href="empleado.jsp">Agregar Empleado</a> <a
			style="float: right;" onclick="cerrarSesion()">Cerrar Sesion</a>
	</nav>

	<div>

		<section>

			<h2>Empleados</h2>

			<%
			EmpleadoImplementacion empleadoImplementacion = new EmpleadoImplementacion();
			List<Empleado> empleadosLista = empleadoImplementacion.listar();
			%>

			<div>
				<table>
					<tr>
						<th>Numero Documento</th>
						<th>Tipo Documento</th>						
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Edad</th>
						<th>Fecha Nacimiento</th>
						<th>Accion</th>
					</tr>

					<%
					for (Empleado empleado : empleadosLista) {
					%>
					<tr>
						<td><%=empleado.getDocumento()%></td>
						<td><%=empleado.getTipo()%></td>
						<td><%=empleado.getNombre()%></td>
						<td><%=empleado.getApellido()%></td>
						<td><%=empleado.getEdad()%></td>
						<td><%=empleado.getFechaNacimiento().format(FechasEmpleados.getDateTimeFormatter(FechasEmpleados.SQL_PATRON_FECHA)) %></td>
						<td>
							<button class="warning"
								onclick="editar('empleado.jsp',<%=empleado.getDocumento()%>)">Editar</button>
							<button class="danger"
								onclick="eliminar('empleadosLista',<%=("'" + empleado.getDocumento() + "','" + empleado + "'")%>)">Eliminar</button>
						</td>
					</tr>

					<%
					}
					%>

				</table>

			</div>

		</section>

	</div>

	<div>
		<footer>

			<p>Creado por July Alarcon - Practica JSP</p>
		</footer>

	</div>


	<%
	}
	%>
	<script src="scripts/confirmar.js" type="text/javascript"></script>



</body>
</html>