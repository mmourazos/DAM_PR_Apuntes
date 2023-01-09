import java.util.Arrays;

public class Ejercicio6 {
    public static int idxMin(String[] arr, int from) {
        int minIdx = from;
        String minStr = arr[from];

        for (int idx = from; idx < arr.length; ++idx) {
            if (minStr.compareTo(arr[idx]) > 0) { // Si la palabra es mayor que otra, las
                                                  // intercambiamos.
                minIdx = idx;
                minStr = arr[idx];
            }
        }

        return minIdx;
    }

    public static void swap(String[] arr, int idx1, int idx2) {
        String tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static void sort(String[] arr) {
        for (int idx = 0; idx < arr.length - 1; ++idx) {
            int minIdx = idxMin(arr, idx);
            if (minIdx != idx) {
                swap(arr, idx, minIdx);
            }
        }
    }

    public static String[] ordena(String[] arr) {
        String[] outArr = arr.clone();

        // ¿Cómo ordenar un array de cosas?
        // Una opción:
        // Buscar el menor elemento e intercambiarlo con el primer elemento del array.
        // (Creo un método que busque la posición del menor elemento de un array.)

        sort(outArr);

        return outArr;
    }

    public static void main(String[] args) {
        String[] palabras = Ejercicio5.leePalabras(5);

        String[] palabrasOrdenadas = ordena(palabras);

        System.out.println("Lista original: ");
        System.out.println(Arrays.toString(palabras));

        System.out.println("Lista ordenada:");
        System.out.println(Arrays.toString(palabrasOrdenadas));
    }
}
