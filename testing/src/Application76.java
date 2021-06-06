import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application76 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        System.out.println("Enter a search limit for primes");

        final int searchLimit = input.nextInt();

        System.out.println(listOfPrimes(searchLimit));
    }

    public static List<Integer> listOfPrimes(final int searchLimit) {
        if (searchLimit < 2) {
            throw new IllegalArgumentException("search limit has to be greater or equal than 2");
        }

        final int[] numbers = new int[searchLimit - 1];

        for (int i = 0; i < searchLimit - 1; i++) {
            numbers[i] = i + 2;
        }

        final boolean[] areNumbersPrimes = createAllTrueArray(numbers.length);

        List<Integer> listOfPrimes = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (areNumbersPrimes[i]) {
                listOfPrimes.add(numbers[i]);

                for (int j = i + numbers[i]; j < numbers.length; j += numbers[i]) {
                    areNumbersPrimes[j] = false;
                }
            }
        }
        return listOfPrimes;
    }

    public static boolean[] createAllTrueArray(final int size) {
        final boolean[] allTrueArray = new boolean[size];

        for (int i = 0; i < size; i++) {
            allTrueArray[i] = true;
        }
        return allTrueArray;
    }
}