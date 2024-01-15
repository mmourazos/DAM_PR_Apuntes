import java.util.Iterator;

/**
 * Rango
 */
public class Rango implements Iterable<Integer> {
    public final int min;
    public final int max;

    public Rango(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min must be less or equal to max");
        }
        this.min = min;
        this.max = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        // return new RangoIterator(this);
        return new Iterator<Integer>() {
            int posicion = min;

            @Override
            public boolean hasNext() {
                return posicion < max;
            }

            @Override
            public Integer next() {
                return posicion++;
            }
        };
    }
}

