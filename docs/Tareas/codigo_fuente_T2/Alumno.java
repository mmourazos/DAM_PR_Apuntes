package docs.Tareas.codigo_fuente_T2;

/**
 * La clase Alumno almacerá la información de alumno necesaria para el
 * institutulo.
 */
public class Alumno {
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

    public Alumno(String nombre, String apellidos, int numero, char letra) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        DNI dni = new DNI(numero, letra);
        if (!dni.esValido()) {
            throw new IllegalArgumentException();
        }

    }

    public Alumno(String nombre, String apellidos, DNI dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

}
