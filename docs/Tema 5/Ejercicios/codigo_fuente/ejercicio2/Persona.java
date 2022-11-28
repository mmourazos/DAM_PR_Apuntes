package ejercicio2;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.TimeZone;

public class Persona {

    /**
     * Almacenará el nombre de la persona.
     */
    private String nombre;
    /**
     * Almacenará el apellido de la persona.
     */
    private String apellido1;
    /**
     * Almacenará el segundo apellido de la persona.
     */
    private String apellido2;
    /**
     * Almacenará la fecha de nacimiento de la persona.
     */
    // private Calendar fechaNacimiento;
    private LocalDate fechaNacimiento;

    /**
     * Constructor parametrizado de la clase Persona.
     * 
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param fechaNacimiento
     */
    public Persona(String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Constructor parametrizado de la clase Persona que recibe un String con la fecha de nacimiento
     * en formato dd/mm/aaaa
     *
     * @param nombre nombre de la persona.
     * @param apellido1 primer apellido de la persona.
     * @param apellido2 segundo apellido de la persona.
     * @param fechaNacimeintoString fecha de nacimiento de la persona.
     * @throws ParseException
     */
    public Persona(String nombre, String apellido1, String apellido2, String fechaNacimeintoString)
            throws ParseException {

        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        Calendar.getInstance(TimeZone.getTimeZone("Europe/Madrid"));

        this.fechaNacimiento = LocalDate.parse(fechaNacimeintoString);
    }

    public int edad() {
        LocalDate now = LocalDate.now();
        int edad = now.getYear() - fechaNacimiento.getYear();
        if (now.getMonthValue() < fechaNacimiento.getMonthValue()) {
            edad--;
        } else if (now.getMonthValue() == fechaNacimiento.getMonthValue()
                && now.getDayOfMonth() < fechaNacimiento.getDayOfMonth()) {
            edad--;
        }
        return edad;
    }

    public String fechaYHora() {
        LocalDateTime ldt = LocalDateTime.now();
        int hora = ldt.getHour();
        int minuto = ldt.getMinute();
        int segundo = ldt.getSecond();

        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

}
