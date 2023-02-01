import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.naming.LinkException;

public class Main {
    public enum TipoLista {
        ARRAY_LIST,
        LINKED_LIST;
    }

    public static long suma(List<Number> l) {
        long suma = 0;
        for (Number n : l) {
            suma += n.longValue();
        }

        return suma;
    }

    public static List<Number> copiaAL(List<Number> l) {
        ArrayList<Number> al = new ArrayList<>();

        for (Number n : l) {
            al.add(n.intValue());
        }

        return al;
    }

    public static double media(List<Number> l) {
        return ((double) suma(l)) / l.size();
    }

    public static List<Number> creaLista(int numElementos, TipoLista t) {
        List<Number> l = null;

        switch (t) {
            case ARRAY_LIST:
                l = new ArrayList<Number>();
                break;

            case LINKED_LIST:
                l = new LinkedList<Number>();
                break;
        }

        for (int i = 0; i < numElementos; ++i) {
            l.add(i);
        }

        return l;
    }

    public static long creaListaTiempo(int numElementos, TipoLista t) {
        List<Number> l = null;
        long t0 = 0, t1 = 0;
        t0 = System.nanoTime();

        creaLista(numElementos, t);

        t1 = System.nanoTime();

        HashMap<String, Object> map = new HashMap<>();
        map.put("lista", l);
        map.put("tiempo", t1 - t0);

        return t1 - t0;
    }

    public static long inserta(int numElementos, TipoLista t) {
        long t0 = 0, t1 = 0;

        switch (t) {
            case ARRAY_LIST:
                t0 = System.nanoTime();
                ArrayList<Integer> al = new ArrayList<>();
                for (int i = 0; i < numElementos; ++i) {
                    al.add(i);
                }
                t1 = System.nanoTime();
                break;
            case LINKED_LIST:
                t0 = System.nanoTime();
                LinkedList<Integer> ll = new LinkedList<>();
                for (int i = 0; i < numElementos; ++i) {
                    ll.add(i);
                }
                t1 = System.nanoTime();
                break;
        }

        return t1 - t0;
    }

    public static long contains(ArrayList<Integer> l) {
        long t0 = System.nanoTime();
        for (int i = 0; i < 100; ++i) {
            l.contains(i);
        }
        long t1 = System.nanoTime();

        return t1 - t0;
    }

    public static void main(String[] args) {

        // System.out.println("Máximo valor de long: " + Long.MAX_VALUE);
        // System.out.println("Máximo valor de long: " + (Long.MAX_VALUE + 1));

        Console c = System.console();
        int numElementos = Integer.parseInt(c.readLine("Num. elem.: "));
        int numRepeticiones = Integer.parseInt(c.readLine("Num. rep.: "));

        Long[] tiempos = new Long[numRepeticiones];

        for (int i = 0; i < numRepeticiones; ++i) {
            tiempos[i] = creaListaTiempo(numElementos, TipoLista.ARRAY_LIST);
        }
        System.out.println("El tiempo para A.L. fue de: " + media(Arrays.asList(tiempos)));

        for (int i = 0; i < numRepeticiones; ++i) {
            tiempos[i] = creaListaTiempo(numElementos, TipoLista.LINKED_LIST);
        }
        System.out.println("El tiempo para L.L. fue de: " + media(Arrays.asList(tiempos)));
    }
}
