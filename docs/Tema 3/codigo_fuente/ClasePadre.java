/**
 * ClasePadre
 */
public class ClasePadre {
    public int x = 10;
    private int y = 20; // No será visible en las clases hijas.

    public ClasePadre() {
        System.out.println("Constructor de la clase padre");
    }

    public ClasePadre(int x, int y) {
        System.out.println("Constructor de la clase padre con argumentos");
        this.x = x;
        this.y = y;
    }

    public void metodoPadre() {
        System.out.println("Metodo de la clase padre");
    }

    public void metodoParaSobreescribir() {
        System.out.println("Metodo para sobreescribir");
    }
}
