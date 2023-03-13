import java.io.Console;


public class RecursividadMain {

    public static void recursiva(int n) {
        if (n == 0) {
            System.out.println("Fin");
        } else {
            System.out.println(n);
            recursiva(n - 1);
        }
    }

    public static void main(String[] args) {
        // Imaginemos que en este programa vamos a pedir datos a usario con ciertas restricciones.
        // recursiva(10);
        Console con = System.console();

        String nombre;
        if (args != null && args.length > 0) {
            nombre = args[0];
        } else {
            nombre = con.readLine("Introduzca su nombre: ");
        }

        if (nombre.isBlank()) {
            System.out.println("El nombre no puede estar vacío");
            main(null);
        }

        String primerApell;

        if (args != null && args.length > 1) {
            primerApell = args[1];
        } else {
            primerApell = con.readLine("Introduzca su primer apellido: ");
        }

        if (primerApell.isBlank()) {
            System.out.println("El primer apellido no puede estar vacío");
            main(new String[] {nombre});
        }

        String segundoApp;

        if (args != null && args.length > 2) {
            segundoApp = args[2];
        } else {
            segundoApp = con.readLine("Introduzca su segundo apellido: ");
        }

        String edad = con.readLine("Introduzca su edad: ");

        // Ahora vamos a comprobar que la edad sea válida.
        try {
            int edadInt = Integer.parseInt(edad);
            if (edadInt < 0 || edadInt > 120) {
                System.out.println("La edad debe estar entre 0 y 120");
                main(new String[] {nombre, primerApell, segundoApp});
            }
        } catch (NumberFormatException e) {
            System.out.println("La edad no es válida.");
            System.out.println("Vuelva a introducir la edad.");
            main(new String[] {nombre, primerApell, segundoApp});
        }

        System.out.println("Los datos introducidos son:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Primer apellido: " + primerApell);
        System.out.println("Segundo apellido: " + segundoApp);
        System.out.println("Edad: " + edad);

        String respuesta = con.readLine("Los datos son correctos? (s/n): ");

        if (respuesta.equals("s")) {
            System.out.println("Los datos se han guardado correctamente.");
        } else {
            System.out.println("Vuelva a introducir los datos.");
            main(null);
        }

    }
}
