import java.util.Arrays;

public class NumerosE2 extends NumerosE1 {
    public NumerosE2(int[] values) {
        super(values);
    }

    public int[] sorted() {
        int[] sorted = getValues().clone();
        Arrays.sort(sorted);
        return sorted;
    }

    public int[] odds() {
        int[] odds = new int[getValues().length];
        int oddsLength = 0;

        for (int value : getValues()) {
            if (value % 2 != 0) {
                odds[oddsLength] = value;
                oddsLength++;
            }
        }

        return Arrays.copyOf(odds, oddsLength);
    }

    public int[] evens() {
        int[] evens = new int[getValues().length];
        int evensLength = 0;

        for (int value : getValues()) {
            if (value % 2 == 0) {
                evens[evensLength] = value;
                evensLength++;
            }
        }

        return Arrays.copyOf(evens, evensLength);
    }

}
