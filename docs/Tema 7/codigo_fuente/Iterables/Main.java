import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Main {
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
        // System.out.println("array menos posición " + pos + " = " + Arrays.toString(array));

        // HashMap<Integer, String> palabras = new HashMap<>();
        // palabras.put(1, "uno");
        // palabras.put(2, "dos");
        // palabras.put(3, "tres");

        // for (Map.Entry<Integer, String> entry : palabras.entrySet()) {
        // System.out.println("entry.getKey() = " + entry.getKey());
        // System.out.println("entry.getValue() = " + entry.getValue());
        // }

        // VariableMem<Integer> vm = new VariableMem<>();

        // vm.add(1);
        // vm.add(2);

        // System.out.println("El resulaod de 1 + vm (2) es: " + (1 + vm.get()));

        // vm.reset();

        // System.out.println("El resulaod de 1 + vm (1) es: " + (1 + vm.get()));

        // vm.reset();

        // System.out.println("Ahora vm vale: " + vm.get());

        Alfabeto alf = new Alfabeto();

        for (char c : alf) {
            System.out.println("c = " + c);
        }

        AlfabetoV alfV = new AlfabetoV();

        AlfabetoV.AlfIter it = (AlfabetoV.AlfIter) alfV.iterator();

        int i = 0;
        while (it.hasNextVocal()) {
            System.out.println("vocal " + i++ + " = " + it.nextVocal());
        }

        Vocales v = new Vocales();

        for (char vocal : v) {
            System.out.println("vocal = " + vocal);
        }
    }

}
