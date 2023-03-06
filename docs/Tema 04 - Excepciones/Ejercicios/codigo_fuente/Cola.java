public class Cola {
    private NumerosE4 values;

    public Cola() {
        values = new NumerosE4();
    }

    public Cola(int[] values) {
        this.values = new NumerosE4(values);
    }

    public void enqueue(int value) {
        values.insertAtEnd(value);
    }

    public int dequeue() {
        return values.removeFirst();
    }
}
