import java.util.Iterator;

public class AbecedarioArr implements Iterable<Character> {

    private char[] abecedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /*
     * Como implementa el interfaz Iterable ha de implementar a su vez el método iterator().
     */
    @Override
    public Iterator<Character> iterator() {
        return new AbcIt();
    }

    /*
     * Puesto que el iterador está ligado a la clase sobre la que itera tiene sentido que se defina
     * dentro de la misma (como clase interna).
     * 
     * El interfaz Iterator exige la implementación de los métodos hasNext() y next().
     */
    class AbcIt implements Iterator<Character> {
        private int pos = 0;

        @Override
        public boolean hasNext() {
            return pos < abecedario.length;
        }

        @Override
        public Character next() {
            return abecedario[pos++];
        }
    }
}
