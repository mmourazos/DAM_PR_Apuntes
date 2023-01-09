import java.util.Random;

public class WhileLoop {

    public static void bucleSinFin() {
        // Los bucles son estructura que repiten un bloque de código:
        do {
            System.out.println("¡Quiero salir de aquí!");
        } while (true);
    }

    public static void bucleConFin() {
        // Normalmente existe algún tipo de condición que indica hasta
        // cuando hay que repetir el bloque:
        Random r = new Random();
        int i = r.nextInt(10);
        while (i != 5) { // El bloque siguiente se repetirá mienstras i sea disinto de 5.
            i = r.nextInt(10); // Cambiamos algo que afecte a la condición de terminación.
        }
    }

    public static void main(String[] args) {


    }
}
