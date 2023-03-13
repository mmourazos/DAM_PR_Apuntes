import java.util.Arrays;

public class NumerosE3 extends NumerosE2 {

    public NumerosE3(int[] values) {
        super(values);
    }

    public boolean isPrime(int number) {
        if (number <= 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(number); ++i) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public int[] primeNumbers() {
        int[] primes = new int[getValues().length];
        int primesLength = 0;
        for (int value : getValues()) {
            if (isPrime(value)) {
                primes[primesLength++] = value;
            }
        }
        return Arrays.copyOf(primes, primesLength);
    }

}
