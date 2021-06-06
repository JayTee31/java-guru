import java.util.Scanner;

public class Application72 {
    public static final String GREATER = "greater than the last element";
    public static final String EQUAL = "equal to the last element";
    public static final String SMALLER = "smaller than the last element";

    public static void main(String[] args) {
        final int NUMBER_OF_INPUTS = 11;
        final Scanner input = new Scanner(System.in);
        final int[] numbers = new int[NUMBER_OF_INPUTS];

        for (int i = 0; i < NUMBER_OF_INPUTS; i++) {
            numbers[i] = input.nextInt();
        }

        final String[] outcomeOfComparison = compareToTheLastElement(numbers);

        for (int i = 0; i < NUMBER_OF_INPUTS - 1; i++) {
            System.out.printf("%d is %s (%d)\n", numbers[i], outcomeOfComparison[i],
                    numbers[NUMBER_OF_INPUTS - 1]);
        }
    }

    public static String[] compareToTheLastElement(final int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Nekem te ne.");
        }

        if (numbers.length == 1) {
            throw new IllegalArgumentException("Van pisztácia?");
        }

        final String[] outcomeOfComparison = new String[numbers.length - 1];
        final int comparedTo = numbers[numbers.length - 1];

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > comparedTo) {
                outcomeOfComparison[i] = GREATER;
            } else if (numbers[i] == comparedTo) {
                outcomeOfComparison[i] = EQUAL;
            } else {
                outcomeOfComparison[i] = SMALLER;
            }
        }
        return outcomeOfComparison;
    }
}