import java.util.Iterator;

public class RangoB extends Rango {

    private int step;

    public RangoB(int min, int max) {
        super(min, max);
        step = 1;
    }

    public RangoB(int min, int max, int step) {
        super(min, max);
        if (step >= (max - min)) {
            throw new IllegalArgumentException(
                    "step must be less than " + (max - min) + " (max - min)");
        }
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
