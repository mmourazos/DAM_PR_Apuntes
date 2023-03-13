public class Condicional {
    public static void main(String[] args) {
        // Una condición es una sentencia que se evaluará como verdaero o falso:
        int x = 10;
        int y = 20;
        boolean condicion = x == 10; // x == 0 se evalua a verdadero.
        condicion = x < 10; // x < 0 se evaluará a falso.
        condicion = x > 10; // x > 0 se evaluará a falso.

        // Una estructura condicional seleccionará el código a ejecutar
        // dependiendo del resultado (true / false) de la condición.
        // Ejemplo de estructura if-then
        if (x < 10) {
            System.out.println("X es menor que 10.");
        } else {
            System.out.println("X es mayor o igual que 10.");
        }

        // También disponemos de la estructura if-else-if cuando queremos
        // encadenar varias condiciones.
        if (x == 10) {
            System.out.println("X es igual a 10.");
        } else if (x < 10) {
            System.out.println("X es menor que 10.");
        } else {
            System.out.println("X es mayor que 10.");
        }
    }

}
