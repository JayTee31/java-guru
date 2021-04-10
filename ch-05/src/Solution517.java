import java.util.Scanner;

public class Solution517 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer between 1 and 15");
        final int number = input.nextInt();

        if (number >= 1 && number <= 15) {
            for (int n = 0; n < number; n++) {
                for (int i = number - n; i >= 1; i--) {
                    System.out.printf("%d ", i);
                }

                for (int j = 2; j <= number - n; j++) {
                    System.out.printf("%d ", j);
                }
                System.out.println();
            }
        } else {
            System.out.println("Next time enter an integer between 1 and 15 ........");
        }
    }
}
