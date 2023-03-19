import java.io.Console;
import java.util.Arrays;

public class Ejercicio5 extends Ejercicio {
    final int DISNANCIA_MAYUS = 'a' - 'A';

    // Podemos crear un método que pasa la primera letra de una cadena a mayúsculas.
    private String ponPrimeraLMayuscula(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    @Override
    public void ejecutar() {
        Console con = System.console();
        // Declaro una constante MAX_SIZE como el tamaño máximo del array.
        final int MAX_SIZE = 10;
        String[] strArr = new String[MAX_SIZE];

        // Esta variable indicará si hemos de continuar repitiendo el bucle
        boolean continuar = true;
        // Esta variable indicará en qué posición del array (0 a 9) estamos.
        int posicion = 0;

        do {
            System.out.print("Introduzca una palabra (sólo ENTER para terminar): ");
            String str = con.readLine();

            if (str.isEmpty()) {
                continuar = false;
            } else {
                strArr[posicion] = str;
                ++posicion;
            }

            if (posicion == 10) {
                continuar = false;
            }

        } while (continuar);

        /*
         * Ordenar el array. Para usar "Arrays.sort()" necesito que todos los elementos del array
         * sean String. Si he introducido menos de 10, los restantes elementos serán null y no
         * valdría. Para evitar esto CREO un nuevo array tomando sólo las casillas de la 0 hasta
         * posición. Posición indicará la posición SIGUIENTE a la última que hemos escrito en el
         * array (pues sumamos 1 justo después de escribirla).
         */
        String[] subArr = Arrays.copyOfRange(strArr, 0, posicion);

        // Antes de nada poner el mayúsculas cada palabra:
        for (int idx = 0; idx < subArr.length; ++idx) {
            subArr[idx] = ponPrimeraLMayuscula(subArr[idx]);

        }

        // Ahora podremos ordenar el array sin problemas:
        Arrays.sort(subArr);

        // Para mostrarlo usarmos un bucle for-each:
        posicion = 1;
        for (String str : subArr) {
            System.out.printf("La palabra en la posición %d es \"%s\"%n.", posicion, str);
            ++posicion;
        }
    }
}
