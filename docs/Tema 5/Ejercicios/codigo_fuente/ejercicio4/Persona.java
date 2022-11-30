import java.util.Random;

public class Persona {
    public static final char HOMBRE = 'H';
    public static final char MUJER = 'M';
    public static final int BAJO_PESO = -1;
    public static final int PESO_IDEAL = 0;
    public static final int SOBREPESO = 1;

    private static final int MIN_DNI = 0;
    private static final int MAX_DNI = 99999999;

    private String nombre;
    private int edad;
    private String dni;
    private char sexo;
    private int peso;
    private int altura;

    public Persona() {
        this.dni = generarDNI();
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.dni = generarDNI();
    }

    public Persona(String nombre, int edad, String dni, char sexo, int peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        if (dniValido(dni)) {
            this.dni = dni.toUpperCase();
        } else {
            throw new IllegalArgumentException("DNI inválido");
        }
        this.sexo = comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = peso / Math.pow(altura, 2);
        if (imc < 20) {
            return BAJO_PESO;
        } else if (imc >= 20 && imc <= 25) {
            return PESO_IDEAL;
        } else {
            return SOBREPESO;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    private char comprobarSexo(char sexo) {
        if (sexo != HOMBRE && sexo != MUJER) {
            sexo = HOMBRE;
        }
        return sexo;
    }

    private int numCiphers(int num) {
        int ciphers = 0;
        while (num > 0) {
            num /= 10;
            ciphers++;
        }
        return ciphers;
    }

    /**
     * Genera una cadena de texto a partir de un número entero. Si el número de
     * cifras de
     * {@code number} es menor que {@code length}, se rellena con ceros a la
     * izquierda. en caso
     * contrario se devuleve el número sin rellenar.
     * 
     * @param number Número entero a convertir en cadena de texto.
     * @param length Longitud de la cadena de texto.
     * @param c      Carácter de relleno.
     * @return Cadena de texto con el número {@code number} rellenado con {@code c}
     *         a la izquierda
     *         hasta alcanzar la longitud {@code length}.
     */
    private String lpad(int number, int length, char c) {
        if (numCiphers(number) >= length) {
            return String.valueOf(number);
        }
        String formatString = "%" + length + "d";
        String outputString = String.format(formatString, number);
        if (c != ' ') {
            outputString = outputString.replace(' ', c);
        }

        return outputString;
    }

    private boolean dniValido(String dni) {
        int numero = Integer.parseInt(dni.substring(0, dni.length() - 1));
        char letra = dni.charAt(dni.length() - 1);
        if (numero < MIN_DNI || numero > MAX_DNI) {
            return false;
        } else if (letra != generaLetraDNI(numero)) {
            return false;
        }
        return true;
    }

    private int generaNumeroDNI() {
        Random r = new Random();
        return r.nextInt(MAX_DNI);
    }

    private char generaLetraDNI(int numero) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int letra = numero % 23;
        return letras.charAt(letra);
    }

    private String generarDNI() {
        int numero = generaNumeroDNI();
        char letra = generaLetraDNI(numero);

        return lpad(numero, 8, '0') + letra;
    }

    @Override
    public String toString() {
        return String.format(
                "Nombre: %s.%nDNI: %s.%nEdad: %d años.%nPeso: %d kg.%nAltura: %d cm.%nSexo: %s.",
                nombre, dni, edad, peso, altura, sexo == HOMBRE ? "Hombre" : "Mujer");
    }

}
