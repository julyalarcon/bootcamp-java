package com.protalento.entidades;

import java.time.LocalDateTime;

public class Busqueda {
	private int id;
	private String texto;
	private String url;
	private String contenidoWeb;
	private LocalDateTime fecha;
	private int coincidencia;
	
	public Busqueda() {
		super();
	}
	
	public Busqueda(int id, String texto, String url, String contenidoWeb, LocalDateTime fecha, int coincidencia) {
		super();
		this.id = id;
		this.texto = texto;
		this.url = url;
		this.contenidoWeb = contenidoWeb;
		this.fecha = fecha;
		this.coincidencia = coincidencia;
	}
	
	
	@Override
	public String toString() {
		return "Busqueda [id=" + id + ", texto=" + texto + ", url=" + url + ", contenidoWeb=" + contenidoWeb
				+ ", fecha=" + fecha + ", coincidencia=" + coincidencia + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContenidoWeb() {
		return contenidoWeb;
	}
	public void setContenidoWeb(String contenidoWeb) {
		this.contenidoWeb = contenidoWeb;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public int getCoincidencia() {
		return coincidencia;
	}
	public void setCoincidencia(int coincidencia) {
		this.coincidencia = coincidencia;
	}
	

}
