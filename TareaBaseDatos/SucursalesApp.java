package com.protalento.TareaBaseDatos;

import com.protalento.entidades.Sucursales;
import com.protalento.implementaciones.mariadb.SucursalesImplementacion;

public class SucursalesApp {

	public static void main(String[] args) {
		Sucursales sucursales1;
		Sucursales sucursales2;
		Sucursales sucursales3;
		SucursalesImplementacion sucursalesImplementacion = new SucursalesImplementacion();

		// Buscar
		System.out.println("****************Buscar****************");
		sucursales1 = sucursalesImplementacion.buscarPorId("1BO1");
		System.out.println(sucursales1);
		
		sucursales2 = sucursalesImplementacion.buscarPorId("1CA1");
		System.out.println(sucursales2);
		
		sucursales3 = sucursalesImplementacion.buscarPorId("1ME1");
		System.out.println(sucursales3);
		
		
		// Insertar
		Sucursales sucursales4 = new Sucursales();
		sucursales4.setId("1BA1");
		sucursales4.setNombre("Vista");
		sucursales4.setCiudad("Barranquilla");
		
		System.out.println("");
		System.out.println("****************Insertar****************");
		System.out.println(sucursales4);
		System.out.println(sucursalesImplementacion.insertar(sucursales4));

		
		//Modificar
		System.out.println("");
		System.out.println("****************Modificar****************");
		sucursales2.setNombre("Yucan");
		System.out.println(sucursales2);
		System.out.println(sucursalesImplementacion.modificar(sucursales2));
		
		
		//Eliminar
		System.out.println("");
		System.out.println("****************Eliminar****************");
		System.out.println(sucursales3);
		System.out.println(sucursalesImplementacion.eliminar(sucursales3));
						
		// Listar
		System.out.println("");
		System.out.println("****************Listar****************");
		for (Sucursales sucursalist : sucursalesImplementacion.listar()) {
			System.out.println(sucursalist);
		}
		
		
	}

}
