import java.util.Iterator;
import java.util.NoSuchElementException;

public class AbcedearioStr implements Iterable<Character> {

    /*
     * Almacenamos los datos internos del abecedario en un String simplemente para mostrar que no
     * importa el tipo de datos que se utilice para almacenar los datos internos de la clase. Es
     * decir, siempre que sean privados y no se expongan a los clientes de la clase.
     */

    private String abecedario = "abcdefghijklmnñopqrstuvwxyz";

    @Override
    public VocIt iterator() {
        return new VocIt();
    }

    /*
     * Este iterador itera sobre todas las letras del abecedario (con hasNext() y next()) y sobre
     * las vocales (con hasNextVocal() y nextVocal()).
     */
    class VocIt implements Iterator<Character> {
        private int pos = 0;
        private int[] vocPos = {0, 4, 8, 15, 21};

        @Override
        public boolean hasNext() {
            return pos < abecedario.length();
        }

        @Override
        public Character next() {
            return abecedario.charAt(pos++);
        }

        public boolean hasNextVocal() {
            return pos <= vocPos[vocPos.length - 1];
        }

        public Character nextVocal() {
            if (!hasNextVocal()) {
                throw new NoSuchElementException();
            } else {
                for (int i = 0; i < vocPos.length; i++) {
                    if (pos <= vocPos[i]) {
                        pos = vocPos[i];
                        break;
                    }
                }
                return abecedario.charAt(pos++);
            }

        }
    }
}
