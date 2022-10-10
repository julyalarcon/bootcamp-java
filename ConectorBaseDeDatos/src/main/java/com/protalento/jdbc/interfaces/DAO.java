package com.protalento.jdbc.interfaces;

import java.util.List;

public interface DAO<E, K> {
	
	E buscarPorID(K key);
	
	boolean insertar(E elemento);
	
	//boolean modificar(E elemento);
	//boolean eliminar(E elemento);
	
	List<E> listar();
}
