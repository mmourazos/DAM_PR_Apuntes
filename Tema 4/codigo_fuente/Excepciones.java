import java.util.Random;

public class Excepciones {


    /*
     * En el siguiente método sólo admitiremos como parámetros valores positivos y que cumplan que
     * min < max.
     */
    public static int randomInt(int min, int max) {
        if (min < 0 || min >= max) {
            // Si no se cumplen nuestras restricciones lanzamos una excepción.
            throw new IllegalArgumentException(
                    String.format("min (%d) ha de ser menor que max (%d).", min, max));
        }
        // Si se lanza una excepción se termina la ejecución del método por lo que nunca llegaríamos
        // a esta línea de código.

        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        int min = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        try {
            System.out.println("Vamos a invocar \"randomInt\"");
            int aleatorio = randomInt(min, max);
            System.out.println(String.format("El número generado ha sido %d.", aleatorio));

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("the end.");
        }
    }
}
