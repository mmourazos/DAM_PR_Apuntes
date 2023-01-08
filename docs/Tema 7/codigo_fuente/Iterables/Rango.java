import java.util.Iterator;

/**
 * Rango
 */
public class Rango implements Iterable<Integer> {
    private int min;
    private int max;

    public Rango(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangoIterator(this);
    }

    private class RangoIterator implements Iterator<Integer> {
        private Rango rango;
        private int posicion;

        public RangoIterator(Rango rango) {
            this.rango = rango;
            posicion = rango.min;
        }

        @Override
        public boolean hasNext() {
            return posicion < rango.max;
        }

        @Override
        public Integer next() {
            return posicion++;
        }
    }

}
