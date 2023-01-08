package docs.Tareas.codigo_fuente_T2;

import java.util.ArrayList;

public class Ciclo {
    private String nombre;
    private String codigo;
    private ArrayList<Modulo> modulos;

    public Ciclo(String nombre, String codigo, ArrayList<Modulo> modulos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.modulos = modulos;
    }

    public int getHoras() {
        int horas = 0;
        for (Modulo modulo : modulos) {
            horas += modulo.getHoras();
        }
        return horas;
    }
}
