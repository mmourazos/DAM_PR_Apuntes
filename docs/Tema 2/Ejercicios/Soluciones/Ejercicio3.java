import java.io.Console;

public class Ejercicio3 {
    // Creamos un método estático para introducir un número definido de palabras:
    public static String[] leePalabras(int numPalabras) {
        String[] palabras = new String[numPalabras];
        int palabrasLeidas = 0;

        Console con = System.console();

        do {
            System.out.printf("Instroduzca la palabra %d de %d: ", palabrasLeidas + 1, numPalabras);
            String palabra = con.readLine();

            // Comprobamos que la palabra es válida (no es vacía ni blanco)
            if (!palabra.isBlank()) {
                palabras[palabrasLeidas] = palabra;
                palabrasLeidas = palabrasLeidas + 1;
            } else {
                return palabras; // Si introduce una palabra en blanco (o vacía) terminamos.
            }


        } while (palabrasLeidas < numPalabras);

        return palabras;
    }

    // Creamos otro método estático que lista el contenido del un array de cadenas.
    public static void muestraArray(String[] arr) {
        // Comprobamos que el array tiene al menos un elemento.
        if (arr != null && arr.length > 0) {
            // Mostraremos las palabras usando un bucle for:
            for (int idx = 0; idx < arr.length; ++idx) {
                // Comprobaremos que el contenido de esta posición del array no es null:
                if (arr[idx] != null) {
                    System.out.printf("Palabra %d: \"%s\".%n", idx + 1, arr[idx]);
                }
            }
        } else {
            System.out.println("Array sin contenido.");
        }
    }


    public static void main(String[] args) {
        String[] strArr = leePalabras(10);
        muestraArray(strArr);
    }


}
