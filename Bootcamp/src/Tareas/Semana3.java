package Tareas;

import java.util.ArrayList;
import java.util.Scanner;

public class Semana3 {
    
    public static void main(String[] args) {
        calificaciones();
    }
    
    public static void calificaciones(){
        int cantidad;

        System.out.println("Escuela primaria xyz - Control de notas");
        do { 
            System.out.print("Ingresa la cantidad de alumnos: ");
            try {
                cantidad = new Scanner(System.in).nextInt();
                if(cantidad<=0){
                    System.out.println("Ingresa por lo menos un (1) alumno");
                }
            } catch (Exception e) {
                System.out.println("Ingresa solo numeros");
                cantidad=0;
            }
        } while (cantidad<=0);

        int numero=1;
        int n =1 ;
        String[][] alumnos = new String[cantidad][cantidad];
        for(int i=0; i<cantidad; i++){
            for(int j=0; j<n; j++){
                System.out.print("Ingresa Nombre del alumno "+numero+": ");
                alumnos[i][j]= new Scanner(System.in).nextLine();
                System.out.print("Ingresa Apellido del alumno "+numero+": ");
                alumnos[i][j]= new Scanner(System.in).nextLine();
                numero++;
            } 
        }

        int[][] notas = new int[cantidad][4];
        for(int i=0; i<cantidad; i++){
            for(int j=0; j<n; j++){
                do {   
                    System.out.print("Ingresa la nota 1 del alumno "+alumnos[i][j]+": ");
                    notas[i][0]= new Scanner(System.in).nextInt();
                    try {
                        if (notas[i][0] <0 || notas[i][0] >10) {
                        System.out.println("Ingresa una nota valida");  
                        }else{
                            System.out.println("Nota ingresada correctamente");
                        } 
                    } catch (Exception e) {

                    }  
                } while (notas[i][0] <0 || notas[i][0] >10);
                
                do {   
                    System.out.print("Ingresa la nota 2 del alumno "+alumnos[i][j]+": ");
                    notas[i][1]= new Scanner(System.in).nextInt();
                    try {
                        if (notas[i][1] <0 || notas[i][1] >10) {
                        System.out.println("Ingresa una nota valida");  
                        }else{
                            System.out.println("Nota ingresada correctamente");
                        } 
                    } catch (Exception e) {
                        System.out.print("Intenta nuevamente");
                    }  
                } while (notas[i][1] <0 || notas[i][1] >10);
                
                do {   
                    System.out.print("Ingresa la nota 3 del alumno "+alumnos[i][j]+": ");
                    notas[i][2]= new Scanner(System.in).nextInt();
                    try {
                        if (notas[i][2] <0 || notas[i][2] >10) {
                        System.out.println("Ingresa una nota valida");  
                        }else{
                            System.out.println("Nota ingresada correctamente");
                        } 
                    } catch (Exception e) {
                        System.out.print("Intenta nuevamente");
                    }  
                } while (notas[i][2] <0 || notas[i][2] >10);

                notas[i][3]=(notas[i][0]+notas[i][1]+notas[i][2])/3;
            }
        }

        for(int i=0; i<cantidad;i++){
            for(int j=0; j<n; j++){
                System.out.println("************REPORTE CONTROL NOTAS ALUMNOS************");
                System.out.println("Alumno "+alumnos[i][j]+" Nota 1: "+(notas[i][0])+" Nota 2: "+(notas[i][1])+" Nota 3: "+(notas[i][2])+" Promedio: "+(notas[i][3]));
                if (notas[i][3] >=7 && notas[i][3]<=10){
                    System.out.println("ALUMOS APROBADOS: "+(alumnos[i][j])+" Promedio: "+notas[i][3]);
                }else if(notas[i][3] >=0 && notas[i][3]<7 ){
                    System.out.println("ALUMNOS REPROBADOS: "+alumnos[i][j]+" Promedio: "+notas[i][3]);  
                }
            }
        }

        for (int i=0; i<cantidad; i++){
            for (int j=0; j<n; j++){
                if (notas[i][3] >=8 && notas[i][3]<=10){
                    System.out.println("************CALIFICACIONES MAS ALTAS************");
                    System.out.println("Alumnos con calificación mas alta: "+alumnos[i][j]+" Promedio: "+notas[i][3]);
                }else if (notas[i][3] >=0 && notas[i][3]<=4){
                    System.out.println("************CALIFICACIONES MAS BAJAS************");
                    System.out.println("Alumnos con calificación mas baja: "+alumnos[i][j]+" Promedio: "+notas[i][3]);
                }
            }          
        }
    }
}