import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Prueba {
    public static void main(String[] args) {
        FileWriter fb;
        try {
            fb = new FileWriter("text.txt");
            BufferedWriter writer = new BufferedWriter(fb);
            writer.write("Hola mundo");
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Stack<String> stack = new Stack<String>();

    }
}
