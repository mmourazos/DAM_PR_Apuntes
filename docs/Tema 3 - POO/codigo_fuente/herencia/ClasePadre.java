package herencia;

/**
 * ClasePadre
 */
public class ClasePadre {
    int j = 15;
    public int x = 10;
    private int y = 20; // No será visible en las clases hijas.
    protected int z = 30;

    public ClasePadre() {
        System.out.println("Constructor de la clase padre.");
    }

    public ClasePadre(int x, int y) {
        System.out.println("Constructor de la clase padre con argumentos.");
        this.x = x;
        this.y = y;
    }

    public void metodoPadre() {
        System.out.println("Metodo de la clase padre.");
    }

    public void metodoParaSobrescribir() {
        System.out.println("Metodo para sobrescribir (ClasePadre).");
    }

    public void saludo() {
        System.out.println("Hola desde ClasePadre.");
    }
}
