package herencia;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

public class ClaseHijaB extends ClaseHijaA {

    public ClaseHijaB(int x, int y) {
        super(x, y);
    }

    @Override
    public void metodoParaSobrescribir() {
        System.out.println("Metodo para sobrescribir (ClaseHijaB).");
    }

    public void accesoASuperclases() {

        ClaseHijaB chb = new ClaseHijaB(10, 20);

        System.out.println("Metodo de la clase padre:");
        ((ClasePadre) chb).metodoParaSobrescribir();

        System.out.println("Metodo de la clase hija A:");
        ((ClaseHijaA) chb).metodoParaSobrescribir();

        // También usando super:
        System.out.println("Metodo de la clase hija A (super):");
        super.metodoParaSobrescribir();

        System.out.println("Metodo de la clase hija B:");
        chb.metodoParaSobrescribir();
    }

    public static void main(String[] args) {
        ClaseHijaB chb = new ClaseHijaB(1, 2);
        chb.metodoHijo();
        chb.metodoPadre();
        System.out.println(chb.x);
        // System.out.println(chb.y); // Pues no es visible (privado).

        chb.show();

        chb.metodoParaSobrescribir();

        chb.metodoTest();

        chb.accesoASuperclases();
    }

}
