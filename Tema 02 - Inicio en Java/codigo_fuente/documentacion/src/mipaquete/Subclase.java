package mipaquete;

/**
 * Esta clase es la subclase de la clase principal del paquete mipaquete.
 * 
 * @see Clase
 * 
 * @author Manuel C. Piñeiro Mourazos.
 * @version 1.0
 */


public class Subclase {
    /**
     * Ejemplo de un atributo de esta clase.
     */
    private int atributo;

    /**
     * Constructor por defecto de la clase.
     */
    public Subclase() {
        this.atributo = 0;
    }

    /**
     * Constructor parametrizado de la clase.
     * 
     * @param atributo Valor del atributo de la clase.
     */
    public Subclase(int atributo) {
        this.atributo = atributo;
    }

    /**
     * Método que devuelve el valor del atributo de la clase.
     * 
     * @return Valor del atributo de la clase.
     */
    public int getAtributo() {
        return atributo;
    }

    /**
     * Método que modifica el valor del atributo de la clase.
     * 
     * @param atributo Nuevo valor del atributo de la clase.
     */
    public void setAtributo(int atributo) {
        this.atributo = atributo;
    }

    /**
     * Método que devuelve una cadena con la información de la clase.
     * 
     * @return Cadena con la información de la clase.
     */
    @Override
    public String toString() {
        return "Subclase{" + "atributo=" + atributo + '}';
    }
}
