package ejercicio1;

/**
 * Representa un vegetal.
 */
public class Vegetal extends SerVivo {

    /**
     * Constructor parametrizado de la clase Vegetal.
     * 
     * @param nombreComun nombre común del vegetal.
     * @param nombreCientifico nombre científico del vegetal.
     */
    public Vegetal(String nombreComun, String nombreCientifico) {
        super(nombreComun, nombreCientifico);
    }

    /**
     * Método que muestra un mensaje con el tipo de alimentación del vegetal.
     */
    @Override
    public void alimentacion() {
        System.out.println("El vegetal se alimenta mediante la fotosíntesis.");
    }

}
