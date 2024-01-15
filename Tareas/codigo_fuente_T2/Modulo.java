package docs.Tareas.codigo_fuente_T2;

public class Modulo {
    private String nombre;
    private String codigo;
    private int horas;
    private Ciclo ciclo;

    public Modulo(String nombre, String codigo, int horas, Ciclo ciclo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.horas = horas;
        this.ciclo = ciclo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

}
