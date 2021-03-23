import java.util.Scanner;

public class Solution48 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter a character:");
        final String characterInString = input.nextLine();

        if (characterInString.length() != 1) {
            System.out.println("Enter only one character please");
        } else {
            final char characterInChar = characterInString.charAt(0);
            final int characterInAscii = (int)characterInChar;

            if (characterInAscii <= 127) {
                System.out.printf("The ASCII code for character %c is %d", characterInChar, characterInAscii);
            } else {
                System.out.println("This character doesn't have an ASCII code");
            }
        }

    }
}
