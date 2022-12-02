package docs.Tareas.codigo_fuente_T2;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * La clase Alumno almacerá la información de alumno necesaria para el
 * institutulo.
 */
public class Persona {
    /**
     * El nombre propio del alumno. Incluiremos nombres compuestos.
     */
    String nombre;
    /**
     * Los apellidos del almno.
     */
    String apellidos;
    /**
     * El dni del alumno.
     */
    DNI dni;

    /**
     * La fecha de nacimiento del alumno.
     */
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos, int numero, char letra) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        DNI dni = new DNI(numero, letra);
        if (!dni.esValido()) {
            throw new IllegalArgumentException();
        }

    }

    public Persona(String nombre, String apellidos, DNI dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    public Persona(String nombre, String apellidos, String dni, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = new DNI(dni);
        if (DNI.dniValido(this.dni)) {
            throw new IllegalArgumentException();
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public DNI getDni() {
        return dni;
    }

    public void setDni(DNI dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
