public class Solution626 {
    public static void main(String[] args) {
        first120PalindromePrimes();
    }

    public static void first120PalindromePrimes() {
        int loopActivationCounter = 0;
        int palindromePrimesCounter = 0;
        final int howManyNumbersWeWant = 120;

        for (int i = 1;; i++) {
            if (loopActivationCounter == 10) {
                System.out.println();
                loopActivationCounter = 0;
            }

            if (isPalindrome(i) && isPrime(i)) {
                System.out.printf("%d ", i);
                loopActivationCounter++;
                palindromePrimesCounter++;
            }

            if (palindromePrimesCounter == howManyNumbersWeWant) {
                break;
            }
        }
    }

    public static int reverse(int number) {
        final String numberInString = String.valueOf(number);
        StringBuilder str = new StringBuilder();

        for (int i = numberInString.length() - 1; i >= 0; i--) {
            str.append(numberInString.charAt(i));
        }
        return Integer.parseInt(str.toString());
    }

    public static boolean isPalindrome(int number) {
        return number == reverse(number);
    }

    public static boolean isPrime(final int n) {
        if (n == 2) {
            return true;
        }
        if (n <= 1 || n % 2 == 0) {
            return false;
        }
        for (int i = 3; i < (n / 2); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
