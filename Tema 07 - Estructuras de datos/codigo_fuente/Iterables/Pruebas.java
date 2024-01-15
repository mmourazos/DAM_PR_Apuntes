import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Pruebas {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();

        lista.add(5);
        lista.add(Integer.valueOf(6));

        for (int i = 0; i < lista.size(); i++) {
            System.out.printf("Elemento número %d: %d.%n", i, lista.get(i));
        }

        // Probando queue
        Queue<Integer> cola = new PriorityQueue<>();
    }
}
