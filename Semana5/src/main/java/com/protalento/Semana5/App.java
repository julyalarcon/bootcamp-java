package com.protalento.Semana5;

import java.util.Scanner;

import com.protalento.entidades.CollectionCustom;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
	
	CollectionCustom coleccion = new CollectionCustom();
	Scanner scanner = new Scanner(System.in);
    boolean salir = false;
    int opcion;

    System.out.println("**************Bienvenido a Comfootball**************");
    
    do {            
        System.out.println("-------------------------Jugadores-------------------------");
        System.out.println("1. Agrega un jugador");
        System.out.println("2. Agrega un jugador en primera posición ");
        System.out.println("3. Agrega un jugador en última posición");
        System.out.println("4. Valida si el array esta vacio ");
        System.out.println("5. Conoce el tamaño del array");
        System.out.println("6. Lista de clientes ");
        System.out.println("7. Salir");
        System.out.print("Digita la opción que deseas ingresar: ");
        
        
        opcion = scanner.nextInt();
        
        switch (opcion) {
            case 1:
            	coleccion.agregarJugador();
    			System.out.println("Agregaste un jugador");                 
                break;
            case 2:
            	coleccion.addFirst();
    			System.out.println("Agregaste un jugador");
                break;
            case 3:
            	coleccion.addLast();
    			System.out.println("Agregaste un jugador");
                break;
            case 4:
            	if (coleccion.vacio()) {
    				System.out.println("Esta vacio");
    			}else {
    				System.out.println("Hay elementos");
    			}
                break;
            case 5:
            	coleccion.sizeArray();
            	System.out.println("Hay "+coleccion.sizeArray()+" Jugadores");
            	break;
            case 6: 
            	System.out.println("Lista de jugadores: ");
            	coleccion.obtenerJugadores();
            	break;
            case 7:
                salir = true;
                System.out.println("***Comfootball*** Gracias por visitarnos, vuelve pronto!!!");
                break;
            default:
                System.out.println("Opción invalida, por favor ingresa una opción de 1 a 6");
        }
        
    } while (!salir);
}
}
	

	
		