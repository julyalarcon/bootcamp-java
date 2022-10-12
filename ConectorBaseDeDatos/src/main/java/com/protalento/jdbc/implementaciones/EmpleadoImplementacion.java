package com.protalento.jdbc.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.protalento.entidades.Empleado;
import com.protalento.enumerados.TipoDocumento;
import com.protalento.jdbc.AdministradorDeConexionMariaDB;
import com.protalento.jdbc.interfaces.IEmpleado;
import com.protalento.utilidades.FechasEmpleados;

public class EmpleadoImplementacion implements IEmpleado {

	private static Logger logger = LogManager.getLogger();
	private PreparedStatement preparedStatementBuscarPorID;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementEliminar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementListar;

	private AdministradorDeConexionMariaDB administradorDeConexionMariaDB;

	public EmpleadoImplementacion() {
		administradorDeConexionMariaDB = AdministradorDeConexionMariaDB.getInstancia();
	}

	@Override
	public Empleado buscarPorID(String documento) {

		Empleado empleado = null;
		String sql = "select tipoDocumento, nombre, apellido, edad, fechaNacimiento from empleados where numeroDocumento = ?;";

		try {
			if (null == preparedStatementBuscarPorID) {
				preparedStatementBuscarPorID = administradorDeConexionMariaDB.getConexion().prepareStatement(sql);
			}

			preparedStatementBuscarPorID.setString(1, documento);
			
			ResultSet resultSet = preparedStatementBuscarPorID.executeQuery();

			if (resultSet.next()) {
				empleado = new Empleado();
				empleado.setDocumento(documento);
				empleado.setTipo(TipoDocumento.valueOf(resultSet.getString("tipoDocumento")));				
				empleado.setNombre(resultSet.getString("nombre"));
				empleado.setApellido(resultSet.getString("apellido"));
				empleado.setEdad(resultSet.getInt("edad"));
				empleado.setFechaNacimiento(LocalDate.parse(resultSet.getString("fechaNacimiento"), FechasEmpleados.getDateTimeFormatter(FechasEmpleados.SQL_PATRON_FECHA)));
			}
			
			logger.debug(preparedStatementBuscarPorID);
			logger.info(empleado);

		} catch (SQLException e) {
			logger.error(e);
		}

		return empleado;

	}

	@Override
	public boolean insertar(Empleado empleado) {
		String sql = "insert into empleados (numeroDocumento,tipoDocumento,nombre,apellido,edad,fechaNacimiento) values (?,?,?,?,?,?)";

		try {
			if (null == preparedStatementInsertar) {
				preparedStatementInsertar = administradorDeConexionMariaDB.getConexion().prepareStatement(sql);
			}
			
			preparedStatementInsertar.setString(1, empleado.getDocumento());
			preparedStatementInsertar.setString(2, empleado.getTipo().toString());
			preparedStatementInsertar.setString(3, empleado.getNombre());
			preparedStatementInsertar.setString(4, empleado.getApellido());
			preparedStatementInsertar.setInt(5, empleado.getEdad());
			preparedStatementInsertar.setString(6, empleado.getFechaNacimiento().format(FechasEmpleados.getDateTimeFormatter(FechasEmpleados.SQL_PATRON_FECHA)));
			
			logger.debug(preparedStatementInsertar);
			logger.info(empleado);
			
			return preparedStatementInsertar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			logger.error(e);
		}

		return false;
	}

	@Override
	public boolean modificar(Empleado empleado) {
		String sql = "update empleados set tipoDocumento = ?, nombre = ?, apellido = ?, edad = ?, fechaNacimiento = ? where numeroDocumento = ?;";
		try {
			if (null == preparedStatementModificar) {
				preparedStatementModificar = administradorDeConexionMariaDB.getConexion().prepareStatement(sql);
			}
			preparedStatementModificar.setString(1, empleado.getTipo().toString());
			preparedStatementModificar.setString(2, empleado.getNombre());
			preparedStatementModificar.setString(3, empleado.getApellido());
			preparedStatementModificar.setInt(4, empleado.getEdad());
			preparedStatementModificar.setString(5, empleado.getFechaNacimiento().format(FechasEmpleados.getDateTimeFormatter(FechasEmpleados.SQL_PATRON_FECHA)));
			preparedStatementModificar.setString(6, empleado.getDocumento());

			logger.debug(preparedStatementModificar);
			logger.info(empleado);
			
			return preparedStatementModificar.executeUpdate() == 1;

		} catch (SQLException e) {
			logger.error(e);
		}

		return false;
	}

