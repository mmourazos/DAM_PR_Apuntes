package ejercicio3;

public class Recta {
    private Punto p1;
    private Punto p2;

    public Recta(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Punto getP1() {
        return p1;
    }

    public void setP1(Punto p1) {
        this.p1 = p1;
    }

    public Punto getP2() {
        return p2;
    }

    public void setP2(Punto p2) {
        this.p2 = p2;
    }

    public double pendiente() {
        return (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
    }

}
