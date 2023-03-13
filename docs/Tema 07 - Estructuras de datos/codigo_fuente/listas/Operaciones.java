import java.util.List;

public class Operaciones {
    public void borrar(List<Integer> l) {
        for (int i = 0; i < l.size(); ++i) {
            l.remove(i);
        }
    }
}
