public class ForLoop {
    public static void forLoop() {
        // El bucle for se repite un número predeterminado de veces.
        int limit = 10;
        for (int i = 0; i < limit; ++i) {
            System.out.println(String.format("Iteración %d del bucle.", i + 1));
        }
    }
}
