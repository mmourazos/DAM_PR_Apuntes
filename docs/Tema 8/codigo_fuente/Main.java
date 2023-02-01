import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Main
 */
public class Main {
    public static final int BYTES_NUMBER = 4096; // 4 KiB (4x2^10)
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
        try (FileReader fr = new FileReader(path); BufferedReader reader = new BufferedReader(fr)) {
            do {
                line = reader.readLine();
                if (line != null)
                    txt += line + "\n";
            } while (line != null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return txt;
    }

    public static void writeBinaryToFile(String fileName, byte[] data) {
        try (OutputStream out = new FileOutputStream(fileName)) {
            out.write(data, BYTES_TO_SKIP, BYTES_NUMBER);
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
        byte[] inputBytes = new byte[BYTES_NUMBER];


        try (InputStream input = new FileInputStream(fileName)) {
            int bytesReaded = input.read(inputBytes, BYTES_TO_SKIP, BYTES_NUMBER);
            // Si read devuelve -1 es que no pudo leer nada.
            if (bytesReaded == -1)
                return null;
            if (bytesReaded < BYTES_NUMBER) {
                inputBytes = Arrays.copyOf(inputBytes, bytesReaded);
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

    public static void main(String[] args) {
        String fileName = "miFichero.txt";
        String outTxt =
                "La razón de la sinrazón que a mi razón se hace\nde tal manera mi razón enflaquece que\nCon razón me quejo de la vuestra fermosura.";

        appendTextToFile(fileName, outTxt);

        String inTxt = readTextFromFile(fileName);

        System.out
                .println("Texto leido: \n---Inicio del texto---\n" + inTxt + "---Fin del texto---");

        byte[] inBytes = readBinaryFromFile(fileName);

        System.out.println(Arrays.toString(inBytes));
    }
}

