package paquete.visibilidad;

public class SubclaseMismoPaquete extends ClaseBase {

    public void acceso() {

        /*
         * Subclase en el mismo paquete:
         * public: tendrá acceso.
         * protected: tendrá acceso.
         * sin modificador: tendrá acceso.
         * private: no tendrá acceso.
         */

        // Podemos acceder a la variable pública (modificador public):
        System.out.println(this.variable_publica);

        // Podemos acceder a la variable con acceso por defecto (sin modificador):
        System.out.println(this.variable_sin_modificador);

        // Podemos acceder también a la variable protegida (modificador protected):
        System.out.println(this.variable_protegida);

        // No podremos acceder a la variable privada (modificador private):
        // System.out.println(this.variable_privada);
    }
}
