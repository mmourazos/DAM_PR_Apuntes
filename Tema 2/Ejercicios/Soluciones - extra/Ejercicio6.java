import java.util.Arrays;

public class Ejercicio6 extends Ejercicio {

    // Este método intercambia dos elementos de un array.
    public static void swap(Object[] arr, int i, int j) {
        Object aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    // Este métod0 comprueba si un array de cadenas está ordeando.
    public static boolean isSorted(String[] arr) {
        // Recorremos todas las posiciones del array desde la 0 hasta la mayor menos uno.
        for (int idx = 0; idx < arr.length - 1; ++idx) {
            // Comparamos cada posición con la siguiente
            if (arr[idx].compareTo(arr[idx + 1]) > 0)
                // Si el valor de la posición x es mayor que la posición x + 1 concluimos
                // que el array NO está ordenado.
                return false;
        }
        return true;
    }

    public static <T extends Comparable<T>> int minValueIdx(T[] arr, int min, int max) {
        T value = arr[0];
        int minIdx = min;

        for (int idx = min + 1; idx < max; ++idx) {
            if (value.compareTo(arr[idx]) > 0) {
                value = arr[idx];
                minIdx = idx;
            }
        }
        return minIdx;
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length);
    }

    public static <T extends Comparable<T>> void sort(T[] arr, int min, int max) {
        if (min < max) {
            int minIdx = minValueIdx(arr, min, max);
            swap(arr, min, minIdx);
            sort(arr, min + 1, max);
        }
    }

    @Override
    public void ejecutar() {
        String[] strArr = new String[1000];

        for (int idx = 0; idx < strArr.length; ++idx) {
            strArr[idx] = Double.toString(Math.random());
        }

        System.out.println(Arrays.toString(strArr));
        long startTime = System.nanoTime();
        // sort2(strArr, 0, strArr.length);
        sort(strArr);
        long endTime = System.nanoTime();
        long timeInNano = (endTime - startTime);
        System.out.println(Arrays.toString(strArr));

        System.out.println(
                String.format("La ejecución de la ordeanción tardó %d nanosegundos.", timeInNano));
    }


}
