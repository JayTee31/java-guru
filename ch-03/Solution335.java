import java.util.Scanner;

public class Solution335 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final int number = input.nextInt();
        final boolean isIntegerEven = number % 2 == 0;

        if (isIntegerEven) {
            System.out.println(number + " is even");
        } else {
            System.out.println(number + " is odd");
        }
    }
}