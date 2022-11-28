package docs.Tareas.codigo_fuente_T2;

import java.io.Console;

public class Main {

    public static void main(String[] args) {
        Console c = System.console();

        boolean repetir;
        do {
            repetir = false;

            String strDni = c.readLine("Introduce un dni: ");
            String strLetra = strDni.substring(strDni.length() - 1, strDni.length());
            String strNumero = strDni.substring(0, strDni.length() - 1);
            int numero = Integer.parseInt(strNumero);

            char letra = strLetra.charAt(0);

            System.out.println("El número es:" + numero);
            System.out.println("La letra es: " + letra);
            try {
                // DNI dni = new DNI(numero, letra);

            } catch (IllegalArgumentException e) {
                System.out.println("El dni introducido no es válido.\nVuelva a intentarlo.");
                repetir = true;

            } catch (Exception e) {

            }
        } while (repetir);
    }
}
