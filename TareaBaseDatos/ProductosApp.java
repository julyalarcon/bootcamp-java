package com.protalento.TareaBaseDatos;

import com.protalento.entidades.Productos;
import com.protalento.implementaciones.mariadb.ProductosImplementacion;

public class ProductosApp {
	public static void main(String[] args) {
		Productos productos1;
		Productos productos2;
		Productos productos3;
		ProductosImplementacion productosImplementacion = new ProductosImplementacion();
		
		// Buscar
		System.out.println("****************Buscar****************");
		productos1 = productosImplementacion.buscarPorId(1L);
		System.out.println(productos1);

		productos2 = productosImplementacion.buscarPorId(2L);
		System.out.println(productos2);

		productos3 = productosImplementacion.buscarPorId(3L);
		System.out.println(productos3);

		// Insertar
		Productos productos4 = new Productos();
		productos4.setId_cliente("56784987");
		productos4.setCuentaAhorros("756432892");
		productos4.setCuentaCorriente("982121334");
		productos4.setPrestamos("2000000");
		productos4.setId_empleados("742636");
		
		System.out.println("");
		System.out.println("****************Insertar****************");
		System.out.println(productos4);
		System.out.println(productosImplementacion.insertar(productos4));
	
		// Modificar
		System.out.println("");
		System.out.println("****************Modificar****************");
		productos2.setCuentaAhorros("366544766");
		productos2.setCuentaCorriente("987600889");
		productos2.setPrestamos("2500000");
		System.out.println(productos2);
		System.out.println(productosImplementacion.modificar(productos2));

		// Eliminar
		System.out.println("");
		System.out.println("****************Eliminar****************");
		System.out.println(productos3);
		System.out.println(productosImplementacion.eliminar(productos3));
		
		// Listar
		System.out.println("");
		System.out.println("****************Listar****************");
		for (Productos productoslist : productosImplementacion.listar()) {
			System.out.println(productoslist);
		}
	}
}
