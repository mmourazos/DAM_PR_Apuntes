package docs.Tareas.codigo_fuente_T2;

import java.io.Console;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class Main {
    private int i = 0;

    public static void main(String[] args) {
        int[][] matriz = new int[3][];
        /*
         * | 1 2 3 4 |
         * | 4 5 6 |
         * | 7 8 9 |
         */

        matriz[0] = new int[] { 1, 2, 3, 4 };
        matriz[1] = new int[] { 4, 5, 6 };

        matriz[0][0] = 1;

        for (int[] fila : matriz) {
            for (int columna : fila) {
                System.out.println(columna);
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println(matriz[i][j]);
            }
        }
        try {
            System.out.println("Hola");
            // ...
        } catch (ArithmeticException e) {
            // ...
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            System.out.println("Adios");
        }

        try (Scanner scanner = new Scanner(System.in)) {
            // ...
        }

    }
}
