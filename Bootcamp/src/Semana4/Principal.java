package Semana4;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        System.out.println("**************Bienvenidos a la Torre de Control**************");
        
        do {            
            System.out.println("-------------------------Aterrizajes-------------------------");
            System.out.println("1. Avion");
            System.out.println("2. Helicoptero");
            System.out.println("3. Superman");
            System.out.println("4. Ovni");
            System.out.println("5. Salir");
            System.out.print("Digita la opción que deseas ingresar: ");
            
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    Avion avion = Lectora.leerAvion();  
                    avion.aterrizar();
                    avion.codigoAterrizaje();                 
                    break;
                case 2:
                    Helicoptero helicoptero = Lectora.leerHelicoptero();
                    helicoptero.aterrizar();
                    helicoptero.codigoAterrizaje();
                    break;
                case 3:
                    Superman superman = Lectora.leerSuperman();
                    superman.aterrizar();
                    superman.codigoAterrizaje();
                    break;
                case 4:
                    Ovni ovni = Lectora.leerOvni();
                    ovni.aterrizar();
                    ovni.codigoAterrizaje();
                    break;
                case 5: 
                    salir = true;
                    break;
                default:
                    System.out.println("Opción invalida, por favor ingresa una opción de 1 a 5");
            }
            
        } while (!salir);
        }
}




