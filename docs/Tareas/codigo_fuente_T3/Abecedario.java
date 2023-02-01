import java.util.Iterator;
import java.util.NoSuchElementException;

public class Abecedario implements Iterable<Character> {

    private char[] abecedario = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    @Override
    public Iterator<Character> iterator() {
        return new AlfIter();
    }

    private class AlfIter implements Iterator<Character> {
        private int position = 0;
        private int[] posVocales = { 0, 4, 8, 15, 21 };

        @Override
        public boolean hasNext() {
            return position < abecedario.length;
        }

        @Override
        public Character next() {
            return abecedario[position++];
        }
    }
}
