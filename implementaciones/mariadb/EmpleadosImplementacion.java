package com.protalento.implementaciones.mariadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.protalento.entidades.Empleados;
import com.protalento.interfaces.ConexionMariaDB;
import com.protalento.interfaces.DAO;
import com.protalento.utilidades.Fechas;

public class EmpleadosImplementacion implements DAO<Empleados, String>, ConexionMariaDB{

	private PreparedStatement preparedStatementBuscarPorID;
	private PreparedStatement preparedStatementEliminar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementListar;
	
	@Override
	public Empleados buscarPorId(String id_empleado) {
		Empleados empleados = null;

		String sql = "select empleado, telefono, jefe, id_jefe, id_sucursal, fecha_incorporacion from empleados where id_empleado = ?";
		
		try {
			if (preparedStatementBuscarPorID == null) {
				preparedStatementBuscarPorID = getConexion().prepareStatement(sql);
			}
			preparedStatementBuscarPorID.setString(1, id_empleado);
			
			ResultSet resultSet = preparedStatementBuscarPorID.executeQuery();
			
			if(resultSet.next()) {
				empleados = new Empleados();
				empleados.setId_empleado(id_empleado);
				empleados.setEmpleado(resultSet.getString("empleado"));
				empleados.setTelefono(resultSet.getString("telefono"));
				empleados.setJefe(resultSet.getString("jefe"));;
				empleados.setId_jefe(resultSet.getString("id_jefe"));
				empleados.setId_sucursal(resultSet.getString("id_sucursal"));;
				empleados.setFecha_incorporacion(LocalDate.parse(resultSet.getDate("fecha_incorporacion").toString(), Fechas.getDateTimeFormatter(Fechas.getFormatoFechaUsa())));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return empleados;
	}

	@Override
	public boolean insertar(Empleados empleados) {
		if(empleados == null) {
			return false;
		}
		
		String sql = "insert into empleados (id_empleado,empleado,telefono,jefe,id_jefe,id_sucursal,fecha_incorporacion) values (?,?,?,?,?,?,?)";
		
		try {
			if(preparedStatementInsertar == null) {
				preparedStatementInsertar = getConexion().prepareStatement(sql);
			}
			
			preparedStatementInsertar.setString(1, empleados.getId_empleado());
			preparedStatementInsertar.setString(2, empleados.getEmpleado());
			preparedStatementInsertar.setString(3, empleados.getTelefono());
			preparedStatementInsertar.setString(4, empleados.getJefe());
			preparedStatementInsertar.setString(5, empleados.getId_jefe());
			preparedStatementInsertar.setString(6, empleados.getId_sucursal());
			preparedStatementInsertar.setString(7, empleados.getFecha_incorporacion().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			
			return preparedStatementInsertar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean modificar(Empleados empleados) {
		if(empleados == null) {
			return false;
		}
		
		String sql = "update empleados set telefono = ?, jefe = ?, id_jefe = ?, id_sucursal = ? where id_empleado = ? and empleado = ? and fecha_incorporacion = ?";
		try {
			if (preparedStatementModificar == null) {
				preparedStatementModificar = getConexion().prepareStatement(sql);
			}
			preparedStatementModificar.setString(1, empleados.getTelefono());
			preparedStatementModificar.setString(2, empleados.getJefe());
			preparedStatementModificar.setString(3, empleados.getId_jefe());
			preparedStatementModificar.setString(4, empleados.getId_sucursal());
			preparedStatementModificar.setString(5, empleados.getId_empleado());
			preparedStatementModificar.setString(6, empleados.getEmpleado());
			preparedStatementModificar.setString(7, empleados.getFecha_incorporacion().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

			return preparedStatementModificar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean eliminar(Empleados empleados) {
		if (empleados == null) {
			return false;
		}
		
		String sql = "delete from empleados where id_empleado = ?";
		try {
			if(preparedStatementEliminar == null) {
				preparedStatementEliminar = getConexion().prepareStatement(sql);
			}
			preparedStatementEliminar.setString(1, empleados.getId_empleado());
			
			return preparedStatementEliminar.executeUpdate() == 1;
			
		} catch (SQLException e) {

			 e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Empleados> listar() {
		List<Empleados> empleadolist = new ArrayList<>();
		String sql = "select id_empleado, empleado, telefono, jefe, id_jefe, id_sucursal, fecha_incorporacion from empleados";
		
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = getConexion().prepareStatement(sql);
			}
			
			ResultSet resultSet = preparedStatementListar.executeQuery();
			while (resultSet.next()) {
				Empleados empleado = new Empleados();
				empleado.setId_empleado(resultSet.getString("id_empleado"));
				empleado.setEmpleado(resultSet.getString("empleado"));
				empleado.setTelefono(resultSet.getString("telefono"));
				empleado.setJefe(resultSet.getString("jefe"));
				empleado.setId_jefe(resultSet.getString("id_jefe"));
				empleado.setId_sucursal(resultSet.getString("id_sucursal"));
				empleado.setFecha_incorporacion(LocalDate.parse(resultSet.getDate("fecha_incorporacion").toString(), Fechas.getDateTimeFormatter(Fechas.getFormatoFechaUsa())));
				
				empleadolist.add(empleado);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleadolist;
	}

}
