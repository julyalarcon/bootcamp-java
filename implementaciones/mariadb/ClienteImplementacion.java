package com.protalento.implementaciones.mariadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.protalento.entidades.Cliente;
import com.protalento.interfaces.ConexionMariaDB;
import com.protalento.interfaces.DAO;

public class ClienteImplementacion implements DAO<Cliente, String>, ConexionMariaDB {

	private PreparedStatement preparedStatementBuscarPorID;
	private PreparedStatement preparedStatementEliminar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementListar;

	@Override
	public Cliente buscarPorId(String id) {
		Cliente cliente = null;
		String sql = "select nombre, direccion, ciudad_cliente from clientes where id = ?";

		try {

			if (preparedStatementBuscarPorID == null) {
				preparedStatementBuscarPorID = getConexion().prepareStatement(sql);
			}
			preparedStatementBuscarPorID.setString(1, id);

			ResultSet resultSet = preparedStatementBuscarPorID.executeQuery();

			if (resultSet.next()) {
				cliente = new Cliente();
				cliente.setId(id);
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setDireccion(resultSet.getString("direccion"));
				cliente.setCiudad_cliente(resultSet.getString("ciudad_cliente"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}

	@Override
	public boolean insertar(Cliente cliente) {
		//Para que no de error: Nullpointerexception
		if (cliente == null) {
			return false;
		}
		
		String sql = "insert into clientes (id,nombre,direccion,ciudad_cliente) values (?,?,?,?)";
		
		try {
			if(preparedStatementInsertar == null) {
				preparedStatementInsertar = getConexion().prepareStatement(sql);
			}
			
			preparedStatementInsertar.setString(1, cliente.getId());
			preparedStatementInsertar.setString(2, cliente.getNombre());
			preparedStatementInsertar.setString(3, cliente.getDireccion());
			preparedStatementInsertar.setString(4, cliente.getCiudad_cliente());
			
			return preparedStatementInsertar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Cliente cliente) {
		//Para que no de error: Nullpointerexception
		if (cliente == null) {
			return false;
		}
		
		String sql = "update clientes set direccion = ?, ciudad_cliente = ? where id = ? and nombre = ?";
		try {
			if (preparedStatementModificar == null) {
				preparedStatementModificar = getConexion().prepareStatement(sql);
			}
			preparedStatementModificar.setString(1, cliente.getDireccion());
			preparedStatementModificar.setString(2, cliente.getCiudad_cliente());
			preparedStatementModificar.setString(3, cliente.getId());
			preparedStatementModificar.setString(4, cliente.getNombre());
			
			return preparedStatementModificar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean eliminar(Cliente cliente) {
		//Para que no de error: Nullpointerexception
		if (cliente == null) {
			return false;
		}
		
		String sql = "delete from clientes where id = ?";
		try {
			if(preparedStatementEliminar == null) {
				preparedStatementEliminar = getConexion().prepareStatement(sql);
			}
			preparedStatementEliminar.setString(1, cliente.getId());
			
			return preparedStatementEliminar.executeUpdate() == 1;
			
		} catch (SQLException e) {

			 e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Cliente> listar() {
		List<Cliente> clientelist = new ArrayList<>();
		String sql = "select id, nombre, direccion, ciudad_cliente from clientes";
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = getConexion().prepareStatement(sql);
			}
			
			ResultSet resultSet = preparedStatementListar.executeQuery();
			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getString("id"));
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setDireccion(resultSet.getString("direccion"));
				cliente.setCiudad_cliente(resultSet.getString("ciudad_cliente"));
				
				clientelist.add(cliente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clientelist;
	}

}
