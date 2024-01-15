import java.util.Iterator;
import java.util.NoSuchElementException;

public class AbecedarioB implements Iterable<Character> {

    private char[] abecedario = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    @Override
    public Iterator<Character> iterator() {
        return new AlfIter();
    }

    class AlfIter implements Iterator<Character> {
        private int[] posVocales = { 0, 4, 8, 15, 21 };
        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < abecedario.length;
        }

        @Override
        public Character next() {
            return abecedario[position++];
        }

        public boolean hasNextVocal() {
            return position < posVocales[posVocales.length - 1];
        }

        public Character nextVocal() {
            if (!hasNextVocal())
                throw new NoSuchElementException();

            for (int vocalPos : posVocales) {

                if (position <= vocalPos) {
                    position = vocalPos;
                    break;
                }
            }

            return abecedario[position++];
        }
    }
}
