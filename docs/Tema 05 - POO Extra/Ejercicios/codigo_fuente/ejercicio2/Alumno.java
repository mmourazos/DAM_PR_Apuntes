package ejercicio2;

import java.text.ParseException;

public class Alumno extends Persona {
    private int nia;

    public Alumno(String nombre, String apellido1, String apellido2, String fechaNacimeintoString,
            int nia) throws ParseException {
        super(nombre, apellido1, apellido2, fechaNacimeintoString);
        this.nia = nia;
    }

    public int getNia() {
        return nia;
    }

    public void setNia(int nia) {
        this.nia = nia;
    }

}
