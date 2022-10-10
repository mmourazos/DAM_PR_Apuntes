public class Arrays {
    public static void main(String[] args) {
        // Defino un array de enteros de 10 posiciones:
        int[] intArr = new int[10];

        // Para poner valores enteros al array podemos ir posición a posicion:
        intArr[0] = 0;
        intArr[1] = 1;
        intArr[2] = 2;
        intArr[3] = 3;
        intArr[4] = 4;
        intArr[5] = 5;
        intArr[6] = 6;
        intArr[7] = 7;
        intArr[8] = 8;
        intArr[9] = 9;

        // O bien recorrer el array usando un bucle for:
        for (int idx = 0; idx < intArr.length; ++idx) {
            intArr[idx] = idx;
        }

        // También podemos declarar el array e inicializarlo en la misma sentencia:
        int[] intArr2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Un array multidimensional es simplemente un array de arrays:
        int[][] intArrMulti = {intArr, intArr2, {3, 2, 1}};

        // Las "filas" no tienen por qué ser de la misma longitud.
        // Para recorrerlo habría que tener esto en cuenta:
        for (int i = 0; i < intArrMulti.length; ++i) {
            for (int j = 0; j < intArrMulti[i].length; ++j) {
                intArrMulti[i][j] = intArrMulti[i][j] + 1;
            }
        }

        // También podremos recorrerlo usando for-each:
        for (int[] fila : intArrMulti) {
            for (int i : fila) {
                System.out.println(i);
            }
        }
    }
}
