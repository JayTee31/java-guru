import java.util.Scanner;

public class Solution623 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter a String:");
        final String str = input.nextLine();

        System.out.println("Enter a character:");
        final char a = input.nextLine().charAt(0);

        System.out.printf("The character '%c' appears %d times in the String", a, count(str, a));
    }
    public static int count(String str, char a) {
        int charCount = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a) {
                charCount++;
            }
        }
        return charCount;
    }
}
