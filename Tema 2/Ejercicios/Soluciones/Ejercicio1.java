import java.io.Console;

/**
 * Ejercicio1
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        // Para permitir que el usuario introduzca datos podemos usar Scanner o Console. En este
        // caso usaremos Console pues es más simple.
        Console con = System.console();

        // Le pedimos al usuario la primera palabra:
        System.out.print("Introduzca una palabra: ");
        String palabra1 = con.readLine();

        System.out.print("Introduzca otra palabra: ");
        String palabra2 = con.readLine();

        if (palabra1.equals(palabra2)) {
            System.out.println("Las palabras son iguales.");
        } else {
            System.out.printf("Las palabras %s y %s son distintas.%n", palabra1, palabra2);
        }
    }
}