	@Override
	public boolean eliminar(Empleado empleado) {
		String sql = "delete from empleados where numeroDocumento = ?;";

		try {
			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = administradorDeConexionMariaDB.getConexion().prepareStatement(sql);
			}

			preparedStatementEliminar.setString(1, empleado.getDocumento());
			
			logger.debug(preparedStatementEliminar);
			logger.info(empleado);
			
			return preparedStatementEliminar.executeUpdate() == 1;

		} catch (SQLException e) {
			logger.error(e);
		}
		return false;
	}

	@Override
	public List<Empleado> listar() {
		List<Empleado> empleadosLista = new ArrayList<>();

		String sql = "select numeroDocumento, tipoDocumento, nombre, apellido, edad, fechaNacimiento from empleados;";

		try {
			preparedStatementListar = administradorDeConexionMariaDB.getConexion().prepareStatement(sql);

			/*
			if (null == preparedStatementListar) {
				preparedStatementListar = administradorDeConexionMariaDB.getConexion().prepareStatement(sql);
			}
			*/
			
			ResultSet resultSet = preparedStatementListar.executeQuery();

			while (resultSet.next()) {
				Empleado empleado = new Empleado();
				empleado.setDocumento(resultSet.getString("numeroDocumento"));
				empleado.setTipo(TipoDocumento.valueOf(resultSet.getString("tipoDocumento")));
				//empleado.setDocumento(new Documento(TipoDocumento.valueOf(resultSet.getString("tipoDocumento")), resultSet.getString("numeroDocumento")));
				empleado.setNombre(resultSet.getString("nombre"));
				empleado.setApellido(resultSet.getString("apellido"));
				empleado.setEdad(resultSet.getInt("edad"));
				empleado.setFechaNacimiento(LocalDate.parse(resultSet.getString("fechaNacimiento"), FechasEmpleados.getDateTimeFormatter(FechasEmpleados.SQL_PATRON_FECHA)));
				
				empleadosLista.add(empleado);
			}
			
			logger.debug(preparedStatementListar);
			logger.info(empleadosLista);

		} catch (SQLException e) {
			logger.error(e);
		}

		return empleadosLista;
	}
	
	public boolean guardar(Empleado empleado) {
		Empleado empleadoAux = buscarPorID(empleado.getDocumento());

		if (empleadoAux == null) {
			return insertar(empleado);
		}
		return modificar(empleado);
	}


	public static void main(String[] args) {
		EmpleadoImplementacion empleadoImplementacion = new EmpleadoImplementacion();
	
		Empleado empleado1 = new Empleado();
		empleado1.setDocumento("2005478541");
		empleado1.setTipo(TipoDocumento.CC);
		//empleado1.setDocumento(new Documento(TipoDocumento.RC, "2548796541"));
		empleado1.setNombre("Nadia");
		empleado1.setApellido("Diaz");
		empleado1.setEdad(6);;
		empleado1.setFechaNacimiento(LocalDate.parse("19/01/2016", FechasEmpleados.getDateTimeFormatter(FechasEmpleados.USUARIO_FORMATO)));

		Empleado empleado2 = new Empleado();
		empleado2.setDocumento("457896524MA");
		empleado2.setTipo(TipoDocumento.CE);
		empleado2.setNombre("Romina");
		empleado2.setApellido("Suarez");
		empleado2.setEdad(25);
		empleado2.setFechaNacimiento(LocalDate.parse("22/06/1997", FechasEmpleados.getDateTimeFormatter(FechasEmpleados.USUARIO_FORMATO)));
		
		
		System.out.println(empleado1);
		
		System.out.println("Empleado agregado: " + empleadoImplementacion.insertar(empleado2));
		
		System.out.println("Empleado buscado: " + empleadoImplementacion.buscarPorID(empleado1.getDocumento()));	

		System.out.println("Empleado modificado: " + empleadoImplementacion.modificar(empleado1));
	
		System.out.println("Empleado eliminado: " + empleadoImplementacion.eliminar(empleado1));
		
		for (Empleado empleado : empleadoImplementacion.listar()) {
			System.out.println(empleado);
		}
		
	}

}
