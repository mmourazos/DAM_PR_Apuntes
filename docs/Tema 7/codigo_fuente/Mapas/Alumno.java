import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Alumno {
    private String nombre;
    private String dni;
    private LocalDate fechaNacimiento;

    public Alumno(String nombre, String dni, String fechaNacimiento) {
        // Definimos un patrón para "leer" la fecha de nacimineto como día-mes-año: "dd-MM-yyyy".
        // Creamos un DateTimeFormatter que nos permita convertir textos del tipo "30-05-2020" a
        // su DateTime correspondiente usando dicho patrón.
        this(nombre, dni,
                LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

    public Alumno(String nombre, String dni, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        LocalDate now = LocalDate.now();
        Month todaysMonth = now.getMonth();
        int todaysDayOfMonth = now.getDayOfMonth();

        int edad = now.getYear() - fechaNacimiento.getYear();

        if (todaysMonth.compareTo(fechaNacimiento.getMonth()) > 0)
            return edad + 1;

        if ((todaysMonth.compareTo(fechaNacimiento.getMonth()) == 0)
                && (todaysDayOfMonth >= fechaNacimiento.getDayOfMonth()))
            return edad + 1;

        return edad;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s.%nDNI: %s.%nEdad: %d.%n", nombre, dni, getEdad());
    }


}
