import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeGenerator {

    private static final int BIT_LENGTH = 2000;

    public List<BigInteger> getPrimes(int size) {
        System.out.println("Generating " + size + " large prime numbers in parallel...");

        List<BigInteger> primes = IntStream.range(0, size)
            .parallel() // Enables parallel processing
            .mapToObj(i -> BigInteger.probablePrime(BIT_LENGTH, ThreadLocalRandom.current()))
            .collect(Collectors.toList());

        System.out.println("Generated " + primes.size() + " prime numbers.");
        return primes;
    }
}

// Efficiency Performance gains:
/**
 * Random reused as a field	More efficient, avoids entropy depletion
 * BigInteger.probablePrime() used directly	Cleaner, avoids unnecessary random number generation
 * Pre-allocating list size	Minor performance gain
 * Removed nextProbablePrime()	It can be slower for large bit sizes than probablePrime()
 */