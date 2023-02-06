import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Creamos tres alumnos:
        Alumno a1 = new Alumno("Manuel", "327R", "15-05-1977");
        // System.out.println(a1);

        Alumno a2 = new Alumno("Javier", "123A", "20-01-2001");
        Alumno a3 = new Alumno("Amelia", "321Z", "11-12-1992");

        // Creamos un mapa para guardar alumnos usando como clave el DNI:
        Map<String, Alumno> mapaAlumnos = new HashMap<>();

        var x = 5;

        mapaAlumnos.put(a1.getDni(), a1);
        mapaAlumnos.put(a2.getDni(), a2);
        mapaAlumnos.put(a3.getDni(), a3);

        System.out.println(mapaAlumnos);

        // Para obtener un valor hemos de usar el dni como clave:
        Alumno a = mapaAlumnos.get(a1.getDni());

        System.out.println(a);

    }
}
