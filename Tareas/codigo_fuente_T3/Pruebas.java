import java.io.Console;

import javax.sound.sampled.SourceDataLine;

public class Pruebas {

    public static double media(long[] valores) {
        double suma = 0.0;

        for (long v : valores) {
            suma += v;
        }

        return suma / valores.length;
    }

    public static void main(String[] args) {
        Console c = System.console();

        int numPruebas = Integer.parseInt(c.readLine("Indica cuantas pruebas se realizarán: "));
        long[] pruebas = new long[numPruebas];

        // long t0, t1;

        numPruebas = 10;
        for (int i = 0; i < numPruebas--; ++i) {
            long t0, t1;
            t0 = System.nanoTime();

            // Código a probar.

            t1 = System.nanoTime();
            pruebas[i] = t1 - t0;
        }

        System.out.printf("Se tardó %.4f en realizar la prueba.%n", media(pruebas));
    }

}