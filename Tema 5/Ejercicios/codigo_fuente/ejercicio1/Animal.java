package ejercicio1;

/**
 * Respresenta un animal.
 */
public class Animal extends SerVivo {

    /**
     * Almacenará el peso de animal.
     */
    private int peso;

    /**
     * Constructor parametrizado de la clase Animal.
     * 
     * @param nombreComun nombre común del animal.
     * @param nombreCientifico nombre científico del animal.
     */
    public Animal(String nombreComun, String nombreCientifico) {
        super(nombreComun, nombreCientifico);
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Método que muestra un mensaje con el tipo de alimentación del animal.
     */
    @Override
    public void alimentacion() {
        System.out.println("El animal se alimenta mediante la ingestión de alimentos.");
    }

}
