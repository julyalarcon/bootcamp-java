package com.protalento.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.protalento.entidades.Empleado;
import com.protalento.enumerados.Alertas;
import com.protalento.enumerados.TipoDocumento;
import com.protalento.jdbc.implementaciones.EmpleadoImplementacion;
import com.protalento.utilidades.FechasEmpleados;

//@WebServlet("/empleados")

public class EmpleadoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger();
	private EmpleadoImplementacion empleadoImplementacion;

	
    public EmpleadoControlador() {
        super();
        empleadoImplementacion = new EmpleadoImplementacion();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
    	String documento = String.valueOf(request.getParameter("documento"));
    	
    	Empleado empleado = new Empleado(documento, null, null, null, 0, null);
		request.setAttribute("alerta",
				empleadoImplementacion.eliminar(empleado) ? Alertas.ELIMINAR : Alertas.REGISTRO_NO_ENCONTRADO);
		RequestDispatcher requestDispatcher;
		requestDispatcher = request.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(request, response);
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String documento = String.valueOf(request.getParameter("documento"));
    	TipoDocumento tipo = TipoDocumento.valueOf(request.getParameter("tipo").toString());
    	//String tipo = String.valueOf(TipoDocumento.valueOf(request.getParameter("tipo")));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int edad = Integer.valueOf(request.getParameter("edad"));
		String fechaNacimientoString = request.getParameter("fechaNacimiento");

		logger.debug("fechaNacimiento " + fechaNacimientoString);
		LocalDate diaFechaNacimiento = LocalDate.parse(fechaNacimientoString, FechasEmpleados.getDateTimeFormatter(FechasEmpleados.SQL_PATRON_FECHA));	

		RequestDispatcher requestDispatcher;
		Empleado empleado = new Empleado(documento, tipo, nombre, apellido, edad, diaFechaNacimiento);
		logger.debug(empleado);

		empleadoImplementacion.guardar(empleado);
		request.setAttribute("alerta", Alertas.GUARDAR);

		requestDispatcher = request.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(request, response);

		
		/*
		String tipoDocumento = request.getParameter("tipoDocumento");
		String numeroDocumento = request.getParameter("numeroDocumento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int edad = Integer.valueOf(request.getParameter("edad"));
		String fechaNacimientoString = request.getParameter("fechaNacimiento");

		logger.debug("fechaNacimiento " + fechaNacimientoString);
		LocalDate diaFechaNacimiento = LocalDate.parse(fechaNacimientoString, FechasEmpleados.getDateTimeFormatter(FechasEmpleados.SQL_PATRON_FECHA));	
		
		Documento documento = new Documento(TipoDocumento.valueOf(tipoDocumento), numeroDocumento);
		Empleado empleado = new Empleado(documento, nombre, apellido, edad, diaFechaNacimiento);
		
		RequestDispatcher requestDispatcher;
		logger.debug(empleado);

		empleadoImplementacion.guardar(empleado);
		request.setAttribute("alerta", Alertas.GUARDAR);

		requestDispatcher = request.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(request, response);
		*/
		
	}	
}
