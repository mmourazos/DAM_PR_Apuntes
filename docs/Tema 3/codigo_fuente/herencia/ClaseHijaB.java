package herencia;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

public class ClaseHijaB extends ClaseHijaA {

    public ClaseHijaB(int x, int y) {
        super(x, y);
    }

    @Override
    public void metodoParaSobreescribir() {
        System.out.println("Metodo para sobreescribir (ClaseHijaB).");
    }

    public void accesoASuperclases() {

        ClaseHijaB chb = new ClaseHijaB(10, 20);

        System.out.println("Metodo de la clase padre:");
        ((ClasePadre) chb).metodoParaSobreescribir();

        System.out.println("Metodo de la clase hija A:");
        ((ClaseHijaA) chb).metodoParaSobreescribir();

        // También usando super:
        System.out.println("Metodo de la clase hija A (super):");
        super.metodoParaSobreescribir();

        System.out.println("Metodo de la clase hija B:");
        chb.metodoParaSobreescribir();
    }

    public static void main(String[] args) {
        ClaseHijaB chb = new ClaseHijaB(1, 2);
        chb.metodoHijo();
        chb.metodoPadre();
        System.out.println(chb.x);
        // System.out.println(chb.y); // Pues no es visible (privado).

        chb.show();

        chb.metodoParaSobreescribir();

        chb.metodoTest();

        chb.accesoASuperclases();
    }

}
