package herencia.herencia4;

public class ClasePadre {
    private static int c = 0;
    public final int I = 10;
    public int i = 0;
    private int a = 20;

    public ClasePadre() {
        c++;
    }

    public ClasePadre(int i, int a) {
        c++;

        this.i = i;
        this.a = a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    @Override
    public String toString() {
        return String.format("c = %d, i = %d, I = %d, a = %d.%n", c, i, I, a);
    }

    public int suma() {
        System.out.println("Suma en padre.");
        return i + a;
    }

}
