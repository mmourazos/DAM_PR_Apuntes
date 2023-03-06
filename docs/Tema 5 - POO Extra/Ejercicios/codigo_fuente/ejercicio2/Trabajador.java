package ejercicio2;

import java.text.ParseException;

public class Trabajador extends Persona {
    private int nrp;

    public Trabajador(String nombre, String apellido1, String apellido2,
            String fechaNacimeintoString, int nrp) throws ParseException {
        super(nombre, apellido1, apellido2, fechaNacimeintoString);
        this.nrp = nrp;
    }


    public int getNia() {
        return nrp;
    }

    public void setNia(int nia) {
        this.nrp = nia;
    }


}
