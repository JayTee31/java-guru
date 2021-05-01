import java.util.Arrays;
import java.util.Scanner;

public class Solution735 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final String[] possibleWords = {"program", "piffpaff", "hajjaj", "nagyanyád", "szarombüfé", "nagyapámolaszvolt"};

        while (true) {
            final char[] wordToGuessInChars = pickRandomStringInArray(possibleWords).toCharArray();
            char[] asteriskArray = createAsteriskArray(wordToGuessInChars.length);
            int wrongGuessCounter = 0;

            while (true) {
                System.out.printf("(Guess) Enter a letter in word %s\n", Arrays.toString(asteriskArray));
                final char guess = Character.toLowerCase(input.next().charAt(0));

                if (Arrays.toString(wordToGuessInChars).contains(String.valueOf(guess))) {
                    for (int i = 0; i < wordToGuessInChars.length; i++) {
                        if (wordToGuessInChars[i] == guess) {
                            if (asteriskArray[i] == guess) {
                                System.out.printf("%c is already in the word\n", guess);
                                break;
                            } else {
                                asteriskArray[i] = guess;
                            }
                        }
                    }
                } else {
                    System.out.printf("%c is not in the word\n", guess);
                    wrongGuessCounter++;
                }

                if (Arrays.equals(asteriskArray, wordToGuessInChars)) {
                    System.out.printf("The word is %s. You missed %d times\n", String.valueOf(wordToGuessInChars), wrongGuessCounter);
                    break;
                }
            }

            System.out.println("Do you want to guess another word? Enter y or n");
            char continueOrNot = input.next().charAt(0);

            if (continueOrNot != 'y' && continueOrNot != 'n') {
                while (continueOrNot != 'y' && continueOrNot != 'n') {
                    System.out.println("Pick from y or n");
                    continueOrNot = input.next().charAt(0);
                }
            }

            if (continueOrNot == 'n') {
                break;
            }
        }
    }

    public static String pickRandomStringInArray(final String[] array) {
        final int randomIndexInArray = (int)(Math.random() * array.length);

        return array[randomIndexInArray];
    }

    public static char[] createAsteriskArray(final int length) {
        final char[] asteriskArray = new char[length];

        for (int i = 0; i < length; i++) {
            asteriskArray[i] = '*';
        }
        return asteriskArray;
    }

}
