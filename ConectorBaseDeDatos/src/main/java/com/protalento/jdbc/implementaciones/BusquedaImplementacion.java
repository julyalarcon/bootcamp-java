package com.protalento.jdbc.implementaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.protalento.entidades.Busqueda;
import com.protalento.jdbc.interfaces.ConexionMariaDB;
import com.protalento.jdbc.interfaces.DAO;
import com.protalento.utilidades.Fechas;

public class BusquedaImplementacion implements DAO<Busqueda, Integer>, ConexionMariaDB {

	private Connection conexionMariaDB;

	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementListar;

	public BusquedaImplementacion() {
		super();
	}

	@Override
	public Busqueda buscarPorID(Integer key) {
		return null;
	}

	@Override
	public boolean insertar(Busqueda elemento) {
		conexionMariaDB = getConexion();

		String sql = "insert into busquedas (texto,url,contenidoWeb,fecha) values (?,?,?,?)";

		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = getConexion().prepareStatement(sql,
						PreparedStatement.RETURN_GENERATED_KEYS);
			}

			LocalDateTime dateTime = Fechas.getLocalDateTimeNow(Fechas.PATRON_FECHA_HORA);
			elemento.setFecha(dateTime);

			preparedStatementInsertar.setString(1, elemento.getTexto());
			preparedStatementInsertar.setString(2, elemento.getUrl());
			preparedStatementInsertar.setString(3, elemento.getContenidoWeb());
			preparedStatementInsertar.setString(4, Fechas.getLocalDateTimeString(dateTime, Fechas.PATRON_FECHA_HORA));

			if (preparedStatementInsertar.executeUpdate() != 0) {
				ResultSet resultSet = preparedStatementInsertar.getGeneratedKeys();

				if (resultSet.next()) {
					elemento.setId(resultSet.getInt(1));
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Busqueda> listar() {
		conexionMariaDB = getConexion();

		List<Busqueda> busquedaLista = new ArrayList<Busqueda>();

		String sql = "select id,texto,url,fecha from busquedas;";

		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = conexionMariaDB.prepareStatement(sql);
			}

			ResultSet resultSet = preparedStatementListar.executeQuery();

			while (resultSet.next()) {
				Busqueda buscando = new Busqueda();
				buscando.setId(resultSet.getInt("id"));
				buscando.setTexto(resultSet.getString("texto"));
				buscando.setUrl(resultSet.getString("url"));

				String resulDateTime = resultSet.getString("fecha");
				LocalDateTime dateTime = LocalDateTime.parse(resulDateTime,
						Fechas.getDateTimeFormatter(Fechas.PATRON_FECHA_HORA));
				buscando.setFecha(dateTime);
				busquedaLista.add(buscando);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return busquedaLista;
	}

	/*
	 * public static void main(String[] args) { Busqueda busca = new Busqueda(1,
	 * "Recetas", "https://www.google.com/", "recetas con pollo", null, 0);
	 * BusquedaImplementacion buscaImplementacion = new BusquedaImplementacion();
	 * buscaImplementacion.insertar(busca);
	 * 
	 * System.out.println(busca); }
	 */

	
	  public static void main(String[] args) { BusquedaImplementacion
	  busquedaImplementacion = new BusquedaImplementacion();
	  
	  List<Busqueda> listado = (List<Busqueda>) busquedaImplementacion.listar();
	  
	  for (Busqueda busqueda : listado) { System.out.println(busqueda); } }
	 

}
