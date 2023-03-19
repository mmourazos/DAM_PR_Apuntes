import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;

public class Alumno {
    private LocalDate fechaNacimiento;
    private String nombre;
    private String apellidos;

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
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

    public int getEdad() {
        LocalDate ahora = LocalDate.now(ZoneId.systemDefault());
        int edad = ahora.getYear() - fechaNacimiento.getYear();
        if (ahora.getMonth().compareTo(fechaNacimiento.getMonth()) > 0) { // Ya pasó el mes de
                                                                          // nuestro cumpleaños.
            ++edad;
        } else if (ahora.getMonth().compareTo(fechaNacimiento.getMonth()) == 0) { // Estamos en el
                                                                                  // mes de nuestro
                                                                                  // cumpleaños.
            if (ahora.getDayOfMonth() >= fechaNacimiento.getDayOfMonth()) { // Ya pasó (o es) el día
                                                                            // de nuestro
                                                                            // cumpleaños.
                ++edad;
            }
        }

        return edad;
    }

    public static Alumno primero(List<Alumno> alumnos, Comparator<Alumno> c) {
        Alumno p = alumnos.get(0);

        for (Alumno a : alumnos) {
            if (c.compare(a, p) < 0)
                p = a;
        }

        return p;
    }

    public static Alumno ultimo(List<Alumno> alumnos, Comparator<Alumno> c) {
        Alumno u = alumnos.get(0);

        for (Alumno a : alumnos) {
            if (c.compare(a, u) > 0)
                u = a;
        }

        return u;
    }

}
