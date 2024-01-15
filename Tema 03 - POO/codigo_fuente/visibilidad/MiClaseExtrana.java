package visibilidad;
import visibilidad.paquete1.MiClase;

public class MiClaseExtrana {
    public static void main(String[] args) {
        MiClase mc = new MiClase();
        // Error: no se puede acceder a un miembro de clase con visibilidad por defecto desde fuera del paquete.
        System.out.println("mc.VISIBILIDAD_POR_DEFECTO = " + mc.VISIBILIDAD_POR_DEFECTO); 
    }
}