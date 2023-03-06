import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Conjunto<T> implements Set<T> {

    private ArrayList<T> datos;
    // private LinkedList<T> datos;

    public Conjunto() {
        datos = new ArrayList<T>();
    }

    // public Conjunto() {
    // datos = new LinkedList<T>();
    // }

    @Override
    public int size() {
        return datos.size();
    }

    @Override
    public boolean isEmpty() {
        return datos.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return datos.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return datos.iterator();
    }

    @Override
    public Object[] toArray() {

        return datos.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return datos.toArray(a);
    }

    @Override
    public boolean add(T e) {
        return datos.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return datos.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return datos.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return datos.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return datos.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return removeAll(c);
    }

    @Override
    public void clear() {
        datos.clear();

    }



}
