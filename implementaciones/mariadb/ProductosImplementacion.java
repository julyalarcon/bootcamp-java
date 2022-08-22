package com.protalento.implementaciones.mariadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.protalento.entidades.Productos;
import com.protalento.interfaces.ConexionMariaDB;
import com.protalento.interfaces.DAO;

public class ProductosImplementacion implements DAO<Productos, Long>, ConexionMariaDB {

	private PreparedStatement preparedStatementBuscarPorID;
	private PreparedStatement preparedStatementEliminar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementListar;

	@Override
	public Productos buscarPorId(Long id) {
		Productos productos = null;
		String sql = "select id_cliente, cuenta_ahorros, cuenta_corriente, prestamo, id_empleado from productos where id_producto = ?";
		try {

			if (preparedStatementBuscarPorID == null) {
				preparedStatementBuscarPorID = getConexion().prepareStatement(sql);
			}
			preparedStatementBuscarPorID.setLong(1, id);

			ResultSet resultSet = preparedStatementBuscarPorID.executeQuery();

			if (resultSet.next()) {
				productos = new Productos();
				productos.setId(id);
				productos.setId_cliente(resultSet.getString("id_cliente"));
				productos.setCuentaAhorros(resultSet.getString("cuenta_ahorros"));
				productos.setCuentaCorriente(resultSet.getString("cuenta_corriente"));
				productos.setPrestamos(resultSet.getString("prestamo"));
				productos.setId_empleados(resultSet.getString("id_empleado"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productos;
	}

	@Override
	public boolean insertar(Productos productos) {
		if (productos == null) {
			return false;
		}
		
		String sql = "insert into productos (id_cliente,cuenta_ahorros,cuenta_corriente,prestamo,id_empleado) values (?,?,?,?,?)";
		try {
			if(preparedStatementInsertar == null) {
				preparedStatementInsertar = getConexion().prepareStatement(sql);
			}
			
			preparedStatementInsertar.setString(1, productos.getId_cliente());
			preparedStatementInsertar.setString(2, productos.getCuentaAhorros());
			preparedStatementInsertar.setString(3, productos.getCuentaCorriente());
			preparedStatementInsertar.setString(4, productos.getPrestamos());
			preparedStatementInsertar.setString(5, productos.getId_empleados());

			return preparedStatementInsertar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean modificar(Productos productos) {
		if (productos == null) {
			return false;
		}
		
		String sql = "update productos set cuenta_ahorros = ?, cuenta_corriente = ?, prestamo = ? where id_producto = ? and id_cliente = ? and id_empleado = ?";
		try {
			if (preparedStatementModificar == null) {
				preparedStatementModificar = getConexion().prepareStatement(sql);
			}
			preparedStatementModificar.setString(1, productos.getCuentaAhorros());
			preparedStatementModificar.setString(2, productos.getCuentaCorriente());
			preparedStatementModificar.setString(3, productos.getPrestamos());
			preparedStatementModificar.setLong(4, productos.getId());
			preparedStatementModificar.setString(5, productos.getId_cliente());
			preparedStatementModificar.setString(6, productos.getId_empleados());



			
			return preparedStatementModificar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean eliminar(Productos productos) {
		if (productos == null) {
			return false;
		}
		
		String sql = "delete from productos where id_producto = ?";
		try {
			if(preparedStatementEliminar == null) {
				preparedStatementEliminar = getConexion().prepareStatement(sql);
			}
			preparedStatementEliminar.setLong(1, productos.getId());
			
			return preparedStatementEliminar.executeUpdate() == 1;
			
		} catch (SQLException e) {

			 e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Productos> listar() {
		List<Productos> productoslist = new ArrayList<>();
		String sql = "select id_producto, id_cliente,cuenta_ahorros,cuenta_corriente,prestamo,id_empleado from productos";
		
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = getConexion().prepareStatement(sql);
			}
			
			ResultSet resultSet = preparedStatementListar.executeQuery();
			
			while (resultSet.next()) {
				Productos producto = new Productos();
				producto.setId(resultSet.getLong("id_producto"));
				producto.setId_cliente(resultSet.getString("id_cliente"));
				producto.setCuentaAhorros(resultSet.getString("cuenta_ahorros"));
				producto.setCuentaCorriente(resultSet.getString("cuenta_corriente"));
				producto.setPrestamos(resultSet.getString("prestamo"));
				producto.setId_empleados(resultSet.getString("id_empleado"));
					
				productoslist.add(producto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productoslist;
	}

}
