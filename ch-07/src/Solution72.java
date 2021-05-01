import java.util.Scanner;

public class Solution72 {
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
        final String[] outcomeOfComparison = new String[numbers.length];
        final int comparedTo = numbers[numbers.length - 1];

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > comparedTo) {
                outcomeOfComparison[i] = "greater than the last element";
            } else if (numbers[i] == comparedTo) {
                outcomeOfComparison[i] = "equal to the last element";
            } else {
                outcomeOfComparison[i] = "smaller than the last element";
            }
        }
        return outcomeOfComparison;
    }
}
