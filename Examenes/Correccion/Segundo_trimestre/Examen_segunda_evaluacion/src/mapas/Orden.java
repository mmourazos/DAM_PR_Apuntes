package mapas;

import java.util.LinkedHashMap;
import java.util.Map;

// Este código solo es de ayuda para el ejercicio. No es necesario utilizarlo.
public class Orden {
    public static void main(String[] args) {
        Map<Integer, String> mapa = new LinkedHashMap<>();

        mapa.put(3, "tres");
        mapa.put(2, "dos");
        mapa.put(1, "uno");

        System.out.println(mapa);
    }

}
