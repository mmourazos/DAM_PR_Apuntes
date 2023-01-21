public class Vocales extends AlfabetoV {
    class AlfIter extends AlfabetoV.AlfIter {
        @Override
        public boolean hasNext() {
            return hasNextVocal();
        }

        @Override
        public Character next() {
            return nextVocal();
        }
    }

    @Override
    public AlfIter iterator() {
        return new AlfIter();
    }
}
