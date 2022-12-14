package paquete.visibilidad;

public class ClaseMismoPaquete {

    /*
     * Otra clase en el mismo paquete:
     * -------------------------------
     * public: tendrá acceso.
     * protected: tendrá acceso.
     * por defecto: tendrá acceso.
     * private: no tendrá acceso.
     */

    public void acceso() {

        // Si creamos un objeto de la clase ClaseBase.
        ClaseBase claseBase = new ClaseBase();

        // Podremos acceder a la variable pública:
        System.out.printf("ClaseBase.variable_publica: %s.%n", claseBase.variable_publica);
        
        // También a la variable protegida:
        System.out.printf("ClaseBase.variable_protegida: %s.%n", claseBase.variable_protegida);
        
        // Y a la variable sin modificador:
        System.out.printf("ClaseBase.variable_sin_modificador: %s.%n", claseBase.variable_sin_modificador);

        // Pero no a la variable privada:
        // System.out.printf("ClaseBase.variable_privada: %s.%n",
        // claseBase.variable_privada);
    }
}
