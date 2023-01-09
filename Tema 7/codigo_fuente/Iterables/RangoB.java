import java.util.Iterator;

public class RangoB implements Iterable<Integer> {
    private int min;
    private int max;
    private int step;

    public RangoB(int min, int max) {
        this.min = min;
        this.max = max;
        step = 1;
    }

    public RangoB(int min, int max, int step) {
        if (min > max) {
            throw new IllegalArgumentException("min must be less or equal to max");
        }
        if (step >= (max - min)) {
            throw new IllegalArgumentException(
                    "step must be less than " + (max - min) + " (max - min)");
        }

        this.min = min;
        this.max = max;
        this.step = step;
    }

    @Override
    public Iterator<Integer> iterator() {
        // TODO Auto-generated method stub
        return new Iterator<Integer>() {
            int posicion = min;

            @Override
            public boolean hasNext() {
                return posicion < max;
            }

            @Override
            public Integer next() {
                int value = posicion;
                posicion += step;
                return value;
            }
        };
    }

}
