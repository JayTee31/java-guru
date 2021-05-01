public class Solution76 {
    public static void main(String[] args) {
        // This program uses the "sieve of Eratosthenes" algorithm, look it up.
        final int NUMBER_LIMIT_FOR_SEARCH = 50;

        // The array starts with 2 and ends with NUMBER_LIMIT_FOR_SEARCH.
        final int[] numbers = new int[NUMBER_LIMIT_FOR_SEARCH - 1];

        for (int i = 0; i < NUMBER_LIMIT_FOR_SEARCH - 1; i++) {
            numbers[i] = i + 2;
        }
        showPrimes(numbers);
    }

    public static void showPrimes(final int[] numbers) {
        final boolean[] areNumbersPrimes = createAllTrueArray(numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            if (areNumbersPrimes[i]) {
                System.out.println(numbers[i]);

                for (int j = i + numbers[i]; j < numbers.length; j += numbers[i]) {
                    areNumbersPrimes[j] = false;
                }
            }
        }
    }

    public static boolean[] createAllTrueArray(final int size) {
        final boolean[] allTrueArray = new boolean[size];

        for (int i = 0; i < size; i++) {
            allTrueArray[i] = true;
        }
        return allTrueArray;
    }
}
