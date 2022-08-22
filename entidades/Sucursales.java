package com.protalento.entidades;

public class Sucursales {
	private String id;
	private String nombre;
	private String ciudad;
	
	public Sucursales() {
		super();
	}
	public Sucursales(String id, String nombre, String ciudad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
	}
	@Override
	public String toString() {
		return "Sucursales [id=" + id + ", nombre=" + nombre + ", ciudad=" + ciudad + "]";
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
}
