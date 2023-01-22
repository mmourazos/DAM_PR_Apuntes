import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Main {
    private static String datos = "abcdefghijklmnñopqrstuvwxyz";
    private static char[] datos1 = {'a', 'b', 'c', 'd', 'e', 'f'};

    public static void main(String[] args) {
        // Rango r = new Rango(5, 15);

        // for (int i : r) {
        // System.out.println("i = " + i);
        // }

        // RangoB rb = new RangoB(100, 200, 75);

        // for (int i : rb) {
        // System.out.println("i = " + i);
        // }

        // int pos = 2;
        // int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // System.out.println("array original = " + Arrays.toString(array));
        // System.arraycopy(array, pos + 1, array, pos, array.length - pos - 1);
        // array = Arrays.copyOf(array, array.length - 1);
        // System.out.println("array menos posición " + pos + " = " +
        // Arrays.toString(array));

        // HashMap<Integer, String> palabras = new HashMap<>();
        // palabras.put(1, "uno");
        // palabras.put(2, "dos");
        // palabras.put(3, "tres");

        // for (Map.Entry<Integer, String> entry : palabras.entrySet()) {
        // System.out.println("entry.getKey() = " + entry.getKey());
        // System.out.println("entry.getValue() = " + entry.getValue());
        // }

        // Probando rangos:
        System.out.println("Prueba de Rango: rango de 5 a 15:");
        Rango r = new Rango(5, 15);
        for (int i : r) {
            System.out.println("i = " + i);
        }

        System.out.println("Prueba de RangoB: rango de 100 a 200 con salto de 15:");
        RangoB rb = new RangoB(100, 200, 15);
        for (int i : rb) {
            System.out.println("i = " + i);
        }

        // Porbando abecedarios:
        System.out.println("Prueba de AbecedarioArr:");


        AbecedarioArr abc = new AbecedarioArr();

        for (char x : abc) {
            System.out.println("caracter: " + x);
        }

        // caracter: a
        // caracter: b
        // caracter: c
        // caracter: d
        // caracter: e
        // ...

        AbcedearioStr abcb = new AbcedearioStr();
        AbcedearioStr.VocIt iter = abcb.iterator();

        while (iter.hasNextVocal()) {
            System.out.println("vocal: " + iter.nextVocal());
        }
        // vocal: a
        // vocal: e
        // vocal: i
        // ...

        // Vocales voc = new Vocales();

        // for (char x : voc) {
        // System.out.println("Vocal: " + x);
        // }
        // Vocal: a
        // Vocal: e
        // Vocal: i
        // ...
    }

}
