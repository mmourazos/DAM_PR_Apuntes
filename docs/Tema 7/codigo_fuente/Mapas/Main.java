import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;

public class Main {

    // Recorrer un mapa:
    public static void recorrerMapa(Map<String, Alumno> mapa) {
        // for (String clave : mapa.keySet()) {
        // System.out.println(clave + " -> " + mapa.get(clave));
        // }

        // for (Entry<String, Alumno> entrada : mapa.entrySet()) {
        // System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        // }

        // for (Alumno valor : mapa.values()) {
        // System.out.println(valor);
        // }

        // mapa.forEach((k, v) -> System.out.println(k + " -> " + v));

        Collection<String> alStr = new ArrayList<>();

        alStr.add("Hola");
        alStr.add("Adios");

        alStr.stream().map(s -> {
            System.out.println(s);
            return s;
        });

        ArrayList<String> invertido = new ArrayList<>(alStr.size());

        alStr.stream().reduce(invertido, (a, cadena) -> {
            a.add(0, cadena);
            return a;
        }, (a, b) -> a.addAll(b) ? a : a);

        System.out.println(invertido);

    }

    public static void main(String[] args) {
        // Creamos tres alumnos:
        // Alumno a1 = new Alumno("Manuel", "327R", "15-05-1977");
        // // System.out.println(a1);

        // Alumno a2 = new Alumno("Javier", "123A", "20-01-2001");
        // Alumno a3 = new Alumno("Amelia", "321Z", "11-12-1992");

        // // Creamos un mapa para guardar alumnos usando como clave el DNI:
        // Map<String, Alumno> mapaAlumnos = new HashMap<>();

        // var x = 5;

        // mapaAlumnos.put(a1.getDni(), a1);
        // mapaAlumnos.put(a2.getDni(), a2);
        // mapaAlumnos.put(a3.getDni(), a3);

        // System.out.println(mapaAlumnos);

        // // Para obtener un valor hemos de usar el dni como clave:
        // Alumno a = mapaAlumnos.get(a1.getDni());

        // System.out.println(a);

        // // Para eliminar un valor hemos de usar el dni como clave:

        recorrerMapa(null);

        Method m = String::length;

        Method m = String::length;

    }
}
