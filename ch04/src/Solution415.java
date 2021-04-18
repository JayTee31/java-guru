import java.util.Scanner;

public class Solution415 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        System.out.println("Enter a letter:");

        final char character = input.nextLine().charAt(0);
        final int letterInUpperCaseNumeric = Character.toUpperCase(character);
        final int letterNumericStartingWithSix = letterInUpperCaseNumeric - (int)'A' + 6;

        if (Character.isLetter(character)) {
            if (letterNumericStartingWithSix < 'P' + 6 - 'A') {
                final int correspondingNumberUnderP = letterNumericStartingWithSix / 3;
                System.out.printf("The corresponding number is %d", correspondingNumberUnderP);

            } else if (letterNumericStartingWithSix < 'T' + 6 - 'A') {
                System.out.println("The corresponding number is 7");

            } else if (letterNumericStartingWithSix < 'W' + 6 - 'A') {
                System.out.println("The corresponding number is 8");

            } else {
                System.out.println("The corresponding number is 9");
            }
        } else {
            System.out.printf("%c is an invalid input", character);
        }
    }
}
