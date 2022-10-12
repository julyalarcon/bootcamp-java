package com.protalento.enumerados;

public enum TipoDocumento {
	
	CC("Cedula de ciudadania"),
	CE("Cedula extranjería"),
	PA("Pasaporte"),
	TI("Tarjeta de identidad"),
	RC("Registro civil");
	
	private String descripcion;

	private TipoDocumento(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
		
	
}
