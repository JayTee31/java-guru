import java.util.Scanner;

public class Solution514 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter two positive integers:");
        final int number1 = input.nextInt();
        final int number2 = input.nextInt();
        int higherNumber = 0;
        int lowerNumber = 0;

        if (number1 > 0 && number2 > 0) {
            if (number1 - number2 > 0) {
                higherNumber = number1;
                lowerNumber = number2;
            } else {
                higherNumber = number2;
                lowerNumber = number1;
            }

            for (int i = lowerNumber;; i--) {
                if (lowerNumber % i == 0 && higherNumber % i == 0) {
                    System.out.println("Greatest common divisor: " + i);
                    break;
                }
            }
        } else {
            System.out.println("Enter positive numbers please");
        }
    }
}
