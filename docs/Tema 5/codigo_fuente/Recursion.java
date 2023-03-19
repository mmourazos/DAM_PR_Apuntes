import java.io.Console;

public class Recursion {
    public static int fibonacci(int x) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        if (x == 2)
            return 1;

        return fibonacci(x - 2) + fibonacci(x - 1);
    }

    // Usando recursividad para crear un bucle.
    // int indicará la iteración en la que estamos y limit cuantas repeticiones
    // queremos.
    public static int recursividadCola(int i, int limit) {
        // Condición de fin de la recursión.
        if (i == limit)
            return 0;
        // Código a repetir.
        System.out.println(String.format("Iteración %d de %d.", i + 1, limit));
        // Última instrucción es la llamda recursiva.
        return recursividadCola(i + 1, limit);
    }

    public static void main(String[] args) {
        Console con = System.console();

        System.out.print("Indica un número para fibonacci: ");
        int number = Integer.parseInt(con.readLine());

        System.out.printf("Fibonacci de %d es %d.%n", number, fibonacci(number));

        recursividadCola(0, 10);
    }
}
