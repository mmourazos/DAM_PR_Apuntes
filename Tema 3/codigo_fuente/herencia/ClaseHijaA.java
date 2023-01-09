package herencia;
public class ClaseHijaA extends ClasePadre {
    public int x = 100;
    private int y = 200;

    public ClaseHijaA() {
        System.out.println("Constructor de la clase hija A.");
    }

    public ClaseHijaA(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void metodoHijo() {
        System.out.println("Metodo de la clase hija A.");
    }

    public void show() {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("super.x = " + super.x);
        // System.out.println("super.y = " + super.y);
    }

    @Override
    public void metodoParaSobreescribir() {
        System.out.println("Metodo para sobreescribir (ClaseHijaA).");
    }

    public void metodoTest() {
        ClasePadre cp = new ClasePadre();
        cp.j;
    }


}
