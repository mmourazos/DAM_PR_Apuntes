package mipaquete;

/**
 * Esta clase es la clase principal del paquete paquete.
 * 
 * @author Manuel C. Piñeiro Mourazos.
 * @version 0.1
 */
public class Clase {
    /**
     * Ejemplo de un atributo de esta clase.
     * 
     */
    private int propiedad;

    /**
     * Constructor por defecto de la clase.
     */
    public Clase() {
        this.propiedad = 0;
    }

    /**
     * Constructor parametrizado de la clase.
     * 
     * @param propiedad valor entero del atributo de la clase.
     */
    public Clase(int propiedad) {
        this.propiedad = propiedad;
    }

    /**
     * Método que devuelve el valor del atributo de la clase.
     * 
     * @return valor del atributo de la clase.
     * @deprecated Este método está obsoleto. Utilice el método getPropiedad().
     */
    @Deprecated
    public int dimePropiedad() {
        return propiedad;
    }

    /**
     * Método que devuelve el valor del atributo de la clase.
     * 
     * @return Valor del atributo de la clase.
     */
    public int getPropiedad() {
        return propiedad;
    }

    /**
     * Método que modifica el valor del atributo de la clase.
     * 
     * @param propiedad Nuevo valor del atributo de la clase.
     */
    public void setPropiedad(int propiedad) {
        this.propiedad = propiedad;
    }
}
