<%@page import="com.protalento.entidades.Usuario"%>
<%@page import="com.protalento.entidades.Empleado"%>
<%@page import="com.protalento.jdbc.implementaciones.EmpleadoImplementacion"%>
<%@page import="com.protalento.enumerados.Alertas"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="imagenes/protalento.png" />
<link rel="stylesheet" href="css/botones.css">
<link rel="stylesheet" href="css/alert.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/formulario.css">
<meta charset="ISO-8859-1">
<title>Empleados (Practica - JSP)</title>
</head>
<body>

	<%
	Alertas alerta = (Alertas) request.getAttribute("alerta");

	String documento = request.getParameter("documento");
	Empleado empleado = null;
	EmpleadoImplementacion empleadoImplementacion = null;

	if (documento != null) {
		empleadoImplementacion = new EmpleadoImplementacion();
		empleado = empleadoImplementacion.buscarPorID(String.valueOf(documento));
	}

	Usuario usuario = (Usuario) session.getAttribute("usuario");
	if (null == usuario) {
		response.sendRedirect("login.jsp");
	} else {
	%>

	<div>
		<%=(null == alerta ? "" : alerta.getMensaje())%>
	</div>

	<div>
		<header>
			<h1>Practica JSP - <%=session.getAttribute("VERSION") %></h1>
			<h2>
				Bienvenido
				<%=usuario.getCorreo()%></h2>
			<!-- Imagen -->
		</header>
	</div>
	<nav>
		<a href="index.jsp">Inicio</a> <a
			style="float: right;" onclick="cerrarSesion()">Cerrar Sesion</a>
	</nav>

	<div>

		<section>

			<h2>Empleados</h2>


			<div>
				<form action="EmpleadoControlador" method="post">

					<input type="hidden" id="id" name="id"
						value="<%=empleado != null ? empleado.getDocumento() : 0%>"> <label
						for="documento">Documento</label> <input type="text"
						id="documento" name="documento"
						placeholder="Documento empleado" required	
						<%=empleado != null ? "value=\"" + empleado.getDocumento() + "\"" : 0%>>
						
						<label for="tipo">Tipo Documento</label> <input type="text"
						id="tipo" name="tipo"
						placeholder="Tipo Documento Empleado" required	
						<%=empleado != null ? "value=\"" + empleado.getTipo() + "\"" : 0%>>
						
						<label for="nombre">Nombre</label> <input type="text"
						id="nombre" name="nombre"
						placeholder="Nombre empleado" required	
						<%=empleado != null ? "value=\"" + empleado.getNombre() + "\"" : 0%>>
						
						<label for="apellido">Apellido</label> <input type="text"
						id="apellido" name="apellido"
						placeholder="Apellido empleado" required	
						<%=empleado != null ? "value=\"" + empleado.getApellido() + "\"" : 0%>>
						
						<label for="edad">Edad</label> <input type="text"
						id="edad" name="edad"
						placeholder="Edad empleado" required	
						<%=empleado != null ? "value=\"" + empleado.getEdad() + "\"" : 0%>>
						
						<label for="fechaNacimiento">Fecha Nacimiento</label> <input type="text"
						id="fecha" name="fecha"
						placeholder="Fecha Nacimiento Empleado" required	
						<%=empleado != null ? "value=\"" + empleado.getFechaNacimiento() + "\"" : 0%>>
			
					<button class="success" type="submit"><%=empleado != null ? "Modificar" : "Agregar"%></button>
					<button class="warning" type="reset">Limpiar</button>

				</form>
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