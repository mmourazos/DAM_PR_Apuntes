public class Main {
    public static void main(String[] args) {
        MiClase mc = new MiClase(10);
        mc.metodo1();
        mc.metodo2();

        // También podemos indicar simplemente que la variable es de tipo Interfaz
        Comparable<MiClase> i = new MiClase(10);

        // Esto es lo que se hace en el caso de métodos que pueden ordenar cosas: Interfaz
        // Comparable.

        if (i.compareTo(new MiClase(10)) > 0) {
            System.out.println("Es mayor");
        } else {
            System.out.println("Es igual o menor");
        }

    }

}
