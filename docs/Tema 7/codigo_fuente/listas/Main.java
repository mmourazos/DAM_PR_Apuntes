import java.io.Console;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static List<Integer> inserta(int numElementos, List<Integer> l) {
        for (int i = 0; i < numElementos; ++i) {
            l.add(i);
        }

        return l;
    }

    private static boolean comprueba(List<Integer> l) {
        for (int i = 0; i < l.size(); ++i) {
            if (!l.contains(i)) {
                return false;
            }
        }
        return true;
    }

    private static long suma(List<Integer> l) {
        long suma = 0;
        for (int i = 0; i < l.size(); ++i) {
            suma += l.get(i);
        }

        return suma;
    }

    private static void borrar(List<Integer> l) {
        for (int i = 0; i < l.size(); ++i) {
            l.remove(i);
        }
    }

    public static void main(String[] args) {
        Console c = System.console();

        int numElementos = Integer.parseInt(c.readLine("Indica el número de elementos: "));

        long t0 = System.nanoTime();

        // Crear un ArrayList:
        List<Integer> al = inserta(numElementos, new ArrayList<Integer>());

        long t1 = System.nanoTime();

        System.out.println(
                "(ArrayList) Se tardaron " + (t1 - t0) / 1000000 + " milisegundos en crearse (y llenarse) la lista.");

        t0 = System.nanoTime();

        List<Integer> ll = inserta(numElementos, new LinkedList<Integer>());

        t1 = System.nanoTime();

        System.out.println(
                "(LinkedList) Se tardaron " + (t1 - t0) + " nanosegundos en crearse (y llenarse) la lista.");

        al = inserta(numElementos, al);
        Operaciones op = new Operaciones();
        t0 = System.nanoTime();

        op.borrar(al);

        t1 = System.nanoTime();

        System.out.printf("(ArrayList - m. obj) Se tardaron %d ns en borrar la lista.%n", (t1 - t0));

        al = inserta(numElementos, al);

        t0 = System.nanoTime();

        borrar(al);

        t1 = System.nanoTime();

        System.out.printf("(ArrayList - m. local) Se tardaron %d ns en borrar la lista.%n", (t1 - t0));
        al = inserta(numElementos, al);
        t0 = System.nanoTime();

        for (int i = 0; i < al.size(); ++i) {
            al.remove(i);
        }

        t1 = System.nanoTime();

        System.out.printf("(ArrayList - codigo) Se tardaron %d ns en borrar la lista.%n", (t1 - t0));

    }
}