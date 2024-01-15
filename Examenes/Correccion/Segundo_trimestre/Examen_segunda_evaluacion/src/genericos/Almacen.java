package genericos;

public class Almacen<E> {
    private E elemento;

    public Almacen() {}

    public Almacen(E elemento) {
        this.elemento = elemento;
    }

    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public boolean isEmpty() {
        return elemento == null;
    }

}
