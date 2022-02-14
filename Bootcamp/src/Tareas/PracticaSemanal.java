package Tareas;

import java.util.Scanner;

public class PracticaSemanal {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("¡Bienvenido al validador de fechas!");
        System.out.print("Ingresa un día: ");
        int dia = entrada.nextInt();
        System.out.print("Ingresa un mes: ");
        int mes = entrada.nextInt();
        System.out.print("Ingresa un año: ");
        int anio = entrada.nextInt();

        if (anio >= 1900 && anio <= 2099) {
            if ((anio % 4 == 0) && (anio % 100 != 0 || anio % 400 == 0)) {
                if (mes >= 1 && mes <= 12) {
                    if (mes == 2) {
                        if (dia >= 1 && dia <= 29) {
                            System.out.println("Fecha ingresada correctamente: " + dia + "/" + mes + "/" + anio);
                            System.out.println(anio + " es un año bisiesto");
                        } else {
                            System.out.println("Fecha invalida. Los dias de febrero en año bisiesto van de 1 a 29");
                        }
                    } else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                        if (dia >= 1 && dia <= 31) {
                            System.out.println("Fecha ingresada correctamente: " + dia + "/" + mes + "/" + anio);
                        } else {
                            System.out.println("Fecha invalida. El día no puede ser menor a 1 ni mayor a 31 para el mes: " + mes);
                        }
                    } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                        if (dia >= 1 && dia <= 30) {
                            System.out.println("Fecha ingresada: " + dia + "/" + mes + "/" + anio);
                        } else {
                            System.out.println("Fecha invalida. El dia no puede ser menor a 1 ni mayor a 30 para el mes: " + mes);
                        }
                    }
                } else {
                    System.out.println("Fecha invalida. Los meses del año van de 1 a 12");
                }
            } else if ((anio % 4 != 0) && (anio % 100 == 0 || anio % 400 != 0)) {
                if (mes >= 1 && mes <= 12) {
                    if (mes == 2) {
                        if (dia >= 1 && dia <= 28) {
                            System.out.println("Fecha ingresada correctamente: " + dia + "/" + mes + "/" + anio);
                            System.out.println(anio + " no es un año bisiesto");
                        } else {
                            System.out.println("Fecha invalida. No es un año bisiesto, los dias de febrero van de 1 a 28");
                        }
                    } else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                        if (dia >= 1 && dia <= 31) {
                            System.out.println("Fecha ingresada correctamente: " + dia + "/" + mes + "/" + anio);
                        } else {
                            System.out.println("Fecha invalida. El día no puede ser menor a 1 ni mayor a 31 para el mes: " + mes);
                        }
                    } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                        if (dia >= 1 && dia <= 30) {
                            System.out.println("Fecha ingresada: " + dia + "/" + mes + "/" + anio);
                        } else {
                            System.out.println("Fecha invalida. El dia no puede ser menor a 1 ni mayor a 30 para el mes: " + mes);
                        }
                    }
                } else {
                    System.out.println("Fecha invalida. Los meses del año van de 1 a 12");
                }
            }
        } else {
            System.out.println("Fecha invalida. Los años para el programa de validacion van de 1900 a 2099");

        }
    }
}
    
      
