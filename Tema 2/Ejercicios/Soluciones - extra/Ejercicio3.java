import java.io.Console;

public class Ejercicio3 extends Ejercicio {

    @Override
    public void ejecutar() {
        String[] strArr = new String[10];
        Console con = System.console();

        for (int idx = 0; idx < strArr.length; ++idx) {
            System.out.print("Introduzca una palabra (ENTER para terminar): ");
            String str = con.readLine();

            if (str.isEmpty()) {
                // Si la cadena es una cadena vacía salgo del bucle con "break".
                break;
            }

            // Guarda la cadena en el array.
            strArr[idx] = str;
        }

        // Muestro el contenido del array usando el bucle for:
        for (int idx = 0; idx < strArr.length; ++idx) {
            if (strArr[idx] != null) {
                System.out.printf("La palabra %d del array es: %s.%n", idx, strArr[idx]);
            }
        }
    }
}
