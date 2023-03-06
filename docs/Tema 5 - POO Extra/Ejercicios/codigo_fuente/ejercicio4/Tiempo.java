import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tiempo {

    public static LocalDate fechaActual() {
        return LocalDate.now();
    }

    public static LocalDate fecha(String fecha) {
        return LocalDate.parse(fecha);
    }

    public static LocalDate fecha(int dia, int mes, int año) {
        return LocalDate.of(año, mes, dia);
    }

    public static LocalDateTime fechaHoraActual() {
        return LocalDateTime.now();
    }

    public String fechaHora() {
        return LocalDateTime.now().toString();
    }

    public String fechaHora(String fecha) {
        java.text.DateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(fecha).toString();
    }
}