package com.protalento.entidades;

import com.protalento.enumerados.TipoDocumento;

public final class Documento {
	
	private TipoDocumento tipo;
	private String numero;
	
	public Documento() {
		super();
	}
	
	public Documento(TipoDocumento tipo, String numero) {
		super();
		this.tipo = tipo;
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Documento [tipo=" + tipo + ", numero=" + numero + "]";
	}

	public TipoDocumento getTipo() {
		return tipo;
	}
	public void setTipo(TipoDocumento tipo) {
		this.tipo = tipo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
