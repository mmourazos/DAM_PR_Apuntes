package herencia2;

public class Arista {
    private Punto a = new Punto();
    private Punto b = new Punto();

    public Arista(Punto a, Punto b) {
        this.a = a;
        this.b = b;
    }

    public Arista(int ax, int ay, int bx, int by) {
        a = new Punto(ax, ay);
        b = new Punto(bx, by);
    }

    public double longitud() {
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }

    public Punto getPointA() {
        return a;
    }

    public Punto getPointB() {
        return b;
    }

    public boolean unidaA(Arista ar) {
        if (b.equals(ar.getPointA())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Arista de %s a %s.%n", a, b);
    }
}
