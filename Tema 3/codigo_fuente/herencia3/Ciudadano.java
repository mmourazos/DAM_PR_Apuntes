package herencia3;

public class Ciudadano {
    public static final char[] TABLA_LETRA_DNI = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',
            'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

    private Nombre nombre;

    private int dni;

    public Ciudadano(Nombre nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public static char calculaLetraDNI(int dni) {
        return TABLA_LETRA_DNI[dni % 23];
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getDni() {
        return dni + calculaLetraDNI(dni);
    }

    @Override
    public String toString() {
        return String.format("%s%n%s", getDni(), nombre);
    }

}
