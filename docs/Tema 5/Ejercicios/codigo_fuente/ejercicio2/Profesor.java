package ejercicio2;

import java.sql.Date;
import java.text.ParseException;

public class Profesor extends Trabajador {
    private String departamento;

    public Profesor(String nombre, String apellido1, String apellido2, String fechaNacimeintoString,
            int nrp, String departamento) throws ParseException {
        super(nombre, apellido1, apellido2, fechaNacimeintoString, nrp);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
