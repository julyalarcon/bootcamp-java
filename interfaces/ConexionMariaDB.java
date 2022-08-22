package com.protalento.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConexionMariaDB {
	
	String KEY = "banco";

	default Connection getConexion() {
		Connection conexion = null;
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/banco";
		String usuario = "root";
		String clave = "";

		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, usuario, clave);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conexion;
	}

}
