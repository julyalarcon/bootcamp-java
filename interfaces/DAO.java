package com.protalento.interfaces;

import java.util.List;

public interface DAO<E, K> {
	
	E buscarPorId(K k);
	
	boolean insertar(E e);
	
	boolean modificar(E e);
	
	boolean eliminar(E e);
	
	List<E> listar();
	
}
