package listas;

import java.util.LinkedList;

// Se puede modificar todo el código de esta clase excepto el nombre de la clase y los métodos
// encolar y desencolar.
// La clase ha de extender LinkedList.
public class Cola<E> extends LinkedList<E> {

    public void encolar(E elemento) {
        addLast(elemento);
    }

    public E desencolar() {
        // return removeFirst(); o simplemente:
        return remove();
    }

}
