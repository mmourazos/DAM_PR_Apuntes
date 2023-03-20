import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        // Para permitir que el usuario introduzca datos podemos usar Scanner o Console. En este
        // caso usaremos Scanner para variar.
        try (Scanner sc = new Scanner(System.in)) { // Escribiendo este código el Scanner se cerrará
                                                    // automáticamente cuando ya no sea neceario.

            // Le pedimos al usuario la primera palabra:

            System.out.print("Introduzca una palabra: ");
            String palabra1 = sc.nextLine();

            System.out.print("Introduzca otra palabra: ");
            String palabra2 = sc.nextLine();


            // Coparamos ahora las palabras para determinar cual es menor:
            if (palabra1.compareTo(palabra2) > 0) { // Si devuelve mayor que cero es que palabra1 es
                // mayor que palabra2.
                System.out.printf("La palabra %s es mayor que %s.%n", palabra1, palabra2);
            } else if (palabra1.compareTo(palabra2) < 0) { // Comprobamos ahora si es menor.
                System.out.printf("La palabra %s es menor que %s.%n", palabra1, palabra2);
            } else { // Si no es mayor ni menor, es que son iugales.
                System.out.printf("Las palabras %s y %s son iguales.%n", palabra1, palabra2);
            }
        } // Cuando lleguemos a aquí se cerrará el escanner automáticamente.
    }
}
