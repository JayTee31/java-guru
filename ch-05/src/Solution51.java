import java.util.Scanner;

public class Solution51 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your score:");
            final int score = input.nextInt();
            if (score == -1) {
                System.out.println("No numbers are entered except 0");
                break;
            } else if (score >= 60) {
                System.out.println("You pass the exam.\n");
            } else {
                System.out.println("You don't pass the exam.\n");
            }
        }
    }
}
