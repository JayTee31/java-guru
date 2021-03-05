import java.util.Scanner;

public class Solution26 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter an integer number between 0 and 1000");
        final int wholeNumber = input.nextInt();
        final int digitNumberOne = wholeNumber % 10;

        if (digitNumberOne == 0) {
            System.out.println("The multiplication of all digits in " + wholeNumber + " is 0");
        }
        else {
            final int wholeNumberMinusLastDigit = wholeNumber / 10;
            if (wholeNumberMinusLastDigit == 0) {
                System.out.println("The multiplication of all digits in " + wholeNumber + " is "
                + digitNumberOne);
            } else {
                final int digitNumberTwo = wholeNumberMinusLastDigit % 10;
                if (digitNumberTwo == 0) {
                    System.out.println("The multiplication of all digits in " + WholeNumber + " is 0");
                } else {
                    final int wholeNumberMinustLastTwoDigits = wholeNumberMinusLastDigit / 10;
                    if (wholeNumberMinustLastTwoDigits == 0) {
                        System.out.println("The multiplication of all digits in " + wholeNumber + " is "
                        + (digitNumberOne * digitNumberOne));
                    } else {
                        final int digitNumberThree = wholeNumberMinustLastTwoDigits % 10;
                        System.out.println("The multiplication of all digits in " + wholeNumber + " is "
                        + (digitNumberOne * digitNumberTwo * digitNumberThree));
                    }
                }
            }
        }
    }
}