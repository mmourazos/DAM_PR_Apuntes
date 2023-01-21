import java.util.Iterator;
import java.util.NoSuchElementException;

public class AlfabetoV implements Iterable<Character> {
    private char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    class AlfIter implements Iterator<Character> {
        int pos = 0;
        int[] vocalsPositions = {0, 4, 8, 14, 20};

        @Override
        public boolean hasNext() {

            return pos < alfabeto.length;
        }

        @Override
        public Character next() {
            return alfabeto[pos++];
        }

        public boolean hasNextVocal() {
            return pos < vocalsPositions[vocalsPositions.length - 1];
        }

        public Character nextVocal() {
            if (!hasNextVocal()) {
                throw new NoSuchElementException();
            } else {
                for (int vocalPos : vocalsPositions) {
                    if (pos <= vocalPos) {
                        pos = vocalPos;
                        break;
                    }
                }
            }

            return alfabeto[pos++];
        }

    }

    @Override
    public AlfIter iterator() {
        return new AlfIter();
    }

}
