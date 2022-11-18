import java.util.Arrays;

public class NumerosE4 {
    public static final int INCREMENT_SIZE = 10;
    public static final int MAX_SIZE = 10;


    private int[] values;
    private int length;
    private int maxSize;
    private int incrementSize;

    public NumerosE4() {
        this.values = new int[MAX_SIZE];
        this.length = 0;
        this.maxSize = MAX_SIZE;
        this.incrementSize = INCREMENT_SIZE;
    }

    public NumerosE4(int[] values) {
        this.values = values;
        this.length = values.length;
        this.maxSize = values.length;
        this.incrementSize = INCREMENT_SIZE;
    }

    public int length() {
        return length;
    }

    /*
     * Determina si el arreglo está lleno.
     */
    public boolean isFull() {
        return length == maxSize;
    }

    /*
     * Aumenta el tamaño del contenedor en incrementSize.
     */
    private void increaseSize() {
        values = Arrays.copyOf(values, maxSize + incrementSize);
        maxSize += incrementSize;
    }

    public void shiftRight(int position) {
        if (isFull()) {
            increaseSize();
        }

        for (int i = length; i > position; --i) {
            values[i] = values[i - 1];
        }
        ++length;
    }

    public int shiftLeft(int position) {
        int aux = values[position];
        for (int i = position; i < length - 1; ++i) {
            values[i] = values[i + 1];
        }
        --length;
        return aux;
    }

    /*
     * Inserta un valor en nuestro contenedor en la posición indicada. La posición debe ser un valor
     * entre 0 y length-1.
     */
    public void insert(int value, int position) {
        if (position < 0 || position > length) {
            throw new IndexOutOfBoundsException();
        }

        shiftRight(position);

        values[position] = value;
    }

    public void insertAtStart(int value) {
        insert(value, 0);
    }

    public void insertAtEnd(int value) {
        insert(value, length);
    }

    public void delete(int position) {
        for (int i = position; i < length - 1; ++i) {
            values[i] = values[i + 1];
        }
    }

    public void add(int value) {
        if (length == maxSize) {
            values = Arrays.copyOf(values, length + incrementSize);
            maxSize = length + incrementSize;
        }
        values[length++] = value;
    }

    public int removeFirst() {
        int first = values[0];
        for (int i = 0; i < length - 1; --i) {
            values[i] = values[i + 1];
        }
        this.length--;
        return first;
    }

    public int removeLast() {
        int last = values[length - 1];
        this.length--;
        return last;
    }

    /*
     * Ajusta el tamaño del array a la longitud de los valores que contiene.
     */
    public void adjustSize() {
        this.values = Arrays.copyOf(values, length);
        this.maxSize = this.length;
    }
}
