public class Ejercicio3 {
    public class Viajero {
        private String DNI;
        private String nombre;
        private String apellidos;
        private String nacionalidad;
        private String direccion;

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
    }
}
