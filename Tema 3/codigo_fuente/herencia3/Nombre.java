package herencia3;

import java.text.Format;

public class Nombre {
    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    public Nombre(String nombre, String primerApellido) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = null;
    }

    public Nombre(String nombre, String primerApellido, String segundoApellido) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    @Override
    public String toString() {
        if (segundoApellido == null) {
            return String.format("%s %s", nombre, primerApellido);
        }

        return String.format("%s %s %s", nombre, primerApellido, segundoApellido);
    }
}
