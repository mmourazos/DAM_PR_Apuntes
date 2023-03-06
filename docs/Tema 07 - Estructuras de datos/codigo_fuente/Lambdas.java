import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Lambdas
 */
public class Lambdas {

    @FunctionalInterface
    interface Function6<One, Two, Three, Four, Five, Six> {
        public Six apply(One one, Two two, Three three, Four four, Five five);
    }

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> suma = (x, y) -> x + y;
        int x = 10;
        int y = 20;
        int z = suma.apply(x, y);

        Function<String, Integer> strToInt = s -> Integer.parseInt(s);
        Function<Integer, String> intToStr = (i) -> {
            switch (i) {
                case 0:
                    return "cero";
                case 1:
                    return "uno";
                case 2:
                    return "dos";
                case 3:
                    return "tres";
                case 4:
                    return "cuatro";
                case 5:
                    return "cinco";
                case 6:
                    return "seis";
                case 7:
                    return "siete";
                case 8:
                    return "ocho";
                case 9:
                    return "nueve";
                default:
                    return null;
            }
        };

        Function6<String, String, String, String, String, String> concat =
                (a, b, c, d, e) -> a + b + c + d + e;
    }
}
