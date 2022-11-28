package ejercicio3;

public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double[] getCoordenadas() {
        double[] xy = {x, y};
        return xy;
    }

    public void setCoordenadas(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
