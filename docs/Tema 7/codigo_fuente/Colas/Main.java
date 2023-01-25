import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        LocalTime t0 = LocalTime.now();

        // Cosas han pasado.

        LocalTime t1 = LocalTime.now();

        long tiempoTranscurrido = t0.until(t1, ChronoUnit.NANOS);

        PriorityQueue<String> cola = new PriorityQueue<>((s1, s2) -> s2.compareTo(s1));
        cola.add("Hola");
        cola.add("Adios");
        cola.add("Mundo");
        cola.add("Cruel");

        System.out.println(cola);

        PriorityQueue<Integer> cola2 = new PriorityQueue<>((i1, i2) -> i2 - i1);

        cola2.add(1);
        cola2.add(2);
        cola2.add(3);

        System.out.println(cola2);

        for (int v : cola2) {
            System.out.println(v);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(cola2.poll());
        }
    }

}
