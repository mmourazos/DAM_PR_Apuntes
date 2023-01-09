import java.util.Scanner;

public class PrimerosPasos {

    public static void main(String[] args) {
        String linea = null;

        // La sentencia try (<recurso>) { // bloque }
        // asegura que el recurso será cerrado (liberado) cuando termine el bloque.
        try (Scanner input = new Scanner(System.in)) {
            linea = input.nextLine();
        }

        System.out.println("Leído el texto: " + linea + ".");

        // Si deseamos convertirlo a un valor entero:
        int value = Integer.parseInt(linea);

        System.out.println("El valor leído es: " + value + ".");
    }
}