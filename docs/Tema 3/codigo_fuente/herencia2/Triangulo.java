package herencia2;

public class Triangulo extends Poligono {
    private Punto a;
    private Punto b;
    private Punto c;

    public Triangulo(Punto a, Punto b, Punto c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangulo(Arista ab, Arista bc, Arista ca) {

    }

    @Override
    public double perimetro() {
        Arista ab = new Arista(a, b);
        Arista bc = new Arista(b, c);
        Arista ca = new Arista(c, a);

        return ab.longitud() + bc.longitud() + ca.longitud();
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public Arista[] getAristas() {
        // TODO Auto-generated method stub
        return null;
    }

}
