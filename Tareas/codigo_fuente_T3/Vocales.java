import java.util.Iterator;

public class Vocales extends AbecedarioB {

    @Override
    public Iterator<Character> iterator() {
        return new VocIter();
    }

    private class VocIter extends AlfIter {
        @Override
        public boolean hasNext() {
            return hasNextVocal();
        }

        @Override
        public Character next() {
            return nextVocal();
        }
    }

}
