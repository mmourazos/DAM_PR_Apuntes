package ejercicio3;

public class Circunferencia {
    private Punto centro;
    private double radio;

    public Circunferencia(Punto centro, double radio) {
        this.centro = centro;
        this.radio = radio;
    }

    public Circunferencia(double x, double y, double radio) {
        this(new Punto(x, y), radio);
    }

    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double area() {
        return Math.PI * Math.pow(radio, 2);
    }

    public double perimetro() {
        return 2 * Math.PI * radio;
    }
}
