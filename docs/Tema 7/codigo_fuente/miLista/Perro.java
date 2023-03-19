public class Perro {
    String nombre;
    int edad;

    public Perro(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return nombre + " (" + edad + ")";
    }

}
