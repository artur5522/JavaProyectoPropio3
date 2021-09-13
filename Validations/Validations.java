/*
 * ARCHIVO DONDE SE ENCUENTRAN TODAS LAS VALIDACIONES NECESARIAS PARA REALIZAR LAS
ENTRADAS DE DATOS POR PARTE DEL DIRECTOR.
 */
package com.rodrigueza.Validations;

import java.util.*;

/**
 *
 * @author User
 */
public class Validations {

    public static String validaNombre() {
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        //valido que primer nombre y primer apellido no esten vacios
        while (true) {
            nombre = sc.nextLine();
            if (nombre.length() != 0) {
                break;
            } else {
                System.out.println("El nombre no puede estar vacio. Coloquelo nuevamente");
            }
        }
        return nombre.toUpperCase();
    }

    public static long validaNumero() {
        Scanner sc = new Scanner(System.in);
        long codigo = 0;
        //valido que se ingrese un numero, y que ese numero sea de 8 caracteres
        while (true) {
            try {
                codigo = sc.nextLong();
                String codigoString = String.valueOf(codigo);
                if (codigoString.length() < 1 || codigo <= 0) {
                    System.out.println("El codigo no puede estar vacío ni ser menor que cero. Intente nuevamente");
                } else {
                    return codigo;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Ingrese un numero valido");
                sc.next();
            }
        }

    }
}
