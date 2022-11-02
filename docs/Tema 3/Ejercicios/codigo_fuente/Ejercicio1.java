import java.util.Random;

public class Ejercicio1 {

    private static int devuelveAleatorio(int min, int max) {
        Random aleatorio = new Random();
        return aleatorio.nextInt(max - min) + min;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Es necesario introducir dos valores como argumentos min y max.");
        } else {
            int min = Integer.parseInt(args[0]);
            int max = Integer.parseInt(args[1]);

            Random rdm = new Random();

            int num1 = getRandom(min, max);
            int num2 = getRandom(min, max);

            System.out.printf("Los números generados fueron %d y %d.%n", num1, num2);

            System.out.printf("El mayor es: %d.%n", Math.max(num1, num2));
        }
    }

}
