public class Vocales extends AbcedearioStr {

    class AlfIter extends AbcedearioStr.VocIt {
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
