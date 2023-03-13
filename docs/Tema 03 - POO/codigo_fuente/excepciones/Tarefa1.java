package excepciones;

import java.io.Console;
import java.util.Arrays;

public class Tarefa1 {
    /*
     * Esta función espera que el array de palabras esté ordenado.
     */
    public static String[] filtrado(String[] palabras, String palabraFiltrado) {
        // Primero contamos las palabras válidas:
        int palabrasValidas = 0;
        for (int i = 0; i < palabras.length; ++i) {
            if (palabras[i].startsWith(palabraFiltrado)) {
                ++palabrasValidas;
            }
        }

        String[] palabrasFiltradas;

        if (palabrasValidas == 0) {
            return null;
        } else {
            palabrasFiltradas = new String[palabrasValidas];

            int idx = 0;
            for (int i = 0; i < palabras.length; ++i) {
                if (palabras[i].startsWith(palabraFiltrado)) {
                    palabrasFiltradas[idx] = palabras[i];
                    ++idx;
                }
            }
            return palabrasFiltradas;
        }
    }

    public static void main(String[] args) {
        Console con = System.console();

        String linea = con.readLine("Introduzca una lista de palabras separadas por \",\": ");

        System.out.println("Leido: \"" + linea + "\"");

        String[] fragmentos = linea.split(", ");

        Arrays.sort(fragmentos);

        System.out.println(Arrays.toString(fragmentos));

        System.out.println("Introduzca una opcion:");
        System.out.println("----------------------");
        System.out.println("(1) Filtrar.");
        System.out.println("(2) Dividir.");
        System.out.println("------------");

        boolean opcionValida = true;
        do {
            String opcion = con.readLine("Opción: ");
            if (opcion.equals("1")) {
                // Código de la opción Filtrar.
                System.out.println("Opción filtrar.");

                String palabraFiltrado = con.readLine("Introduzca la palabra de filtrado: ");
                String[] palabrasFiltradas = filtrado(fragmentos, palabraFiltrado);

                System.out.println("La lista filtrada será:");

                System.out.println(Arrays.toString(palabrasFiltradas));

            } else if (opcion.equals("2")) {
                System.out.println("Opción dividir.");

            } else {
                System.out.println("Opción no válida.");
                opcionValida = false;
            }
        } while (!opcionValida);

    }
}
