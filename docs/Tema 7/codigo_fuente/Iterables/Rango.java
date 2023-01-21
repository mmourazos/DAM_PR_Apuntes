import java.util.Iterator;

/**
 * Rango
 */
public class Rango implements Iterable<Integer> {
    private int[] datos;

    public Rango(int[] datos) {
        this.datos = datos;
    }

    @Override
    public RangoIterator iterator() {
        // return new RangoIterator(this);
        return new RangoIterator();
    }

    public int[] dameLosDatos() {
        return datos;
    }

    class RangoIterator implements Iterator<Integer> {
        // private Rango r;
        private int pos = 0;

        // public RangoIterator(Rango r) {
        // this.r = r;
        // }

        @Override
        public boolean hasNext() {
            return pos < datos.length;
        }

        @Override
        public Integer next() {
            return datos[pos++];
        }
    }

}
