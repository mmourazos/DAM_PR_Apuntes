package herencia.herencia4;

import java.net.SocketTimeoutException;

import javax.sound.sampled.SourceDataLine;

public class ClaseA extends ClasePadre {
    // @Override
    // public String toString() {
    // return "Hola mundo.";
    // }

    public void setA(int a) {
        super.setA(a);
    }

    @Override
    public int suma() {
        System.out.println("Suma en clase A.");
        return i + getA();
    }

    public void metodoCHija() {
        System.out.println("cosas");
    }

    public static void main(String[] args) {
        ClasePadre p = new ClasePadre();

        ClaseA a = new ClaseA();

        Object o = a;

        if (o.getClass() == ClaseA.class) {
            System.out.println("WTF?");

            ((ClaseA) o).metodoCHija();
        }

        System.out.println(p.getClass().getName());

        // p.suma();

    }
}
