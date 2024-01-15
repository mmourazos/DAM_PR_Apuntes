import java.io.Console;

public class Ejercicio1 extends Ejercicio {

    @Override
    public void ejecutar() {
        // Declaramos una variable para acceder al objeto consola (i así leer deatos introducidos
        // por el teclado).
        Console con = System.console();

        // Escribimos un texto para indicar al usuario que introduzca una palabra.
        System.out.print("Instroduzca una palabra: ");
        // Declaramos una variable String para que "guarde" la palabra introducida por el usuario.
        String str1 = con.readLine();

        System.out.print("Instroduzca otra palabra: ");
        String str2 = con.readLine();

        // Comprobamos si son iguales con el método "equals" de String.
        if (str1.equals(str2)) {
            System.out.printf("Las palabras \"%s\" y \"%s\" son iguales.%n", str1, str2);
        } else {

            System.out.printf("Las palabras \"%s\" y \"%s\" son distintas.%n", str1, str2);
        }
    }
}
