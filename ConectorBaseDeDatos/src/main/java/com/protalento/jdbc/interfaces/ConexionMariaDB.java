package com.protalento.jdbc.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public interface ConexionMariaDB {

	default Connection getConexion(){
		InputStream PATH;
		 
		Properties propiedades = new Properties();
		
		try {
			
			PATH = Thread.currentThread().getContextClassLoader().getResourceAsStream("basededatos.properties");
			
			propiedades.load(PATH);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Connection conexion = null;
		
		try {
			
			String DRIVER = propiedades.getProperty("db_driver");
			String URL = propiedades.getProperty("db_url");
			String USUARIO = propiedades.getProperty("db_usuario");
			String CLAVE = propiedades.getProperty("db_clave");
			
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conexion;
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getContextClassLoader().getResourceAsStream("basededatos.properties"));
	}
		
	}
		
		

