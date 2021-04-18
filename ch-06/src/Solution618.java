import java.util.Scanner;

public class Solution618 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final String password = input.nextLine();

        passwordChecker(password);
    }
    public static boolean isPasswordLongEnough(String str) {
        return str.length() >= 10;
    }

    public static boolean isPasswordOnlyContainsLettersAndDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            boolean isCharAlphabetic = Character.isAlphabetic(str.charAt(i));
            boolean isCharDigit = Character.isDigit(str.charAt(i));
            if (!isCharAlphabetic && !isCharDigit) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPasswordContainsThreeDigits(String str) {
        int digitCounter = 0;

        for (int i = 0; i < str.length(); i++) {
            boolean isCharDigit = Character.isDigit(str.charAt(i));

            if (isCharDigit) {
                digitCounter++;
            }
        }
        return digitCounter >= 3;
    }

    public static void passwordChecker(String str) {
        if (isPasswordLongEnough(str) && isPasswordOnlyContainsLettersAndDigits(str) && isPasswordContainsThreeDigits(str)) {
            System.out.println("Valid password");
        } else {
            System.out.println("Invalid password");
        }
    }
}
