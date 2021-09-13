package com.rodrigueza.Entities;

import com.rodrigueza.orm.Gestor;
import com.rodrigueza.Validations.Validations;
import java.util.Scanner;

/**
 *
 * @author Elpo
 */
public class NewMain {

    public static void main(String[] args) {

        Gestor gestor = new Gestor();
        gestor.creaSession();
        Computadora compu = creaCompu();
        insertaDatoComputadora(gestor, compu);
        gestor.closeSession();       
        gestor=null;
    }

    public static Computadora creaCompu() {
        Scanner sc = new Scanner(System.in);
        Computadora compu = new Computadora();      
        String decision = null;
        System.out.println("Ingrese los datos de la computadora a persistir:");
        System.out.println("Ingrese el nombre de la marca:");
        decision = Validations.validaNombre();
        compu.setMarca(decision);
        System.out.println("Ingrese el nombre del modelo:");
        decision = Validations.validaNombre();
        compu.setModelo(decision);   
        System.out.println("Introduzca el codigo: ");
        decision = String.valueOf(Validations.validaNumero());      
        compu.setCodigo(decision);       
        System.out.println("Ingrese el/los componentes asociados a esta computadora:");
        while (true) {
            Componente compo = null;
            int cuentaComponentes = 1;
            System.out.println("Ingrese el componente -> " + cuentaComponentes);
            cuentaComponentes++;
            compo = creaComponentes();
            compu.agregaComponentes(compo);
            System.out.println("Desea agregar otro componente? S/N");
            String continuar = sc.nextLine();
            if (continuar.equalsIgnoreCase("n")) {
                System.out.println("Hemos terminado de brindar informacion. \n");
                break;
            } else {
                System.out.println("Continuemos con el siguiente componente..");
            }
        }
        return compu;
    }

    public static Componente creaComponentes() {
        Componente compo = new Componente();
        String decision = "";
        Scanner sc = new Scanner(System.in);       
        System.out.println("Ingrese nombre del componente:");
        decision = Validations.validaNombre();
        compo.setNombre(decision);
        System.out.println("Ingrese numero de serie:");
        decision = String.valueOf(Validations.validaNumero()); 
        compo.setNroSerie(decision);
        return compo;
    }    
    
    public static void insertaDatoComputadora(Gestor gestor, Computadora compu){
        try {
             gestor.guardar(compu);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

}
