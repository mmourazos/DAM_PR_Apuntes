public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1");
        Abecedario abc = new AbecedarioX();
        for (char l : abc) {
            System.out.println("letra: " + l);
        }

        System.out.println("Ejercicio 2");

        AbecedarioB abcB = new AbecedarioB();
        AbecedarioB.AlfIter it = (AbecedarioB.AlfIter) abcB.iterator();

        while (it.hasNextVocal()) {
            System.out.println("letra: " + it.nextVocal());
        }

        System.out.println("Ejercicio 3");

        Vocales voc = new Vocales();

        for (char l : voc) {
            System.out.println("vocal: " + l);
        }

    }
}
