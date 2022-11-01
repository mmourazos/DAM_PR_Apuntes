package visibilidad;

import paquete.visibilidad.ClaseBase;

public class SubclaseOtroPaquete extends ClaseBase {

    /*
     * Subclase en otro paquete
     * ------------------------------------------------------------
     * public: tendrá acceso.
     * protected: tendrá acceso. (por ser subclase)
     * default: no tendrá acceso.
     * private: no tendrá acceso.
     */
    public void acceso() {
        // Podemos acceder a la variable pública:
        System.out.printf("ClaseBase.variable_publica: %s.%n", this.variable_publica);

        // No podremos acceder a la variable con acceso por defecto:
        // System.out.printf("ClaseBase.variable_sin_modificador: %s.%n",
        // this.variable_sin_modificador);

        // Sí podremos acceder a la variable protegida:
        System.out.printf("ClaseBase.variable_protegida", this.variable_protegida);

        // Y obviamente no podremos acceder a la variable privada:
        // System.out.printf("ClaseBase.variable_privada: %s.%n",
        // this.variable_privada);
    }
}
