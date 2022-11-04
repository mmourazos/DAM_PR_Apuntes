package herencia2;

import java.util.PrimitiveIterator;

public class Paralelogramo extends Poligono {
    private Punto a;
    private Punto b;
    private Punto c;
    private Punto d;

    public Paralelogramo(Punto a, Punto b, Punto c, Punto d) {

    }

    public Arista[] getAristas() {
        Arista[] aristas = new Arista[4];

        aristas[0] = new Arista(a, b);
        aristas[1] = new Arista(b, c);
        aristas[2] = new Arista(c, d);
        aristas[3] = new Arista(d, a);

        return aristas;
    }

    @Override
    public double perimetro() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double area() {
        // TODO Auto-generated method stub
        return 0;
    }

}
