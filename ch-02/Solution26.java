import java.util.Scanner;

public class Solution26 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter an integer number between 0 and 1000");
        final int WholeNumber = input.nextInt();
        final int DigitNumberOne = WholeNumber % 10;

        if (DigitNumberOne == 0) {
            System.out.println("The multiplication of all digits in " + WholeNumber + " is 0");
        }
        else {
            final int WholeNumberMinusLastDigit = WholeNumber / 10;
            if (WholeNumberMinusLastDigit == 0) {
                System.out.println("The multiplication of all digits in " + WholeNumber + " is "
                + DigitNumberOne);
            }
            else {
                final int DigitNumberTwo = WholeNumberMinusLastDigit % 10;
                if (DigitNumberTwo == 0) {
                    System.out.println("The multiplication of all digits in " + WholeNumber + " is 0");
                }
                else {
                    final int WholeNumberMinustLastTwoDigits = WholeNumberMinusLastDigit / 10;
                    if (WholeNumberMinustLastTwoDigits == 0) {
                        System.out.println("The multiplication of all digits in " + WholeNumber + " is "
                        + (DigitNumberOne * DigitNumberOne));
                    }
                    else {
                        final int DigitNumberThree = WholeNumberMinustLastTwoDigits % 10;
                        System.out.println("The multiplication of all digits in " + WholeNumber + " is "
                        + (DigitNumberOne * DigitNumberTwo * DigitNumberThree));
                    }
                }
            }
        }
    }
}