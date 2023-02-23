package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// Este código solo es de ayuda para el ejercicio. No es necesario utilizarlo.
public class Main {

    public static void insertaPrimeraLinea(String nombreFichero, String texto) {
        // Leer el contenido del fichero y añadirlo a textoNuevo.
        StringBuilder textoNuevo = new StringBuilder("texto" + "\n");
        try (BufferedReader br =
                new BufferedReader(new FileReader(nombreFichero, StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                textoNuevo.append(linea + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Escribir el nuevo texto en el fichero.
        try (BufferedWriter bw =
                new BufferedWriter(new java.io.FileWriter(nombreFichero, StandardCharsets.UTF_8))) {
            bw.write(textoNuevo.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertaPrimeraLineaBinario(String nombreFichero, String texto) {
        byte[] bytesTexto = texto.getBytes(StandardCharsets.UTF_8);
        byte[] contenidoFichero = null;

        // Leer el contenido del fichero.
        try (FileInputStream fis = new FileInputStream(nombreFichero)) {
            contenidoFichero = fis.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Escribir en el fichero añaadiendo el texto al principio.
        try (FileOutputStream fos = new FileOutputStream(nombreFichero)) {
            fos.write(bytesTexto);
            fos.write(contenidoFichero);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String nombreFichero = "fichero.txt";
        String texto = "texto";

        insertaPrimeraLinea(nombreFichero, texto);
        insertaPrimeraLineaBinario(nombreFichero, texto);
    }
}
