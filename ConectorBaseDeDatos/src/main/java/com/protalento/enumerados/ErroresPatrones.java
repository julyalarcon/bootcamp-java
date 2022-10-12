package com.protalento.enumerados;

public enum ErroresPatrones {
	CORREO("Debe ingresar un formato permitido 'usuario@dominio.ext'"),
	CLAVE("La clave debe tener entre 8 y 16 caracteres, al menos un dígito, al menos una minúscula y al menos una mayúscula. NO puede tener otros símbolos.");

	private String mensaje;

	ErroresPatrones(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}
