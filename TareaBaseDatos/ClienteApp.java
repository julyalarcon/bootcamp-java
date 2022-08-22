package com.protalento.TareaBaseDatos;

import com.protalento.entidades.Cliente;
import com.protalento.implementaciones.mariadb.ClienteImplementacion;

public class ClienteApp {
	public static void main(String[] args) {
		Cliente cliente1;
		Cliente cliente2;
		Cliente cliente3;
		ClienteImplementacion clienteImplementacion = new ClienteImplementacion();

		// Buscar
		System.out.println("****************Buscar****************");
		cliente1 = clienteImplementacion.buscarPorId("23123453");
		System.out.println(cliente1);

		cliente2 = clienteImplementacion.buscarPorId("23456789");
		System.out.println(cliente2);

		cliente3 = clienteImplementacion.buscarPorId("23456769");
		System.out.println(cliente3);
		
		// Insertar
		Cliente cliente4 = new Cliente();
		cliente4.setId("78654388");
		cliente4.setNombre("Paola Cardenas");
		cliente4.setDireccion("Calle 80#12-65");
		cliente4.setCiudad_cliente("Medellin");
		
		System.out.println("");
		System.out.println("****************Insertar****************");
		System.out.println(cliente4);
		System.out.println(clienteImplementacion.insertar(cliente4));
		//System.out.println(clienteImplementacion.insertar(new Cliente("103243565", "Kany Garcia", "Calle 132#23-45", "Neiva")));

		// Modificar
		System.out.println("");
		System.out.println("****************Modificar****************");
		cliente2.setDireccion("Calle 32#98-15");
		cliente2.setCiudad_cliente("Tunja");
		System.out.println(cliente2);
		System.out.println(clienteImplementacion.modificar(cliente2));

		// Eliminar
		System.out.println("");
		System.out.println("****************Eliminar****************");
		System.out.println(cliente3);
		System.out.println(clienteImplementacion.eliminar(cliente3));
		
		// Listar
		System.out.println("");
		System.out.println("****************Listar****************");
		for (Cliente clientelist : clienteImplementacion.listar()) {
			System.out.println(clientelist);
		}

	}
}
