import java.util.Scanner;

public class Solution62 {
    public static void main(String[] args) {
        // A könyvben lévő "Hint" buzulás. Az int-long átváltás szintén.
        final Scanner input = new Scanner(System.in);

        final long number = input.nextLong();
        System.out.println(sumDigits(number));
    }

    public static int sumDigits(long n) { // long can hold more bits, so in case of n > Integer.MAX_VALUE, the cast won't work, just sayin'
        final String number = String.valueOf(Math.abs((int)n));     // Math.abs for negative input
        int sumDigits = 0;

        for (int i = 0; i < number.length(); i++) {
            sumDigits += (number.charAt(i) - '0');
        }
        return sumDigits;
    }
}
