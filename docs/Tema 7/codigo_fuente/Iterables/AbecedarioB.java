import java.util.Iterator;
import java.util.NoSuchElementException;

public class AbecedarioB implements Iterable<Character> {
    private char[] abecedario = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    @Override
    public VocIt iterator() {
        return new VocIt();
    }

    class VocIt implements Iterator<Character> {
        private int pos = 0;
        private int[] vocPos = { 0, 4, 8, 14, 20 };

        @Override
        public boolean hasNext() {
            return pos < abecedario.length;
        }

        @Override
        public Character next() {
            return abecedario[pos++];
        }

        public boolean hasNextVocal() {
            return pos <= vocPos[vocPos.length - 1];
        }

        public Character nextVocal() {
            if (!hasNextVocal()) {
                throw new NoSuchElementException();
            } else {
                for (int i = 0; i < vocPos.length; i++) {
                    if (pos <= vocPos[i]) {
                        pos = i;
                    }
                }
                return abecedario[vocPos[pos++]];
            }

        }
    }

}
