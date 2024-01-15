import java.util.Iterator;
import java.util.NoSuchElementException;

public class Rango implements Iterable<Integer> {
    private int min;
    private int max;

    public Rango(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator
    }

    private class MiIterator implements Iterator<Integer> {
        Rango r;
        int valor_actual;

        public MiIterator(Rango r) {
            this.r = r;
            valor_actual = r.min;
        }

        @Override
        public boolean hasNext() {
            return valor_actual <= r.max;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return valor_actual++;
        }

    }

    public static void main(String[] args) {
        Rango r = new Rango(100, 200);

        for (int i : r) {
            System.out.println("i = " + i);
        }

        // Iterator<int[]> i = Arrays.asList(arrInt).iterator();

        // while(i.hasNext()) {
        // System.out.println(i.next());
        // }
    }

}