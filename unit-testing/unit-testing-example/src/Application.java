import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * # Primes Between
 *
 * ## Requirements
 *
 *   * Reads a lower bound and an upper bound from stdin.
 *   * Outputs the primes in [lower, upper) to stdout, separated with commas.
 *   * Errors out if
 *     * lower >= upper
 *     * lower < 2
 *     * lower || upper is not a number.
 *
 * ## Examples
 *
 * ### Happy Path
 *
 * #### Input
 * 2 7
 *
 * #### Output
 * 2, 3, 5
 *
 */
public class Application {
    public static final String THE_UPPER_BOUND_MUST_BE_GREATER_THAN_THE_LOWER_BOUND =
            "The upper bound must be greater than the lower bound.";
    public static String LOWER_BOUND_ERROR_CODE = "The lower bound must be greater than or equal to 2.";
    public static String VALIDATION_SUCCESS = "Success";

    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        final int lower = input.nextInt();
        final int upper = input.nextInt();

        final String validationResult = validateBounds(lower, upper);

        if (VALIDATION_SUCCESS.equals(validationResult)) {
            System.out.println(validationResult);
            System.exit(1);
        }

        final List<Integer> primes = primesBetween(lower, upper);

        final String output = formatNumbers(primes);

        System.out.println(output);
    }

    public static String validateBounds(final int lower, final int upper) {
        if (lower < 2) {
            return LOWER_BOUND_ERROR_CODE;
        }

        if (upper <= lower) {
            return THE_UPPER_BOUND_MUST_BE_GREATER_THAN_THE_LOWER_BOUND;
        }

        return VALIDATION_SUCCESS;
    }

    public static String formatNumbers(final List<Integer> numbers) {
        return numbers.stream()
                // ---------- [Integer, Integer, Integer]
                .map(Object::toString)
                // ---------- [String, String, String]
                .collect(Collectors.joining(", "));
                // ---------- String
    }

    public static List<Integer> primesBetween(final int lower, final int upper) {
        final List<Integer> primes = new ArrayList<>();
        for (int number = lower; number < upper; ++number) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }

        return primes;
    }

    public static boolean isPrime(final int number) {
        if (number == 2) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        boolean isPrime = true;
        for (int divisor = 3; divisor < number; divisor += 2) {
            if (number % divisor == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
