import javax.sound.midi.Soundbank;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Lista<Perro> l = new Lista<>();

        l.append(new Perro("Churri", 10));
        l.append(new Perro("Puchi", 45));
        l.append(new Perro("Toby", 3));

        System.out.println(l);

    }
}