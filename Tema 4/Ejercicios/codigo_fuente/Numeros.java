import java.util.Arrays;

public class Numeros {
    public static final int DEFAULT_MAX_SIZE = 100;
    public static final int DEFAULT_SIZE_INCREMENT = 50;

    private int[] values;
    private int length;
    private int maxSize;
    private int sizeIncrement;

    // Constructor que crea un array vacío de capacidad inicial 100.
    // El tamaño incrementa en 50 cada vez que se llena.
    // El contenido inicial es 0.
    public Numeros() {
        this(new int[DEFAULT_MAX_SIZE], 0, DEFAULT_MAX_SIZE, DEFAULT_SIZE_INCREMENT);
    }

    // Constructor que inicializa el objeto de Numeros con los valores (y tamaño)
    // del array que se pasa como parámetro.
    // El tamaño incrementa en el parámetro "sizeIncrement" cada vez que se llena.
    public Numeros(int[] values) {
        this(values, values.length, values.length, DEFAULT_SIZE_INCREMENT);
    }

    // Constructor que inicializa el objeto de Numeros con los valores (y tamaño)
    // del array que se pasa como parámetro.
    // El tamaño incrementa en el parámetro "sizeIncrement" cada vez que se llena.
    public Numeros(int[] values, int sizeIncrement) {
        this(values, values.length, values.length, sizeIncrement);
    }

    // Constructor que inicializa el objeto de Numeros con los valores del array
    // que se pasa como parámetro.
    // El tamaño inicial será de "maxSize" y el tamaño incrementará en "sizeIncrement"
    // cada vez que se llena.
    // Nota: maxSize ha de ser mayor o igual a "values.length".
    public Numeros(int[] values, int maxSize, int sizeIncrement) {
        this(values, values.length, maxSize, sizeIncrement);
    }

    // Constructor que inicializa el objeto de Numeros con los valores de un array
    // que se pasa como parámetro.
    // Además de ello se indica el tamaño inicial del array "length", el tamaño máximo
    // (hasta tener que ampliarlo) "maxSize" y el tamaño del incremento "sizeIncrement".
    public Numeros(int[] values, int length, int maxSize, int sizeIncrement) {
        if (maxSize < length) {
            throw new IllegalArgumentException("maxSize must be greater or equal to length.");
        }
        if (sizeIncrement < 1) {
            throw new IllegalArgumentException("sizeIncrement must be greater than 0.");
        }
        this.values = Arrays.copyOf(values, maxSize);
        this.length = length;
        this.maxSize = maxSize;
        this.sizeIncrement = sizeIncrement;
    }


    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int get(int index) {
        return values[index];
    }

    public int set(int index, int value) {
        int aux = values[index];
        values[index] = value;
        return aux;
    }

    public void insert(int value, int position) {
        if (length == maxSize) {
            values = Arrays.copyOf(values, maxSize + sizeIncrement);
            maxSize += sizeIncrement;
        }
        for (int i = length; i > position; i--) {
            values[i] = values[i - 1];
        }
        values[position] = value;
        length++;
    }

    public void insertAtStart(int value) {
        insert(value, 0);
    }

    public void insertAtEnd(int value) {
        insert(value, length);
    }

    public void add(int value) {
        insertAtEnd(value);
    }

    public void swap(int value, int indexA, int indexB) {
        int aux = get(indexB);
        set(indexB, get(indexA));
        set(indexA, aux);
    }

    public int remove(int position) {
        int aux = values[position];
        for (int i = position; i < length - 1; i++) {
            values[i] = values[i + 1];
        }
        length--;
        return aux;
    }

    public void push(int value) {
        insertAtEnd(value);
    }

    public int pop() {
        --length;
        return values[length];
    }

    public void adjustSize() {
        values = Arrays.copyOf(values, length);
        maxSize = length;
    }

    public void reset() {
        length = 0;
        values = new int[maxSize];
    }

    @Override
    public String toString() {
        String outString = "[";
        for (int i = 0; i < length; ++i) {
            outString += values[i];
            if (i < length - 1) {
                outString += ", ";
            }
        }
        outString += "]";
        return outString;
    }

    public int[] primeNumbers() {
        int[] primes = new int[length];
        int primesLength = 0;
        for (int i = 0; i < length; ++i) {
            if (isPrime(values[i])) {
                primes[primesLength++] = values[i];
            }
        }
        return Arrays.copyOf(primes, primesLength);
    }

    private boolean isPrime(int number) {
        if (number <= 2) {
            return true;
        }

        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public int[] primeNumbersV0() {
        int[] primes = new int[length];
        int primesLength = 0;
        for (int i = 0; i < length; ++i) {
            if (isPrime(values[i])) {
                primes[primesLength++] = values[i];
            }
        }
        primes = Arrays.copyOf(primes, primesLength);
        return primes;
    }

    public static void main(String[] args) {
        Numeros numeros = new Numeros(new int[] {1, 2, 3, 4, 5}, 10);
        numeros.push(4);
        numeros.push(3);
        numeros.push(2);
        numeros.add(1);
        System.out.println(numeros);
        System.out.println(Arrays.toString(numeros.primeNumbers()));
        System.out.println("is 1533 prime? " + numeros.isPrime(1533));
    }
}
