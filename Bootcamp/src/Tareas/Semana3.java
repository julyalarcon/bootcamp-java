package Tareas;

import java.util.Scanner;

public class Semana3 {

    public static void main(String[] args) {
        calificaciones();
    }

    public static void calificaciones() {
        int cantidad;
        int i;

        System.out.println("Escuela primaria xyz - Control de notas");
        do {
            System.out.print("Ingresa la cantidad de alumnos: ");
            try {
                cantidad = new Scanner(System.in).nextInt();
                if (cantidad <= 0) {
                    System.out.println("Ingresa por lo menos un (1) alumno");
                }
            } catch (Exception e) {
                System.out.println("Ingresa solo numeros");
                cantidad = 0;
            }
        } while (cantidad <= 0);

        int numero = 1;
        String[][] alumnos = new String[cantidad][2];
        for (i = 0; i < cantidad; i++) {
            System.out.print("Ingresa Nombre del alumno " + numero + ": ");
            alumnos[i][0] = new Scanner(System.in).nextLine();
            System.out.print("Ingresa Apellido del alumno " + numero + ": ");
            alumnos[i][1] = new Scanner(System.in).nextLine();
            numero++;
        }
        int[][] notas = new int[cantidad][8];
        for (i = 0; i <cantidad; i++) {
            do {
                System.out.print("Alumno: " + alumnos[i][0] + " " + alumnos[i][1] + " Ingresa la nota 1: ");
                notas[i][0] = new Scanner(System.in).nextInt();
                try {
                    if (notas[i][0] < 0 || notas[i][0] > 10) {
                        System.out.println("Ingresa una nota valida");
                    } else {
                        System.out.println("Nota ingresada correctamente");
                    }
                } catch (Exception e) {

                }
            } while (notas[i][0] < 0 || notas[i][0] > 10);

            do {
                System.out.print("Alumno: " + alumnos[i][0] + "  " + alumnos[i][1] + " Ingresa la nota 2: ");
                notas[i][1] = new Scanner(System.in).nextInt();
                try {
                    if (notas[i][1] < 0 || notas[i][1] > 10) {
                        System.out.println("Ingresa una nota valida");
                    } else {
                        System.out.println("Nota ingresada correctamente");
                    }
                } catch (Exception e) {
                    System.out.print("Intenta nuevamente");
                }
            } while (notas[i][1] < 0 || notas[i][1] > 10);

            do {
                System.out.print("Alumno: " + alumnos[i][0] + "  " + alumnos[i][1] + " Ingresa la nota 3: ");
                notas[i][2] = new Scanner(System.in).nextInt();
                try {
                    if (notas[i][2] < 0 || notas[i][2] > 10) {
                        System.out.println("Ingresa una nota valida");
                    } else {
                        System.out.println("Nota ingresada correctamente");
                    }
                } catch (Exception e) {
                    System.out.print("Intenta nuevamente");
                }
            } while (notas[i][2] < 0 || notas[i][2] > 10);

            notas[i][3] = (notas[i][0] + notas[i][1] + notas[i][2]) / 3;
        }

        System.out.println("==========================================");
        System.out.println("***********REPORTE CONTROL NOTAS**********");
        System.out.println("==========================================");
        
        System.out.println("*************ALUMNOS APROBADOS************");
        for (i = 0; i <cantidad; i++){
            if (notas[i][3] >= 7 && notas[i][3] <= 10){
                notas [i][4]= 1;
            } if (notas [i][4] == 1){
                System.out.println(" "+alumnos[i][0] + " " + alumnos[i][1] + " Nota 1: " + (notas[i][0]) + " Nota 2: " + (notas[i][1]) + " Nota 3: " + (notas[i][2]) + " Promedio: " + (notas[i][3]));
            }
        }
        
        System.out.println("************ALUMNOS REPROBADOS************");
        for (i = 0; i <cantidad; i++){
            if (notas[i][3] >= 0 && notas[i][3] < 7){
                notas [i][5]= 2;
            } if (notas [i][5] == 2){
                System.out.println(" "+alumnos[i][0] + " " + alumnos[i][1] + " Nota 1: " + (notas[i][0]) + " Nota 2: " + (notas[i][1]) + " Nota 3: " + (notas[i][2]) + " Promedio: " + (notas[i][3]));
            }
        }
        
        System.out.println("**************NOTAS MAS ALTAS*************");
        for (i = 0; i <cantidad; i++){
            if (notas[i][3] >= 8 && notas[i][3] <= 10){
                notas [i][6]= 3;
            } if (notas [i][6] == 3){
                System.out.println(" "+alumnos[i][0] + " " + alumnos[i][1] + " Promedio: " + (notas[i][3]));                
            }
        }
        
        System.out.println("**************NOTAS MAS BAJAS*************");
        for (i = 0; i <cantidad; i++){
            if (notas[i][3] >= 0 && notas[i][3] <= 4){
                notas [i][7]= 4;
            } if (notas [i][7] == 4){
                System.out.println(" "+alumnos[i][0] + " " + alumnos[i][1] + " Promedio: " + (notas[i][3]));                
            }
        }
    }
}



