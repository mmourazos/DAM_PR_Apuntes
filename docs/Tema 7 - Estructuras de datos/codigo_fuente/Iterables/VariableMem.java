public class VariableMem<T> {
    private T valActual;
    private T valPrevio;

    public void add(T val) {
        if (valActual == null) {
            valActual = val;
        } else {
            valPrevio = valActual;
            valActual = val;
        }
    }

    public T get() {
        return valActual;
    }

    public void reset() {
        valActual = valPrevio;
        valPrevio = null;
    }
}
