import java.io.Console;
import java.util.Arrays;

public class Ejercicio5 {

    // Creamos un método estático que ponga en mayúsculas la primera letra de una palabra:
    public static String ponPrimeraMayus(String strIn) {
        // Si la palabra es null o vacía la devolvemos sin más.
        if (strIn != null && strIn.length() > 0) {
            // Obtenemos el primer caracter de la palabra.
            char primerCaracter = strIn.charAt(0);
            // Lo pasamos a mayúsculas:
            primerCaracter = Character.toUpperCase(primerCaracter);

            // Concatenamos el primer caracter ya en mayúsculas con el resto de la palabra:
            return primerCaracter + strIn.substring(1);
        } else {
            return strIn;
        }
    }

    // El código que sigue está copiado del ejericicio 4:
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

    // Creamos un método para que cree una copia del array sin vacíos (pues los vacíos / null nos
    // darán problemas para ordenar).
    public static String[] quitaVacios(String[] arr) {
        // Contamos las posiciones que no sean vacías
        int numElementos = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != null) {
                ++numElementos;
            }


        }

        // Creamos un array de longitud numElementos para guardar los no vacíos.
        String[] arrResult = new String[numElementos];

        int idxResult = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != null) {
                arrResult[idxResult] = arr[i];
                idxResult += 1;
            }
        }

        return arrResult;
    }


    public static void main(String[] args) {
        String[] strArr = leePalabras(10);
        strArr = quitaVacios(strArr);
        Arrays.sort(strArr);

        // Pasamos las palabras del array a mayúsculas (la primer letra).
        for (int idx = 0; idx < strArr.length; idx++) {
            strArr[idx] = ponPrimeraMayus(strArr[idx]);
        }

        muestraArray(strArr);
    }

}
