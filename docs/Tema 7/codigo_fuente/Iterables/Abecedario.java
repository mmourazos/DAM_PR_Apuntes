import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Abecedario implements Iterable<Character> {
    // private char[] abecedario = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
    // 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p',
    // 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    // private String abecedario = "abcdefghijklmnñopqrstuvwxyz";

    private List<Character> abecedario = Arrays.asList('a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

    @Override
    public Iterator<Character> iterator() {
        return new AbcIt();
    }

    class AbcIt implements Iterator<Character> {
        private int pos = 0;

        @Override
        public boolean hasNext() {
            return pos < abecedario.size();
        }

        @Override
        public Character next() {
            return abecedario.get(pos++);
        }
    }
}
