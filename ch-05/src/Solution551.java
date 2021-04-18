import java.util.Scanner;

public class Solution551 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final String str1 = input.nextLine();
        final String str2 = input.nextLine();
        String commonPrefix = "";

        for (int i = 0;; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                commonPrefix += str1.charAt(i);
            } else {
                break;
            }
        }
        if (commonPrefix.length() == 0) {
            System.out.printf("%s and %s have no common prefix", str1, str2);
        } else {
            System.out.printf("The two string's common prefix is: %s", commonPrefix);
        }
    }
}
