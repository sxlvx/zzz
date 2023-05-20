package com.mycompany.e1p1_salvadormacias;

import java.util.Scanner;

public class E1P1_salvadormacias {

    public static Scanner lea = new Scanner(System.in);
    public static Scanner str = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean salida = true;
        do {
            System.out.println("Bienvenido al menu!");
            System.out.println("Estas son las opciones disponibles: ");
            System.out.println("1.Numero Valido\n2.Reordenado de Cadenas\n3.Trigonometria\n4.Salir");
            System.out.println("Ingrese opcion : ");
            System.out.println("---------------------------------------------------------------------------------------------------");
            int opc = lea.nextInt();
            switch (opc) {
                case 1: {

                    System.out.print("Ingrese el número que desea validar: ");
                    String cadena = lea.next();
                    if (num_valido(cadena)) {
                        System.out.println(cadena + " es un número válido.");
                        System.out.println("-------------------------------------------------------------------------------------");
                    } else {
                        System.out.println(cadena + " no es un número válido.");
                        System.out.println("-------------------------------------------------------------------------------------");
                    }

                }//fin case 1
                break;

                case 2: {
                    System.out.print("Ingrese la cadena que desea reordenar: ");
                    String cadena = lea.next();
                    String reordenada = reordenarCadena(cadena);
                    System.out.println("String reordenado: " + reordenada);
                    System.out.println("-------------------------------------------------------------------------------------");

                }//fin case 2
                break;

                case 3: {
                    double angulo = 0.0;
                    int precision = 0;
                    System.out.println("Ingrese el angulo(grados) que desea calcular: ");
                    angulo = lea.nextDouble();
                    System.out.println("Ingrese la precision deseada: ");
                    precision = lea.nextInt();
                    trigo(angulo, precision);
                    System.out.println("-------------------------------------------------------------------------------------");

                }//fin case 3
                break;
                case 4: {
                    salida = false;
                    System.out.println("Se abandonara el programa,gracias por hacer uso de el");
                    System.out.println("-------------------------------------------------------------------------------------");

                }//fin case 4
                break;

                default:
                    System.out.println("Opcion ingresada no es valida");
                    System.out.println("--------------------------------------------------------------------------------");

            }//fin switch

        } while (salida != false);//fin while 

    }//fin main

    public static boolean num_valido(String cadena) {
        boolean valido = true;
        boolean punto = false;
        int i = 0;
        int j = 0;
        int lenghtcad = cadena.length();

        if (cadena.charAt(0) == '-') {
            i = 1;
            if (cadena.charAt(1) == '-') {
                valido = false;
            }
        }

        if (cadena.charAt(i) == '.') {
            punto = true;
            i++;
        }

        do {

            char caracter = cadena.charAt(i);
            if (caracter == '.') {
                if (punto) {
                    valido = false;
                } else {
                    punto = true;
                }
            } else if (caracter > '9' || caracter < '0') {
                valido = false;
            }
            j++;
        } while (j < lenghtcad);

        if (punto && i == 1) {
            valido = false;
        }

        return valido;

    }//fin num valido

    public static String reordenarCadena(String cadena) {

        String n = "";
        String min = "";
        String may = "";
        String signos = "";
        int i = 0;
        do {
            char b = cadena.charAt(i);
            if (b <= '9' && b >= '0') {
                n += b;
            } else if (b <= 'z' && b >= 'a') {
                min += b;
            } else if (b <= 'Z' && b >= 'A') {
                may += b;
            } else {
                signos += b;
            }
            i++;
        } while (i < cadena.length());
        n += min + may + signos;//concatenacion reordenada

        return n;

    }//fin reordenada

    public static void trigo(Double angulo, int precision) {
        double z = (angulo * Math.PI) / 180;
        double sum = 0.0;
        double num = 0.0;
        double den = 0.0;
        double y = 1.0;
        int c = 1;
        int i = 0;
        do {
            num = (Math.pow(-1, i)) * Math.pow(z, ((2 * i) + 1));
            den = ((2 * i) + 1);
            do {
                y *= c;
                c++;
            } while (c <= den);//fin do while interno
            sum = +(num / y);
            i++;
        } while (i <= precision);//fin do while externo
        System.out.println("sin" + +z + ")" + "= " + sum);
    }//fin trigo 

}//fin clase 
