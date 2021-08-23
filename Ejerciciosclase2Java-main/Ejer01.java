package clase2;

/*
 Programa que pida por teclado la fecha de nacimiento de una persona
(día, mes, año) y calcule su número de la suerte.
El número de la suerte se calcula sumando el día, mes y año de la fecha
de nacimiento y a continuación sumando las cifras obtenidas en la suma
 */

import java.util.Scanner; // importamos una biblioteca que nos permita crear un escaner para "escuchar" el teclado
 public class Ejer01 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in); //Creamosla variable escaner para "escuchar" el teclado, osea los datos que ingresa el usuario
        System.out.print("Digita tu fcha de nacimiento en formato DD/MM/AAAA: "); //Mensaje de salida del sistema que se imprime en la consola
        var fecha = sc.nextLine(); //Esta variable debe esperarse en números decimales
        sc.close(); //Una vez ingresada la información por parte del usuario el escaner se cierra 
        
        var numeroSuerte = CalcularNumeroSuerte(fecha); //Establecemos esta variable como la función que calcula el número de la suerte
        System.out.print("Tu número de la suerte es el: " + numeroSuerte); //mensaje de salida una vez realizados los calculos
    }

    private static int CalcularNumeroSuerte(String fecha) { //Desarrollo de la funcion
        int dia = Integer.parseInt(fecha.substring(0,2)); //Esta variable se analiza como un entero decimal con signo
        int mes = Integer.parseInt(fecha.substring(3,5)); // Esta variable se analiza como un entero decimal con signo
        int anio = Integer.parseInt(fecha.substring(6,10));// Esta variable se analiza como un entero decimal con signo
        int suma = dia + mes + anio; 
        int resultado = 0; // El resultado de la suma de las cifras obtenidas en el calculo sera un numero entero

        while (suma != 0) { //Ciclo while, si la suma es diferente de cero
            resultado += suma%10; //resultado = resultado + suma 
            suma /= 10; //Y este resultado que se dividirá entre 10 al ser expresado en un nunero decimal
        }

        return resultado;
    }    
}
