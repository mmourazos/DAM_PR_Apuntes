import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main
 */
public class Main {
    public static final int BYTES_TO_WRITE = 4096; // 4 KiB (4x2^10)
    public static final int BYTES_TO_SKIP = 0; // Cuantos bytes del array se saltarían al escribir.

    public static void writeTextToFile(String path, String txt) {
        try (FileWriter fw = new FileWriter(path); BufferedWriter writer = new BufferedWriter(fw)) {
            writer.write(txt);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void appendTextToFile(String fileName, String txt) {
        try (FileWriter fw = new FileWriter(fileName, true);
                BufferedWriter writer = new BufferedWriter(fw)) {
            writer.write(txt + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readTextFromFile(String path) {
        String line = null;
        String txt = "";
        boolean fin;

        try (FileReader fr = new FileReader(path); BufferedReader reader = new BufferedReader(fr)) {
            while ((line = reader.readLine()) != null) {
                txt += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return txt;
    }

    public static void writeBinaryToFile(String fileName, byte[] data) {
        try (OutputStream out = new FileOutputStream(fileName)) {
            out.write(data, BYTES_TO_SKIP, BYTES_TO_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee hasta 4KiB de un fichero y los devuelve en un array de bytes.
     * 
     * @param fileName Nombre del fichero del que se ha de leer.
     * @return Array de bytes con longitud iugal a los bytes leíds y null si no se pudo leer.
     */
    public static byte[] readBinaryFromFile(String fileName) {
        byte[] inputBytes = new byte[BYTES_TO_WRITE];

        try (InputStream input = new FileInputStream(fileName)) {
            int bytesRead = input.read(inputBytes, BYTES_TO_SKIP, BYTES_TO_WRITE);
            // Si read devuelve -1 es que no pudo leer nada.
            if (bytesRead == -1)
                return null;
            if (bytesRead < BYTES_TO_WRITE) {
                inputBytes = Arrays.copyOf(inputBytes, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputBytes;
    }

    public static byte[] readAllFromFile(String fileName) {
        byte[] fileData = null;
        try (InputStream input = new FileInputStream(fileName)) {
            fileData = input.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileData;
    }

    public static byte[] leeFichero(String path) throws IOException {
        byte[] bytesLeidos = null;

        try (FileInputStream entrada = new FileInputStream(path)) {
            bytesLeidos = entrada.readAllBytes();
        }

        return bytesLeidos;
    }

    public static boolean escribeFichero(String path, byte[] datos) {
        try (OutputStream salida = new FileOutputStream(path)) {
            salida.write(datos);
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        Console con = System.console();
        String fileName = "miFichero.txt";
        String outTxt =
                "La razón de la sinrazón que a mi razón se hace\nde tal manera mi razón enflaquece que\nCon razón me quejo de la vuestra fermosura.";
        String nombreFichEntrada, nombreFichSalida;

        // appendTextToFile(fileName, outTxt);

        // String inTxt = readTextFromFile(fileName);

        // System.out
        // .println("Texto leido: \n---Inicio del texto---\n" + inTxt + "---Fin del
        // texto---");

        // byte[] inBytes = readBinaryFromFile(fileName);

        // System.out.println(Arrays.toString(inBytes));
        Pattern patron = Pattern.compile("^[[a-zA-Zñáéíóú]\\-. ]+$");
        byte[] datosLeidos = new byte[BYTES_TO_WRITE];
        boolean fich_no_valido = false;
        do {
            try {
                nombreFichEntrada = con.readLine("Introduzca el nombre del fichero a copiar: ");
                Matcher matcher = patron.matcher(nombreFichEntrada);
                if (matcher.find()) {
                    fich_no_valido = true;
                    break;
                }
                datosLeidos = leeFichero(nombreFichEntrada);
            } catch (FileNotFoundException e) {
                fich_no_valido = true;
            }
        } while (fich_no_valido);

        nombreFichSalida = con.readLine("Introduzca un nombre para el fichero copia: ");
        escribeFichero(nombreFichSalida, datosLeidos);

        boolean cont = false;
        do {

        } while (cont);

    }

}
