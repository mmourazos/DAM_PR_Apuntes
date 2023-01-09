package docs.Tareas.codigo_fuente_T2;

public class DNI {

    /**
     * Array constante en que la posición de la letra del DNI se corresponde con el
     * resto de la división del número por 22.
     */
    private static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
    /**
     * Número asociado al DNI.
     */
    private int numero;
    /**
     * Letra asociada al DNI (en un DNI válido depend del número).
     */
    private char letra;

    /**
     * Constructor del DNI. No se comprueba la validez del mismo.
     */
    public DNI(int numero, char letra) {
        if (calculaLetra(numero) != letra)
            throw new IllegalArgumentException("La letra suministrada no se corresponde con el número.");
        this.numero = numero;
        this.letra = letra;
    }

    public DNI(String dni) {
        if (dni.length() != 9)
            throw new IllegalArgumentException("El DNI debe tener 9 caracteres.");
        this.numero = Integer.parseInt(dni.substring(0, 8));
        this.letra = dni.charAt(8);
        if (calculaLetra(numero) != letra)
            throw new IllegalArgumentException("La letra suministrada no se corresponde con el número.");
    }

    /**
     * Genera la letra correspondiente al DNI a partir del número.
     * 
     * @param numero el número a partir del cual generaremos la letra.
     * @return la letra del DNI correspondiente al número.
     */
    private static char calculaLetra(int numero) {
        return LETRAS.charAt(numero % 23);
    }

    /**
     * Indica si el dni es o no válido.
     * 
     * @return
     *         <ul>
     *         <li>true si el dni es válido.</li>
     *         <li>false si no es un dni válido.</li>
     *         </ul>
     */
    public boolean esValido() {
        return dniValido(this);
    }

    /**
     * Determina si un dni que se le pasa como argumento es o no válido.
     * 
     * @param dni el dni a comprobar.
     * @return
     *         <ul>
     *         <li>true si el dni es válido.</li>
     *         <li>false si no es un dni válido.</li>
     *         </ul>
     */
    public static boolean dniValido(DNI dni) {
        return dni.letra == calculaLetra(dni.numero);
    }

    /**
     * 
     * @param numero el numero del dni que desamos comprobar.
     * @param letra  la letra que deseamos comprobar
     * @return
     *         <ul>
     *         <li>true si el dni es válido.</li>
     *         <li>false si no es un dni válido.</li>
     *         </ul>
     */
    public static boolean dniValido(int numero, char letra) {
        return letra == calculaLetra(numero);
    }

    @Override
    public String toString() {
        return String.format("%08d", numero) + letra;
    }

    @Override
    public boolean equals(Object dni) {

        return this.letra == ((DNI) dni).letra && this.numero == ((DNI) dni).numero;
    }

}
