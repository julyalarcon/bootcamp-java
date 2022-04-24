package Semana4;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Set;

public class Lectora {
    
    public static Scanner scanner = new Scanner(System.in);
    
    public static Avion leerAvion(){
        Avion avion = new Avion();
        
        System.out.print("Digita el nombre de la aeronave: ");
        avion.setNombre(scanner.nextLine());
        System.out.print("Digita la matricula: ");
        //ovni.setLugarAvistamiento(scanner.nextLine());
        avion.setMatricula(scanner.nextLine());
        System.out.print("Digita el vuelo: ");
        avion.setVuelo(scanner.nextLine());
        System.out.print("Digita la aerolinea: ");
        avion.setAerolinea(scanner.nextLine());
        
        return avion;   
    }
    public static Helicoptero leerHelicoptero(){
        Helicoptero helicoptero = new Helicoptero();
        
        System.out.print("Digita el nombre: ");
        helicoptero.setNombre(scanner.nextLine());
        System.out.print("Digita marca: ");
        helicoptero.setMarca(scanner.nextLine());
        System.out.print("Digita modelo: ");
        helicoptero.setModelo(scanner.nextLine());

        return helicoptero;
    }
    
    public static Superman leerSuperman(){
        Superman superman = new Superman();
       
        System.out.println("Hola "+superman.getNombre()); 

        return superman;
    }
    
    public static Ovni leerOvni(){
        Ovni ovni = new Ovni();
        
        System.out.println("Es un "+ovni.getNombre());
        System.out.print("Nombre exacto donde precisaste el avistamiento: ");
        ovni.setLugarAvistamiento(scanner.nextLine());
        
        return ovni;
    }
}

        
