package com.protalento.entidades;

public class Productos {
	private Long id;
	private String id_cliente;
	private String cuentaAhorros;
	private String cuentaCorriente;
	private String prestamos;
	private String id_empleados;
	
	public Productos() {
		super();
	}
	public Productos(Long id, String id_cliente, String cuentaAhorros, String cuentaCorriente, String prestamos,
			String id_empleados) {
		super();
		this.id = id;
		this.id_cliente = id_cliente;
		this.cuentaAhorros = cuentaAhorros;
		this.cuentaCorriente = cuentaCorriente;
		this.prestamos = prestamos;
		this.id_empleados = id_empleados;
	}
	@Override
	public String toString() {
		return "Productos [id=" + id + ", id_cliente=" + id_cliente + ", cuentaAhorros=" + cuentaAhorros
				+ ", cuentaCorriente=" + cuentaCorriente + ", prestamos=" + prestamos + ", id_empleados=" + id_empleados
				+ "]";
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the id_cliente
	 */
	public String getId_cliente() {
		return id_cliente;
	}
	/**
	 * @param id_cliente the id_cliente to set
	 */
	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}
	/**
	 * @return the cuentaAhorros
	 */
	public String getCuentaAhorros() {
		return cuentaAhorros;
	}
	/**
	 * @param cuentaAhorros the cuentaAhorros to set
	 */
	public void setCuentaAhorros(String cuentaAhorros) {
		this.cuentaAhorros = cuentaAhorros;
	}
	/**
	 * @return the cuentaCorriente
	 */
	public String getCuentaCorriente() {
		return cuentaCorriente;
	}
	/**
	 * @param cuentaCorriente the cuentaCorriente to set
	 */
	public void setCuentaCorriente(String cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}
	/**
	 * @return the prestamos
	 */
	public String getPrestamos() {
		return prestamos;
	}
	/**
	 * @param prestamos the prestamos to set
	 */
	public void setPrestamos(String prestamos) {
		this.prestamos = prestamos;
	}
	/**
	 * @return the id_empleados
	 */
	public String getId_empleados() {
		return id_empleados;
	}
	/**
	 * @param id_empleados the id_empleados to set
	 */
	public void setId_empleados(String id_empleados) {
		this.id_empleados = id_empleados;
	}
}
