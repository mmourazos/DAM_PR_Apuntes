package conjuntos;

import java.util.Set;

// Este código solo es de ayuda para el ejercicio. No es necesario utilizarlo.
public class Main {

    public static <E> void listaConjunto(Set<E> conjunto) {
        // Un conjunto implementa Set y este a su vez Collection y este a su vez Iterable.
        // Por lo tanto todo conjunto es iterable y se puede recorrer con un bucle for-each.

        for (E elemento : conjunto) {
            System.out.println(elemento);
        }
    }

    public static void main(String[] args) {
        Set<Integer> conjunto1 = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Set<String> conjunto2 = Set.of("uno", "dos", "tres", "cuatro", "cinco");

        listaConjunto(conjunto1);
        listaConjunto(conjunto2);
    }
}
