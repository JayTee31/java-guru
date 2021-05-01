import java.util.Scanner;

public class Solution631 {
    public static void main(String[] args) {
        // csak hogy megkönnyítsem a dolgod:
        // első összeadós example: 4388576018402626, két teszt: valid: 4388576018410707, invalid: 4388576018402626
        final Scanner input = new Scanner(System.in);
        final long number = input.nextLong();

        if (isValid(number)) {
            System.out.println("The card number is valid");
        } else {
            System.out.println("The card number is invalid");
        }
    }

    public static boolean isValid(long number) {
        return (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0
                && getSize(number) >= 13 && getSize(number) <= 16
                && prefixMatched(getPrefix(number));
    }

    public static int sumOfDoubleEvenPlace(long number) {
        int sumOfDigits = 0;
        final String numberInString = String.valueOf(number);

        for (int i = getSize(number) - 2; i >= 0; i -= 2) {
            sumOfDigits += getDigit((numberInString.charAt(i) - (int)'0') * 2);
        }
        return sumOfDigits;
    }

    public static int getDigit(int number) {
        if (number < 10) {
            return number;

        } else {
            final String numberInString = String.valueOf(number);
            return numberInString.charAt(0) - (int)'0' + numberInString.charAt(1) - (int)'0';
        }
    }

    public static int sumOfOddPlace(long number) {
        int sumOfDigits = 0;
        final String numberInString = String.valueOf(number);

        for (int i = getSize(number) - 1; i >= 0; i -= 2) {
            sumOfDigits += numberInString.charAt(i) - (int)'0';
        }
        return sumOfDigits;
    }

    public static boolean prefixMatched(int d) { // a getPrefixxel tartozik össze, nemtudom a könyv mit akar, de én így oldom meg.
        switch (d) {                                // a long number nem kell
            case 4:
            case 5:
            case 6:
            case 37: return true;
            default: return false;
        }
    }

    public static int getSize(long number) {
        return String.valueOf(number).length();
    }

    public static int getPrefix(long number) {  // A könyvben ez egy baromság, "int k" nem kell, a long visszatérési érték meg bullshit (szerintem)
        final String numberInString = String.valueOf(number);            // már ha ez az egész arra való h leellenőrízzük h Visa, Mastercard stb-e

        if (numberInString.charAt(0) - (int)'0' == 3) {
            return Integer.parseInt(numberInString.substring(0, 2));
        } else {
            return numberInString.charAt(0) - (int)'0';
        }
    }
}
