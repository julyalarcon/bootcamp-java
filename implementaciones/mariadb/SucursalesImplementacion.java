package com.protalento.implementaciones.mariadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.protalento.entidades.Sucursales;
import com.protalento.interfaces.ConexionMariaDB;
import com.protalento.interfaces.DAO;

public class SucursalesImplementacion implements DAO<Sucursales, String>, ConexionMariaDB {

	private PreparedStatement preparedStatementBuscarPorID;
	private PreparedStatement preparedStatementEliminar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementListar;

	@Override
	public Sucursales buscarPorId(String id) {
		Sucursales sucursales = null;
		String sql = "select nombre, ciudad from sucursales where id = ?";

		try {
			if (preparedStatementBuscarPorID == null) {
				preparedStatementBuscarPorID = getConexion().prepareStatement(sql);
			}

			preparedStatementBuscarPorID.setString(1, id);

			ResultSet resultSet = preparedStatementBuscarPorID.executeQuery();

			if (resultSet.next()) {
				sucursales = new Sucursales();
				sucursales.setId(id);
				sucursales.setNombre(resultSet.getString("nombre"));;
				sucursales.setCiudad(resultSet.getString("ciudad"));  
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sucursales;
	}

	@Override
	public boolean insertar(Sucursales sucursales) {
		if (sucursales == null) {
			return false;
		}
		String sql = "insert into sucursales (id,nombre,ciudad) values (?,?,?)";

		try {

			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = getConexion().prepareStatement(sql);
			}
			preparedStatementInsertar.setString(1, sucursales.getId());
			preparedStatementInsertar.setString(2, sucursales.getNombre());
			preparedStatementInsertar.setString(3, sucursales.getCiudad());

			return preparedStatementInsertar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean modificar(Sucursales sucursales) {
		if (sucursales == null) {
			return false;
		}

		String sql = "update sucursales set nombre = ? where id = ? and ciudad = ?";

		try {

			if (preparedStatementModificar == null) {
				preparedStatementModificar = getConexion().prepareStatement(sql);
			}

			preparedStatementModificar.setString(1, sucursales.getNombre());
			preparedStatementModificar.setString(2, sucursales.getId());
			preparedStatementModificar.setString(3, sucursales.getCiudad());

			return preparedStatementModificar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean eliminar(Sucursales sucursales) {
		if (sucursales == null) {
			return false;
		}

		String sql = "delete from sucursales where id = ?";

		try {

			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = getConexion().prepareStatement(sql);
			}
			preparedStatementEliminar.setString(1, sucursales.getId());

			return preparedStatementEliminar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Sucursales> listar() {
		List<Sucursales> sucursalist = new ArrayList<>();
		String sql = "select id,nombre,ciudad from sucursales";
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = getConexion().prepareStatement(sql);
			}

			ResultSet resultSet = preparedStatementListar.executeQuery();
			while (resultSet.next()) {
				Sucursales sucursal = new Sucursales();
				sucursal.setId(resultSet.getString("id"));
				sucursal.setNombre(resultSet.getString("nombre"));
				sucursal.setCiudad(resultSet.getString("ciudad"));;

				sucursalist.add(sucursal);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sucursalist;
	}

}
