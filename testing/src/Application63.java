import java.util.Scanner;

public class Application63 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer:");
        final int number = input.nextInt();

        if (isPalindrome(number)) {
            System.out.println("The number is a palindrome");
        } else {
            System.out.println("The number is not a palindrome");
        }
    }

    public static int reverse(int number) {     // Math.abs for negative input
        final String numberInString = String.valueOf(Math.abs(number));
        StringBuilder str = new StringBuilder();

        for (int i = numberInString.length() - 1; i >= 0; i--) {
            str.append(numberInString.charAt(i));
        }
        return Integer.parseInt(str.toString());
    }

    public static boolean isPalindrome(int number) {      // Math.abs for negative input
        return Math.abs(number) == Math.abs(reverse(number));
    }
}