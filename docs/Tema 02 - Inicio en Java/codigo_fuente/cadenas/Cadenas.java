public class Cadenas {
    public static void main(String[] args) {
        String cadena = "La razón de la sinrazón...";

        String cadena_buscada1 = "sinrazón";
        String cadena_buscada2 = "corazón";

        // Buscamos la cadena "sinrazón".
        // indexOf retornará la posición donde empieza la cadena buscada o -1 si no la encuentra.
        int posicion = cadena.indexOf(cadena_buscada1);

        if (posicion >= 0) {
            System.out.printf("Cadena \"%s\" encontrada en la posición %d.%n", cadena_buscada1,
                    posicion);
        } else {
            System.out.printf("No se ha encontrado la cadena \"%s\".%n", cadena_buscada1);
        }

        posicion = cadena.indexOf(cadena_buscada2);

        if (posicion >= 0) {
            System.out.printf("Cadena \"%s\" encontrada en la posición %d.%n", cadena_buscada2,
                    posicion);
        } else {
            System.out.printf("No se ha encontrado la cadena \"%s\".%n", cadena_buscada2);
        }

        // Para extraer la sub-cadena entre las posiciones 3 y 10 de "cadena" lo que haremos será:
        int min = 3;
        int max = 10;

        String subcadena = cadena.substring(min, max + 1); // Sumamos uno a max porque "subString"
                                                           // extrae HASTA la segunda posición SIN
                                                           // INCLUIRLA
        System.out.printf("La cadena entre las posiciones %d y %d de \"%s\" es \"%s\".%n", min, max,
                cadena, subcadena);


        String str1 = "hola";

        String str2 = new String("hola");

        if (str1 == str2) {
            System.out.println("iguales.");
        } else if (str1.equals(str2)) {
            System.out.println("Las cadenas son iguales.");
        } else {
            System.out.println("distintas.");
        }
    }
}
