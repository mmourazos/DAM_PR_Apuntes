public class NumerosE1 {
    private int[] values;


    public NumerosE1(int[] values) {
        this.values = values;
    }

    public int length() {
        if (values == null) {
            return 0;
        }
        return values.length;
    }

    public int max() {
        if (values == null) {
            return 0;
        }

        int max = values[0];
        for (int i = 1; i < values.length; ++i) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }

    public int min() {
        if (values == null) {
            return 0;
        }

        int min = values[0];
        for (int i = 1; i < values.length; ++i) {
            if (values[i] < min) {
                min = values[i];
            }
        }
        return min;
    }

    private int total() {
        int total = 0;

        for (int value : values) {
            total += value;
        }

        return total;
    }

    public int mean() {
        return total() / values.length;
    }

    private int oddLengthMedian() {
        int centerPosition = values.length / 2;

        return values[centerPosition];
    }

    private double evenLengthMedian() {
        int centerPosition = values.length / 2;

        return (values[centerPosition - 1] + values[centerPosition]) / 2.0;
    }

    public double median() {
        if (values == null || values.length == 0) {
            return 0;
        }

        if (values.length % 2 == 0) {
            return evenLengthMedian();
        } else {
            return oddLengthMedian();
        }
    }

    public int[] getValues() {
        return values;
    }
}
