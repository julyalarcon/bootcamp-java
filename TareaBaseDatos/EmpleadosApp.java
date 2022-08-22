package com.protalento.TareaBaseDatos;

import java.time.LocalDate;

import com.protalento.entidades.Empleados;
import com.protalento.implementaciones.mariadb.EmpleadosImplementacion;
import com.protalento.utilidades.Fechas;

public class EmpleadosApp {
	public static void main(String[] args) {
		Empleados empleados1;
		Empleados empleados2;
		Empleados empleados3;
		EmpleadosImplementacion empleadosImplementacion = new EmpleadosImplementacion();
		
		// Buscar
		System.out.println("****************Buscar****************");
		empleados1 = empleadosImplementacion.buscarPorId("542356");
		System.out.println(empleados1);

		empleados2 = empleadosImplementacion.buscarPorId("345632");
		System.out.println(empleados2);

		empleados3 = empleadosImplementacion.buscarPorId("348643");
		System.out.println(empleados3);
		
		// Insertar
		Empleados empleados4 = new Empleados();
		empleados4.setId_empleado("803564");
		empleados4.setEmpleado("Natalia Perez");
		empleados4.setTelefono("4263456");
		empleados4.setJefe("Lucas Jimenez");
		empleados4.setId_jefe("675432");
		empleados4.setId_sucursal("1CA1");
		empleados4.setFecha_incorporacion(LocalDate.parse("2019-01-19", Fechas.getDateTimeFormatter(Fechas.getFormatoFechaUsa())));
		
		System.out.println("");
		System.out.println("****************Insertar****************");
		System.out.println(empleados4);
		System.out.println(empleadosImplementacion.insertar(empleados4));
		
		// Modificar
		System.out.println("");
		System.out.println("****************Modificar****************");
		empleados2.setTelefono("5269856");
		empleados2.setJefe("Juan Castañeda");
		empleados2.setId_jefe("234561");
		empleados2.setId_sucursal("1CA1");
		System.out.println(empleados2);
		System.out.println(empleadosImplementacion.modificar(empleados2));

		// Eliminar
		System.out.println("");
		System.out.println("****************Eliminar****************");
		System.out.println(empleados3);
		System.out.println(empleadosImplementacion.eliminar(empleados3));
		
		// Listar
		System.out.println("");
		System.out.println("****************Listar****************");
		for (Empleados empleadolist : empleadosImplementacion.listar()) {
			System.out.println(empleadolist);
		}
	}
	
}
