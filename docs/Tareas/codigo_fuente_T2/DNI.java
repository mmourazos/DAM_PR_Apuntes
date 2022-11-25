package docs.Tareas.codigo_fuente_T2;

public class DNI {

    /**
     * Array constante en que la posición de la letra del DNI se corresponde con el
     * resto de la división del número por 22.
     */
    private static final char[] TABLA_LETRAS = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J',
            'Z', 'S', 'Q',
            'V', 'H', 'L', 'C', 'K', 'E' };
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

    @Override
    public String toString() {
        return Integer.toString(numero) + this.letra;
    }

    /**
     * Genera la letra correspondiente al DNI a partir del número.
     * 
     * @param numero el número a partir del cual generaremos la letra.
     * @return la letra del DNI correspondiente al número.
     */
    private static char calculaLetra(int numero) {
        return TABLA_LETRAS[numero % 22];
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

}
