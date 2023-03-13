import mipaquete.Clase;
import mipaquete.Subclase;

/**
 * Main
 */
public class Main {

    /**
     * Método principal de la clase.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        Clase c = new Clase(5);
        System.out.println(c);
        System.out.println(c.dimePropiedad());
        System.out.println(c.getPropiedad());
        c.setPropiedad(10);
        System.out.println(c);
        System.out.println(c.dimePropiedad());
        System.out.println(c.getPropiedad());
        Subclase s = new Subclase(15);
        System.out.println(s);
        System.out.println(s.getAtributo());
        s.setAtributo(20);
        System.out.println(s);
        System.out.println(s.getAtributo());
    }
}
