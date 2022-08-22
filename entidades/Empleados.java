package com.protalento.entidades;

import java.time.LocalDate;

public class Empleados {
	private String id_empleado;
	private String empleado;
	private String telefono;
	private String jefe;
	private String id_jefe;
	private String id_sucursal;
	private LocalDate fecha_incorporacion;
	
	public Empleados() {
		super();
	}
	public Empleados(String id_empleado, String empleado, String telefono, String jefe, String id_jefe,
			String id_sucursal, LocalDate fecha_incorporacion) {
		super();
		this.id_empleado = id_empleado;
		this.empleado = empleado;
		this.telefono = telefono;
		this.jefe = jefe;
		this.id_jefe = id_jefe;
		this.id_sucursal = id_sucursal;
		this.fecha_incorporacion = fecha_incorporacion;
	}
	@Override
	public String toString() {
		return "Empleados [id_empleado=" + id_empleado + ", empleado=" + empleado + ", telefono=" + telefono + ", jefe="
				+ jefe + ", id_jefe=" + id_jefe + ", id_sucursal=" + id_sucursal + ", fecha_incorporacion="
				+ fecha_incorporacion + "]";
	}
	/**
	 * @return the id_empleado
	 */
	public String getId_empleado() {
		return id_empleado;
	}
	/**
	 * @param id_empleado the id_empleado to set
	 */
	public void setId_empleado(String id_empleado) {
		this.id_empleado = id_empleado;
	}
	/**
	 * @return the empleado
	 */
	public String getEmpleado() {
		return empleado;
	}
	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the jefe
	 */
	public String getJefe() {
		return jefe;
	}
	/**
	 * @param jefe the jefe to set
	 */
	public void setJefe(String jefe) {
		this.jefe = jefe;
	}
	/**
	 * @return the id_jefe
	 */
	public String getId_jefe() {
		return id_jefe;
	}
	/**
	 * @param id_jefe the id_jefe to set
	 */
	public void setId_jefe(String id_jefe) {
		this.id_jefe = id_jefe;
	}
	/**
	 * @return the id_sucursal
	 */
	public String getId_sucursal() {
		return id_sucursal;
	}
	/**
	 * @param id_sucursal the id_sucursal to set
	 */
	public void setId_sucursal(String id_sucursal) {
		this.id_sucursal = id_sucursal;
	}
	/**
	 * @return the fecha_incorporacion
	 */
	public LocalDate getFecha_incorporacion() {
		return fecha_incorporacion;
	}
	/**
	 * @param fecha_incorporacion the fecha_incorporacion to set
	 */
	public void setFecha_incorporacion(LocalDate fecha_incorporacion) {
		this.fecha_incorporacion = fecha_incorporacion;
	}
	
}
