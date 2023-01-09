public class DNI {
    private static final char[] LETRAS_DNI = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J',
            'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

    private int numero;
    private char letra;

    public DNI(int numero, char letra) {
        this.numero = numero;
        this.letra = letra;
    }

    public DNI(String dni) {
        this.numero = Integer.parseInt(dni.substring(0, 9));
        this.letra = dni.charAt(8);
    }

    public char getLetra() {
        return letra;
    }

    public int getNumero() {
        return numero;
    }

    public static boolean esValido(String dni) {
        if (dni.length() == 9) { // Comprobamos que tiene la longitud válida.
            char letra = dni.charAt(8); // Obtenemos el carácter final.

            // Obtenemos el número y calculamos el resto de dividirlo por 23.
            int numero = Integer.parseInt(dni.substring(0, 8));
            int resto = numero % 23;

            // El resto será el índice para obtener la letra que se corresponde con el
            // número.

            // Comprobamos si la letra es correcta. Si los es el dni será válido.
            if (letra == LETRAS_DNI[resto]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String dni_de_prueba = "32781464A";
        if (esValido(dni_de_prueba)) {
            System.out.printf("El DNI %s es válido.%n", dni_de_prueba);
        } else {
            System.out.printf("El dni %s no es válido.", dni_de_prueba);
        }
    }
}
