package com.protalento.entidades;

import java.time.LocalDate;

import com.protalento.enumerados.TipoDocumento;

public final class Empleado {
	
	private String documento;
	private TipoDocumento tipo;
	private String nombre;
	private String apellido;
	private int edad;
	private LocalDate fechaNacimiento;
	
	public Empleado() {
		super();
	}
	
	public Empleado(String documento, TipoDocumento tipo, String nombre, String apellido, int edad,
			LocalDate fechaNacimiento) {
		super();
		this.documento = documento;
		this.tipo = tipo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Empleado [documento=" + documento + ", tipo=" + tipo + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", edad=" + edad + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public TipoDocumento getTipo() {
		return tipo;
	}
	public void setTipo(TipoDocumento tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
