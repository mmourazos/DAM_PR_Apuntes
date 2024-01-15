public class Lista<T> {
    private Nodo<T> cabecera;
    private Nodo<T> fin;

    int size;

    public void add(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (listaVacia()) {
            cabecera = nuevo;
            fin = nuevo;
        } else {
            Nodo<T> aux = cabecera;
            cabecera = nuevo;
            nuevo.setSiguiente(aux);
        }
        ++size;
    }

    public void append(T dato) {
        if (listaVacia()) {
            add(dato);
        } else {
            Nodo<T> nuevo = new Nodo<>(dato);
            fin.setSiguiente(nuevo);
            fin = nuevo;
            ++size;
        }
    }

    // public void append(String dato) {
    // if (listaVacia()) {
    // add(dato);
    // } else {
    // Nodo nuevo = new Nodo(dato);

    // Nodo actual = cabecera;

    // while (!actual.esFinal()) {
    // actual = actual.getSiguiente();
    // }

    // actual.setSiguiente(nuevo);
    // ++size;
    // }
    // }

    public boolean listaVacia() {
        return cabecera == null;
    }

    /**
     * Devuelve el número de elementos de la lista. 0 en el caso de
     * una lista vacía.
     * 
     * @return el número de elementos de la lista.
     */
    public int size() {
        if (listaVacia())
            return 0;
        return size;
    }

    @Override
    public String toString() {
        String resultado = "(" + size + ") [";

        if (!listaVacia()) {
            Nodo<T> actual = cabecera;
            resultado += actual.getDato();

            while (!actual.esFinal()) {
                actual = actual.getSiguiente();
                resultado += ", " + actual.getDato();
            }
        }

        resultado += "]";
        return resultado;
    }

    /**
     * Extrae el primer dato de la lista. Devuelve null si la lista está vacía.
     * 
     * @return el primer elemento de la lista.
     */
    public T extraeInicio() {
        if (listaVacia())
            return null;
        T resultado = cabecera.getDato();

        cabecera = cabecera.getSiguiente();

        --size;
        return resultado;
    }

    public void insertar(T dato, int posicion) {
        if (posicion < 0 || posicion > size)
            throw new IndexOutOfBoundsException();

        Nodo<T> nuevo = new Nodo<>(dato);

        if (posicion == 0) {
            nuevo.setSiguiente(cabecera);
            cabecera = nuevo;
        } else if (posicion == size) {
            fin.setSiguiente(nuevo);
            fin = fin.getSiguiente();
        } else { // posicion > 0 y posicion < size
            Nodo<T> previo = cabecera;
            int pos = 1;
            while (pos < posicion) {
                previo = previo.getSiguiente();
                ++pos;
            }

            nuevo.setSiguiente(previo.getSiguiente());
            previo.setSiguiente(nuevo);
        }
        ++size;
    }

    public void insertar(Lista<T> lista, int posicion) {

    }

    public T borra(int posicion) {
        T dato;
        if (posicion < 0 || posicion >= size)
            throw new IndexOutOfBoundsException();

        if (size == 1) {
            dato = cabecera.getDato();
            cabecera = null;
            fin = null;
        } else if (posicion == 0) {
            dato = cabecera.getDato();
            cabecera = cabecera.getSiguiente();
        } else {
            int pos = 1;
            Nodo<T> nodoPrevio = cabecera;

            while (pos < posicion) {
                nodoPrevio = nodoPrevio.getSiguiente();
            }

            dato = nodoPrevio.getSiguiente().getDato();

            if (nodoPrevio.getSiguiente() == fin)
                fin = nodoPrevio;

            nodoPrevio.setSiguiente(nodoPrevio.getSiguiente().getSiguiente());
        }
        --size;
        return dato;
    }

}
