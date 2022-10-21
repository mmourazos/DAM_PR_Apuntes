public class ClaseHija extends ClasePadre {
    public int x = 100;
    private int y = 200;

    public ClaseHija() {
        System.out.println("Constructor de la clase hija");
    }

    public ClaseHija(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void metodoHijo() {
        System.out.println("Metodo de la clase hija");
    }

    public void show() {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("super.x = " + super.x);
        // System.out.println("super.y = " + super.y);
    }

    @Override
    public void metodoParaSobreescribir() {
        System.out.println("Metodo para sobreescribir de la clase hija");
    }

    public void metodoTest() {
        super.metodoParaSobreescribir();
    }

    public static void main(String[] args) {
        ClaseHija ch = new ClaseHija(1, 2);
        ch.metodoHijo();
        ch.metodoPadre();
        System.out.println(ch.x);
        System.out.println(ch.y);

        ch.show();

        ch.metodoParaSobreescribir();

        ch.metodoTest();
    }
}
