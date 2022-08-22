package com.protalento.entidades;

public class Cliente {
	private String id;
	private String nombre;
	private String direccion;
	private String ciudad_cliente;
	
	public Cliente() {
		super();
	}
	public Cliente(String id, String nombre, String direccion, String ciudad_cliente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad_cliente = ciudad_cliente;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", ciudad_cliente="
				+ ciudad_cliente + "]";
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the ciudad_cliente
	 */
	public String getCiudad_cliente() {
		return ciudad_cliente;
	}
	/**
	 * @param ciudad_cliente the ciudad_cliente to set
	 */
	public void setCiudad_cliente(String ciudad_cliente) {
		this.ciudad_cliente = ciudad_cliente;
	}
}
