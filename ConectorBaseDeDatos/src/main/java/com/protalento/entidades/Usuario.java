package com.protalento.entidades;

import java.time.LocalDateTime;

import com.protalento.excepciones.PatronExcepcion;
import com.protalento.utilidades.Patrones;

public final class Usuario {
	private String correo;
	private String clave;
	private LocalDateTime fechaUltimoAcceso;
	private Byte intentosFallidos;
	
	public Usuario() {
		super();
	}

	public Usuario(String correo, String clave, LocalDateTime fechaUltimoAcceso, Byte intentosFallidos) throws PatronExcepcion {
		super();
		setCorreo(correo);
		setClave(clave);
		this.fechaUltimoAcceso = fechaUltimoAcceso;
		this.intentosFallidos = intentosFallidos;
	}

	@Override
	public String toString() {
		return "Usuario [correo=" + correo + ", clave=" + clave + ", fechaUltimoAcceso=" + fechaUltimoAcceso
				+ ", intentosFallidos=" + intentosFallidos + "]";
	}

	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) throws PatronExcepcion {
		if (Patrones.esCorreo(correo)) {
			this.correo = correo;
		}	
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) throws PatronExcepcion {
		if (Patrones.esClave(clave)) {
			this.clave = clave;
		}
	}

	public LocalDateTime getFechaUltimoAcceso() {
		return fechaUltimoAcceso;
	}

	public void setFechaUltimoAcceso(LocalDateTime fechaUltimoAcceso) {
		this.fechaUltimoAcceso = fechaUltimoAcceso;
	}

	public Byte getIntentosFallidos() {
		return intentosFallidos;
	}

	public void setIntentosFallidos(Byte intentosFallidos) {
		this.intentosFallidos = intentosFallidos;
	}
	
	
}
