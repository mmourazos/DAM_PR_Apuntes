package ejercicio1;

/**
 * La clase abstracta SerVivo será la clase padre de Animal y Vegetal.
 */
public abstract class SerVivo {


    /**
     * Almacenará el nombre común del ser vivo.
     */
    private String nombreComun;

    /**
     * Almacenará el nombre científico del ser vivo.
     */
    private String nombreCientifico;

    /**
     * Almacenará la altura del vegetal o animal.
     */
    private int altura;

    /**
     * Constructor parametrizado de la clase SerVivo.
     *
     * @param nombreComun Nombre común del ser vivo.
     * @param nombreCientifico Nombre científico del ser vivo.
     */
    public SerVivo(String nombreComun, String nombreCientifico) {
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
    }



    public String getNombreComun() {
        return nombreComun;
    }



    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }



    public String getNombreCientifico() {
        return nombreCientifico;
    }



    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public int getAltura() {
        return altura;
    }



    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * Método abstracto que será implementado por las clases hijas. Mostrará un mensaje con el tipo
     * de alimentación.
     */
    public abstract void alimentacion();

}
