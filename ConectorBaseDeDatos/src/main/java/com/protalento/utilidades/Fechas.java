package com.protalento.utilidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Fechas {

	public static final String PATRON_FECHA_HORA = "yyyy-MM-dd HH:mm:ss";
	
	//Para que no me puedan instanciar la clase
	private Fechas() {
		
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






