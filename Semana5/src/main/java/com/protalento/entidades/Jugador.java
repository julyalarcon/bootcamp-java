package com.protalento.entidades;

public class Jugador {
	private String nombre;
	private String apellido;
	private String dorsal;
	private String equipo;
	
	public Jugador() {
		super();
	}
	
	public Jugador(String nombre, String apellido, String dorsal, String equipo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dorsal = dorsal;
		this.equipo = equipo;
	}
	
	@Override
	public String toString() {
		return "Jugador [" + nombre + ", " + apellido + ", " + dorsal + ", " + equipo
				+ "]";
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the dorsal
	 */
	public String getDorsal() {
		return dorsal;
	}
	/**
	 * @param dorsal the dorsal to set
	 */
	public void setDorsal(String dorsal) {
		this.dorsal = dorsal;
	}
	/**
	 * @return the equipo
	 */
	public String getEquipo() {
		return equipo;
	}
	/**
	 * @param equipo the equipo to set
	 */
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	
	
	
	
}
