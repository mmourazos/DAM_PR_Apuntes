package docs.Tareas.codigo_fuente_T2;

public class Matricula {
    private Persona alumno;
    private Ciclo ciclo;

    public Matricula(Persona alumno, Ciclo ciclo) {
        this.alumno = alumno;
        this.ciclo = ciclo;
    }

    public Persona getAlumno() {
        return alumno;
    }

    public void setAlumno(Persona alumno) {
        this.alumno = alumno;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public boolean isAlumno(Persona alumno) {
        return this.alumno.equals(alumno);
    }
}