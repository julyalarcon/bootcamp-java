package com.protalento.utilidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class FechasEmpleados {
	
	public static final String SQL_PATRON_FECHAHORA = "yyyy-MM-dd HH:mm:ss";
	public static final String SQL_PATRON_FECHA = "yyyy-MM-dd";
	public static final String USUARIO_FORMATO = "dd/MM/yyyy";
	
	private FechasEmpleados() {
		super(); 
	}
	
	public static DateTimeFormatter getDateTimeFormatter(String format) {
		return DateTimeFormatter.ofPattern(format);
	}
	
	public static LocalDateTime getLocalDateTimeNow(String dateTimePattern) {
		DateTimeFormatter dateTimeFormatter = getDateTimeFormatter(dateTimePattern);
		return LocalDateTime.parse(LocalDateTime.now().format(dateTimeFormatter), dateTimeFormatter);
	}
	
	public static String getLocalDateTimeString(LocalDateTime dateTime, String format) {
		return dateTime.format(getDateTimeFormatter(format));
	}
}
