import java.util.ArrayList;

public class NumerosAL {
    private ArrayList<Integer> contenido = new ArrayList<>();

    public void insertar(int valor, int posicion) {
        contenido.add(posicion, valor);
    }

    public int length() {
        return contenido.size();
    }

    public int total() {
        int total = 0;
        for (Integer i : contenido) {
            total += i;
        }

        return total;
    }

    public double media() {
        return total() / length();
    }

    public int delete(int posicion) {
        return contenido.remove(posicion);
    }

    @Override
    public String toString() {
        return "NumerosAL [contenido=" + contenido + "]";
    }
}
