import java.util.Scanner;

public class Solution422 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter string s1:");
        final String s1 = input.nextLine();

        System.out.println("Enter string s2:");
        final String s2 = input.nextLine();

        final boolean isString1ContainsString2 = s1.contains(s2);

        if (isString1ContainsString2) {
            System.out.printf("%s is a substring of %s", s2, s1);
        } else {
            System.out.printf("%s is not a substring of %s", s2, s1);
        }
    }
}
