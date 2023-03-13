import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Cola implements Queue<Integer> {
    private static final int CAPACIDAD_POR_DEFECTO = 10;
    private int capacidad;
    private int capacidadEnUso;
    private Integer[] datos; // Contenedor de los elementos.

    public Cola() {
        datos = new Integer[CAPACIDAD_POR_DEFECTO];
        capacidad = CAPACIDAD_POR_DEFECTO;
        capacidadEnUso = 0;
    }

    @Override
    public int size() {
        return capacidadEnUso;
    }

    @Override
    public boolean isEmpty() {
        return capacidadEnUso == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o instanceof Integer) {
            int valor = (Integer) o;
            for (int i = 0; i < capacidadEnUso; ++i) {
                if (datos[i] == valor)
                    return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int indice = 0;

            @Override
            public boolean hasNext() {
                return indice < capacidadEnUso;
            }

            @Override
            public Integer next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return datos[indice++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    };


    @Override
    public Object[] toArray() {
        Integer[] datos = new Integer[capacidadEnUso];

        for (int i = 0; i < capacidadEnUso; ++i)
            datos[i] = this.datos[i];
        return datos;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length >= capacidadEnUso) {
            for (int i = 0; i < capacidadEnUso; ++i) {
                a[i] = (T) datos[i];
            }
            return a;
        }
        return (T[]) Arrays.copyOf(datos, capacidadEnUso);
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < capacidadEnUso; ++i) {
            if (datos[i] == (Integer) o) {
                System.arraycopy(datos, i + 1, datos, i, capacidadEnUso - i - 1);
                --capacidadEnUso;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        for (Integer o : c) {
            add(o);
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int capacidadEnUsoAntes = capacidadEnUso;
        for (Object o : c) {
            remove(o);
        }
        return capacidadEnUsoAntes != capacidadEnUso;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Integer i : datos) {
            if (!c.contains(i))
                remove(i);
        }
        return false;
    }

    @Override
    public void clear() {
        datos = new Integer[CAPACIDAD_POR_DEFECTO];
        capacidad = CAPACIDAD_POR_DEFECTO;
        capacidadEnUso = 0;
    }

    @Override
    public boolean add(Integer e) {
        if (capacidadEnUso == capacidad) {
            datos = Arrays.copyOf(datos, capacidad * 2);
            capacidad *= 2;
        }

        datos[capacidadEnUso++] = e;

        return true;
    }

    @Override
    public boolean offer(Integer e) {
        return add(e);
    }

    @Override
    public Integer remove() {
        if (capacidadEnUso == 0)
            throw new NoSuchElementException();

        return datos[--capacidadEnUso];
    }

    @Override
    public Integer poll() {
        if (capacidadEnUso == 0)
            return null;
        return datos[--capacidadEnUso];
    }

    @Override
    public Integer element() {
        if (capacidadEnUso == 0)
            throw new NoSuchElementException();
        return datos[0];
    }

    @Override
    public Integer peek() {
        if (capacidadEnUso == 0)
            return null;
        return datos[0];
    }

}
