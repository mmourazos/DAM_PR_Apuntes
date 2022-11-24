public class Matricula {
    private Alumno alumno;
    private Ciclo ciclo;

    public Matricula(Alumno alumno, Ciclo ciclo) {
        this.alumno = alumno;
        this.ciclo = ciclo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public boolean isAlumno(Alumno alumno) {
        return this.alumno.equals(alumno);
    }
}