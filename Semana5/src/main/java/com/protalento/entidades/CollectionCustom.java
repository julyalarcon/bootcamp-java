package com.protalento.entidades;

import java.util.Scanner;

public class CollectionCustom {
	
	Jugador jugador = new Jugador();
	Jugador[] jugadores = new Jugador[1];
	Scanner entrada = new Scanner (System.in);
	
	
	public int sizeArray() {
		return jugadores.length;
	}
	
	public void obtenerJugadores() {
		try {
			for(int i = 0; i < jugadores.length; i++) {
				System.out.println((i+1) + jugadores[i].toString());
			}
		}catch (Exception e) {
			System.out.println("La lista de jugadores esta vacía");
		}
	}
	
	public void guardarJugador() {
		System.out.println("Ingresa los datos de los jugadores separados por - ");
		System.out.println("Nombre-Apellido-Dorsal-Equipo");
		String ingresoDatos = entrada.nextLine();
		String[] datos = ingresoDatos.split("-");
		jugador.setNombre(datos[0]);
		jugador.setApellido(datos[1]);
		jugador.setDorsal(datos[2]);
		jugador.setEquipo(datos[3]);
	}
	
	public void agregarJugador() {
		guardarJugador();
		jugador = new Jugador(jugador.getNombre(), jugador.getApellido(), jugador.getDorsal(), jugador.getEquipo());
		if(jugadores[0] == null) {
			jugadores[0] = jugador;
		}else {
			Jugador[] jugadoresAdicional = new Jugador[jugadores.length + 1];
			jugadoresAdicional[jugadoresAdicional.length -1] = jugador;
			for (int i = 0; i < jugadores.length; i++) {
				jugadoresAdicional[i] = jugadores[i];
			}
			jugadores = jugadoresAdicional;
		}
	}
	
	public void addFirst() {
		if(jugadores[0] == null) {
			jugadores[0] = jugador;
		}else {
			Jugador[] primerPosicion = new Jugador[jugadores.length + 1];
				primerPosicion[0] = jugador;
				for (int i = 0; i < jugadores.length; i++) {
					primerPosicion[i] = jugadores[i];
				}
		}
	}
	
	public void addLast() {
		jugadores = new Jugador[1];
		System.out.println("");
	}
	
	
	public boolean vacio() {
		return jugadores.length == 0;
	}
	
	public boolean remove() {
		return false;
	}
	
	
}
	
	
	
	
	
	