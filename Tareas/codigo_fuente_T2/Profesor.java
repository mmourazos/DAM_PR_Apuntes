package docs.Tareas.codigo_fuente_T2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Profesor extends Persona {
    private ArrayList<Modulo> modulos;

    public Profesor(String nombre, String apellidos, int numero, char letra) {
        super(nombre, apellidos, numero, letra);

    }

    public Profesor(String nombre, String apellidos, DNI dni) {
        super(nombre, apellidos, dni);
    }

    public Profesor(String nombre, String apellidos, String dni, LocalDate fechaNacimiento) {
        super(nombre, apellidos, dni, fechaNacimiento);
    }

}
