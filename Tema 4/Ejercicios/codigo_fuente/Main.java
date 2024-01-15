public class Main {
    public static void main(String[] args) {
        NumerosAL nal = new NumerosAL();

        // [ ]
        nal.insertar(1, 0);
        // [ 1 2]

        nal.insertar(2, 1);
        nal.insertar(3, 2);
        nal.insertar(5, 4);

        double d = Math.PI;
        System.out.println(nal);
    }
}
