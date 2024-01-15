package listas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lista.add(i);
        }

        // TODO: Ordenar la lista de mayor a menor.

        // Con una lambda:
        lista.sort((a, b) -> -b.compareTo(a));

        // Con una clase anónima:
        lista.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return -b.compareTo(a);
            }
        });

        System.out.println(lista);
    }
}
