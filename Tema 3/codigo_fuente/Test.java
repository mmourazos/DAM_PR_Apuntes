import herencia2.Arista;
import herencia2.Punto;
import herencia3.Ciudadano;
import herencia3.Nombre;

public class Test {
    public static void main(String[] args) {
        // Punto p = new Punto();
        // Arista ar = new Arista(0, 0, 10, 10);
        // System.out.printf("Objeto: %s.%n", ar);
        // System.out.printf("Longitud = %g.%n", ar.longitud);

        Nombre nombre = new Nombre("Manuel Cayetano", "Piñeiro", "Mourazos");
        Ciudadano ciudadano = new Ciudadano(nombre, 653850955);

    }
}
