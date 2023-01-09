public class Lista {
    private Nodo cabecera;
    private Nodo fin;

    public Lista() {
        cabecera = null;
        fin = null;
    }



    public boolean esVacia() {
        return cabecera == null;
    }

    public void add(String dato) {
        if (esVacia()) {
            cabecera = new Nodo(dato);
            fin = cabecera;
        } else {
            Nodo nodo = new Nodo(dato);
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
        }
    }

    public void append(String dato) {
        if (esVacia()) {
            cabecera = new Nodo(dato);
            fin = cabecera;
        } else {
            Nodo nodo = new Nodo(dato);
            fin.setSiguiente(nodo);
            fin = nodo;
        }
    }

    public void insert(String dato, int posicion) {

    }

    public int size() {
        if (esVacia())
            return 0;

        int n = 1;
        Nodo posicion = cabecera;
        while (!posicion.esFinal()) {
            ++n;
            posicion = posicion.getSiguiente();
        }

        return n;
    }

    public String strAt(int posicion) {
        int size = size();
        if (posicion >= size)
            throw new IndexOutOfBoundsException(
                    "index was " + posicion + " while list size " + size);

        Nodo nodo = cabecera;
        while (posicion > 0) {
            nodo = nodo.getSiguiente();
            --posicion;
        }
        return nodo.getDato();
    }


}
