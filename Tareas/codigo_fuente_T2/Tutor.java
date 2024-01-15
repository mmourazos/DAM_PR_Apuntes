package docs.Tareas.codigo_fuente_T2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tutor extends Profesor {
    public Tutor(String nombre, String apellidos, int numero, char letra, Ciclo ciclo) {
        super(nombre, apellidos, numero, letra);
        this.ciclo = ciclo;
    }

    public Tutor(String nombre, String apellidos, String dni, LocalDate fechaNacimiento, Ciclo ciclo) {
        super(nombre, apellidos, dni, fechaNacimiento);
        this.ciclo = ciclo;
    }

    private Ciclo ciclo;

    public ArrayList<Alumno> tutorandos() {
        return null;
    }
}
