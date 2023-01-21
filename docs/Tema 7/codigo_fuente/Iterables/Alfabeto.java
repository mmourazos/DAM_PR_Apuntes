import java.util.Iterator;

public class Alfabeto implements Iterable<Character> {
    private char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};



    class AlfIter implements Iterator<Character> {
        int pos = 0;


        @Override
        public boolean hasNext() {

            return pos < alfabeto.length;
        }

        @Override
        public Character next() {
            return alfabeto[pos++];
        }

    }

    @Override
    public AlfIter iterator() {
        return new AlfIter();
    }

}
