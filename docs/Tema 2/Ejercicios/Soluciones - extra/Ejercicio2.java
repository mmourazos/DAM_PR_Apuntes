import java.util.Scanner;

public class Ejercicio2 extends Ejercicio {

    @Override
    public void ejecutar() {
        // Este tipo de try cierra automáticamente el recurso cuando finaliza el bloque.
        try (// Creo un objeto Scanner a partir del InputStream System.in para leer valores del
             // teclado.
                Scanner scan = new Scanner(System.in)) {
            System.out.print("Introduzca una palabra: ");
            String str1 = scan.nextLine();

            System.out.print("Introduzca otra palabra: ");
            String str2 = scan.nextLine();

            if (str1.compareTo(str2) > 0) {
                System.out.printf("La cadena \"%s\" irá después de \"%s\".%n", str1, str2);
            } else if (str1.compareTo(str2) < 0) {
                System.out.printf("La cadena \"%s\" irá antes de \"%s\".%n", str1, str2);
            } else {
                System.out.printf("Las cadenas \"%s\" y \"%s\" son idénticas.%n", str1, str2);
            }
        }
    }
}
