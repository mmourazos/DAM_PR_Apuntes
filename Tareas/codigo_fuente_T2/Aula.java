package docs.Tareas.codigo_fuente_T2;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Aula {
    public class Cosa {
        int valor = 0;
    }

    /**
     * Devolverá el mínimo divisor de {@code numero}, 0 si es primo.
     * 
     * @param numero int para el que se realiza el cálculo.
     * @return 0 si {@code numero} es primo el primer divisor encontrado si no lo
     *         es.
     */
    public static int divisor(int numero) {
        for (int i = 2; i < numero / 2; ++i) {
            if (numero % i == 0)
                return i;
        }
        return 0;
    }

    public static boolean esPrimo(int numero) {
        for (int i = 2; i < Math.sqrt(numero) + 1; ++i) {
            if (numero % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int n = r.nextInt(1, 101);

        if (esPrimo(n)) {
            System.out.println("El número " + n + " es primo.");
        } else {
            System.out.println("El número " + n + " es divisible por " + divisor(n) + ".");
        }

    }
}
