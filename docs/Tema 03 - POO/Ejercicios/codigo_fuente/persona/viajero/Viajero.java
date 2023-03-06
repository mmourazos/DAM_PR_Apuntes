package persona.viajero;

public class Viajero {
    private String DNI;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private String direccion;

    public Viajero(String DNI, String nombre, String apellidos, String nacionalidad,
            String direccion) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public static void main(String[] args) {
        System.out.println("Hola mundo.");
    }
}

