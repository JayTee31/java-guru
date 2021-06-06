import java.util.Scanner;

public class Application618 {
    public static final int DESIRED_PASSWORD_LENGTH = 10;
    public static final int DESIRED_NUMBER_OF_DIGITS = 3;

    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final String password = input.nextLine();

        if (passwordChecker(password)) {
            System.out.println("Valid password.");
        } else {
            System.out.println("Invalid password");
        }
    }

    public static boolean isPasswordLongEnough(String str) {
        return str.length() >= DESIRED_PASSWORD_LENGTH;
    }

    public static boolean isPasswordOnlyContainsLettersAndDigits(String str) {
        if (str.length() == 0) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            boolean isCharAlphabetic = Character.isAlphabetic(str.charAt(i));
            boolean isCharDigit = Character.isDigit(str.charAt(i));
            if (!isCharAlphabetic && !isCharDigit) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPasswordContainsEnoughDigits(String str) {
        int digitCounter = 0;

        for (int i = 0; i < str.length(); i++) {
            boolean isCharDigit = Character.isDigit(str.charAt(i));

            if (isCharDigit) {
                digitCounter++;
            }
        }
        return digitCounter >= DESIRED_NUMBER_OF_DIGITS;
    }

    public static boolean passwordChecker(String str) {
        return (isPasswordLongEnough(str) && isPasswordOnlyContainsLettersAndDigits(str) && isPasswordContainsEnoughDigits(str));
    }
}