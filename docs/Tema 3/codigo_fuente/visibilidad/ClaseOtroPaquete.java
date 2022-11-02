package visibilidad;

import paquete.visibilidad.ClaseBase;

public class ClaseOtroPaquete {

    /*
     * Otra clase en otro paquete:
     * ---------------------------
     * public: tendrá acceso.
     * protected: no tendrá acceso.
     * sin modificador: no tendrá acceso.
     * private: no tendrá acceso.
     */

    public void acceso() {
        ClaseBase claseBase = new ClaseBase();

        // Propiedad pública: tendrá acceso:
        System.out.printf("ClaseBase.variable_publica: %s.%n", claseBase.variable_publica);

        // Propiedad protected: no tendrá acceso:
        // System.out.printf("ClaseBase.variable_publica: %s.%n",
        // claseBase.variable_protegida);

        // Propiedad sin modificador / por defecto: no tendrá acceso.
        // System.out.printf("ClaseBase.variable_publica: %s.%n",
        // claseBase.variable_sin_modificador);

        // Propiedad privada: no tendrá acceso.
        // System.out.printf("ClaseBase.variable_publica: %s.%n",
        // claseBase.variable_privada;
    }
}
