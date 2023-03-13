public class Pila {

    private NumerosE4 values;

    public Pila() {
        values = new NumerosE4();
    }

    public Pila(int[] values) {
        this.values = new NumerosE4(values);
    }

    public void push(int value) {
        values.insertAtEnd(value);
    }

    public int pop() {
        return values.removeLast();
    }
}
