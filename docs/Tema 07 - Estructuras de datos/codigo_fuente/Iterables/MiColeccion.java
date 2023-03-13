import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MiColeccion<T extends Comparable> implements Collection<T> {
    private T[] content = (T[]) new Object[10];
    private int currentSize = 10;
    private int sizeIncrement = 10;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T e) {
        if (currentSize == size) {
            content = Arrays.copyOf(content, currentSize + sizeIncrement);
            currentSize += sizeIncrement;
        }
        content[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int position = Arrays.binarySearch(content, o);
        if (position >= 0) {
            System.arraycopy(content, position + 1, content, position, size - position - 1);
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return Arrays.binarySearch(content, o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }



}
