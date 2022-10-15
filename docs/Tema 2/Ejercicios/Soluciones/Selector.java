import java.io.Console;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Selector {

    public static void main(String[] args) {
        do {
            Console con = System.console();

            System.out.print("Instroduzca el número del ejericicio a ejecutar (0 para terminar): ");

            String strIn = con.readLine();
            if (strIn.isBlank()) {
                continue;
            }

            if (strIn.equals("0")) {
                System.exit(0);
            }

            String exerName = "Ejercicio" + strIn;

            Class exerciseClass;
            try {
                exerciseClass = Class.forName(exerName);
                final Constructor constructor = exerciseClass.getConstructor((Class[]) null);
                Ejercicio exerciseObj;
                try {
                    exerciseObj = (Ejercicio) constructor.newInstance((Object[]) null);
                    exerciseObj.ejecutar();
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException | SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("Número de ejerccio no válido.");
                System.out.println("Pruebe con otro número...");
            }
        } while (true);
    }
}
