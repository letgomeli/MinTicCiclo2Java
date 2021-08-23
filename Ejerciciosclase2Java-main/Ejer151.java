package clase2;
/*
Leer un número N y calcular la suma de los factoriales de los números desde 0 hasta N.
 */
import java.util.Scanner; //importo una libreria que me permita crear un scanner
public class Ejer151 {
    public static void main(String[] args) { //Creo un metodo main para la class Ejer151
        var sc = new Scanner(System.in); //Creo la variable scanner que me permite "escuchar al usuario" en el teclado
        System.out.print("Digita N: "); //creo una salida del sistema que imprima "Digita N:"
        var numero = sc.nextInt(); //Creo una variable que reciba la información digitada
        sc.close(); //Una vez ejecutadas las tareas anterioroes, cierro el scanner
        double suma = 0; //Inicializo una variable en cero que me permita sumar los factoriales solicitados arriba, la cual es de un tipo dobel es decir que me permite 2 digitos o un número con como decimal
        for (int i = 0; i <= numero; i++) {//Como el enunciado lo indica se requiere la suma de los factoriales de 0 a N por lo tanto se crea un ciclo for que incremente el valor en la suma de cada factorial, hasta que el resultado de esa suma representada en numero llevada a cabo por medio de la varialble i en el incremento señalado
            suma += Factorial(i); //suma = suma + factorial(i) la cual es una codición de la variable en este punto en el que termina el ciclo for
        }
        System.out.format("(CICLO FOR) La suma de los factoriales de los números desde 0 hasta %d es %.0f", numero, suma); //imprime el mensaje en consola con el numero ingresado y el total de la suma del rango marcado por el inicio en 0 y terminado en dicho numero

    }

    private static int Factorial(int n) {//creo un método que me permita trabajar el factorial de tipo entero en la variable n
        var fact = 1; //creo una variable que defina el factorial iniciado en 1
        if (n==0) return fact;//creo un condicional si n es identico a cero retorno factorial
        
        for (int i = 1; i <= n; i++) {//creo un ciclo for con la variable i de tipo entero iniciado en 1, donde mientras i sea menor o igual a n i se incrementa en uno asi mismo por cada ciclo
            fact *= i;//fac = fact * i
        }
        return fact;//retorno fact 
        
// factorial
// adjetivo
// 1.
// MATEMÁTICAS
// De los factores.
// "descomposición factorial"
// 2.
// nombre masculino
// MATEMÁTICAS
// Cantidad que resulta de la multiplicación de determinado número natural por todos los números naturales que le anteceden excluyendo el cero; se representa por n!
// "el factorial de 4 es 24 (producto de 4 x 3 x 2 x 1)"
    }

}
