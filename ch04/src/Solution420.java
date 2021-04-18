import java.util.Scanner;

public class Solution420 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        System.out.println("Enter a string:");

        final String str = input.nextLine();

        System.out.printf("Its length is %d and its last character is %c", str.length(), str.charAt(str.length() - 1));
    }
}
