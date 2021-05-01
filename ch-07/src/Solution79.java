import java.util.Scanner;

public class Solution79 {
    public static void main(String[] args) {
        final int NUMBER_OF_INPUTS = 10;
        final Scanner input = new Scanner(System.in);
        final double[] array = new double[NUMBER_OF_INPUTS];

        System.out.println("Enter ten numbers: ");

        for (int i = 0; i < NUMBER_OF_INPUTS; i++) {
            array[i] = input.nextDouble();
        }

        System.out.printf("The largest number is: %f", determineLargestElement(array));
    }

    public static double determineLargestElement(final double[] array) {
        double largestElement = array[0];

        for (double value : array) {
            if (largestElement < value) {
                largestElement = value;
            }
        }
        return largestElement;
    }
}
