public class MiClase implements Interfaz, Comparable<MiClase> {
    private int valor;

    public MiClase(int valor) {
        this.valor = valor;
    }

    @Override

    public void metodo1() {

        System.out.println("Hola");

    }

    @Override
    public void metodo2() {
        System.out.println("Adios");
    }

    @Override
    public int compareTo(MiClase o) {
        // TODO Auto-generated method stub
        return this.valor - o.valor;
    }
}
