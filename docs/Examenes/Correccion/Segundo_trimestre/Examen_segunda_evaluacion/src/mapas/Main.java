package mapas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    // TODO: Modificar la firma del método para que reciba un mapa de cadenas y listas de enteros.
    public static void recorreMapa(Map<String, List<Integer>> mapa) {
        // TODO: Recorrer el mapa y mostrar por pantalla los valores.
        for (Entry<String, List<Integer>> entry : mapa.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // TODO: Crear un mapa que tenga cadenas como clave y listas de enteros como valor.
        Map<String, List<Integer>> mapa = new HashMap<>(3);

        // TODO: Añadir 3 elementos al mapa.
        mapa.put("uno", List.of(1));
        mapa.put("dos", List.of(1, 2));
        mapa.put("tres", List.of(1, 2, 3));

        // TODO: Modificar el valor del segundo elemento.
        mapa.put("dos", List.of(1, 2, 3, 4, 5, 6));


        recorreMapa(mapa);
    }



}
