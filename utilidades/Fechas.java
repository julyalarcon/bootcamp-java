package com.protalento.utilidades;

import java.time.format.DateTimeFormatter;

public interface Fechas {
	public static final String FORMATO_FECHA = "dd/MM/yyyy";
	public static final String FORMATO_FECHA_SQL = "yyyy-MM-dd";
	
	public static String getFormatoFecha() {
		return FORMATO_FECHA;
	}
	
	public static String getFormatoFechaUsa() {
		return FORMATO_FECHA_SQL;
	}
	
	public static DateTimeFormatter getDateTimeFormatter(String format) {
		return DateTimeFormatter.ofPattern(format);
	}
	
}
